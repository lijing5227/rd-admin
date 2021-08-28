/*
 *
 *  *  Copyright (c) 2019-2020, 冷冷 (wangiegie@gmail.com).
 *  *  <p>
 *  *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *  <p>
 *  * https://www.gnu.org/licenses/lgpl.html
 *  *  <p>
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.noriental.modules.generator.service.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.github.pagehelper.PageHelper;
import com.noriental.common.utils.PageResult;
import com.noriental.modules.generator.dao.GeneratorMapper;
import com.noriental.modules.generator.entity.GenConfig;
import com.noriental.modules.generator.service.GeneratorService;
import com.noriental.modules.generator.utils.CodeGenUtils;
import com.noriental.modules.generator.utils.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @author Jing.Li
 * @date 2018-07-30
 * <p>
 * 代码生成器
 */
@Service
@RequiredArgsConstructor
public class GeneratorServiceImpl implements GeneratorService {
    private final GeneratorMapper generatorMapper;

    @Override
    @DS("#last" )
    public PageResult queryList(Query query, String dsNameStr) {
        com.github.pagehelper.Page<?> page = PageHelper.startPage(query.getPage(), query.getLimit());
        List<Map<String, Object>> list = generatorMapper.queryList(query);
        int total = (int) page.getTotal();
        return new PageResult(list, total, query.getLimit(), query.getPage());
    }

    /**
     * 生成代码
     *
     * @param genConfig 生成配置
     * @return
     */
    @Override
    public byte[] generatorCode(GenConfig genConfig) {
        DynamicDataSourceContextHolder.push(genConfig.getDsName());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        String tableNames = genConfig.getTableName();
        for (String tableName : StrUtil.split(tableNames, StrUtil.COMMA)) {
            //查询表信息
            Map<String, String> table = generatorMapper.queryTable(tableName, genConfig.getDsName());
            //查询列信息
            List<Map<String, String>> columns = generatorMapper.queryColumns(tableName, genConfig.getDsName());
            //生成代码
            CodeGenUtils.generatorCode(genConfig, table, columns, zip);
        }
        IoUtil.close(zip);
        return outputStream.toByteArray();
    }
}
