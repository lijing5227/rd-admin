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

package com.noriental.modules.generator.controller;

import cn.hutool.core.io.IoUtil;
import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.R;
import com.noriental.modules.generator.entity.GenConfig;
import com.noriental.modules.generator.service.GeneratorService;
import com.noriental.modules.generator.utils.Query;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 代码生成器
 *
 * @author Jing.Li
 * @date 2018-07-30
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/generator" )
@Api(value = "generator", tags = "代码生成模块" )
public class GeneratorController {
	private final GeneratorService generatorService;

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list" )
	@RequiresPermissions("sys:generator:list" )
	public R list(@RequestParam Map<String, Object> params) {
		Object dsName = params.get("dsName" );
		String dsNameStr = "";
		if (!ObjectUtils.isEmpty(dsName)) {
			dsNameStr = (String) dsName;
		}
		PageResult pageUtil = generatorService.queryList(new Query(params), dsNameStr);

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 生成代码
	 */
	@SneakyThrows
	@PostMapping("/code")
	public void generatorCode(@RequestBody GenConfig genConfig, HttpServletResponse response) {
		byte[] data = generatorService.generatorCode(genConfig);
		response.reset();
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.zip", genConfig.getTableName()));
		response.addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(data.length));
		response.setContentType("application/octet-stream; charset=UTF-8");
		IoUtil.write(response.getOutputStream(), Boolean.TRUE, data);
	}
}
