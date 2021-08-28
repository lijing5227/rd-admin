package com.noriental.modules.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.Query;
import com.noriental.modules.project.entity.LinkProjectDevelopEntity;
import com.noriental.modules.project.mapper.LinkProjectDevelopMapper;
import com.noriental.modules.project.service.LinkProjectDevelopService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 项目开发人员关联表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:14
 */
@Service("linkProjectDevelopService")
public class LinkProjectDevelopServiceImpl extends ServiceImpl<LinkProjectDevelopMapper, LinkProjectDevelopEntity> implements LinkProjectDevelopService {

    @Override
    public PageResult queryPage(Map<String, Object> params) {
        IPage<LinkProjectDevelopEntity> page = this.page(
                new Query<LinkProjectDevelopEntity>().getPage(params),
                new QueryWrapper<LinkProjectDevelopEntity>()
        );

        return new PageResult(page);
    }

}