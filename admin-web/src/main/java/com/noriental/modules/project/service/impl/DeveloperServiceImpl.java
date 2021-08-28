package com.noriental.modules.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.Query;
import com.noriental.modules.project.entity.DeveloperEntity;
import com.noriental.modules.project.mapper.DeveloperMapper;
import com.noriental.modules.project.service.DeveloperService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 项目开发人员表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:31
 */
@Service("developerService")
public class DeveloperServiceImpl extends ServiceImpl<DeveloperMapper, DeveloperEntity> implements DeveloperService {

    @Override
    public PageResult queryPage(Map<String, Object> params) {
        IPage<DeveloperEntity> page = this.page(
                new Query<DeveloperEntity>().getPage(params),
                new QueryWrapper<DeveloperEntity>()
        );

        return new PageResult(page);
    }

}