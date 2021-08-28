package com.noriental.modules.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noriental.common.utils.PageResult;
import com.noriental.modules.project.entity.LinkProjectDevelopEntity;

import java.util.Map;

/**
 * 项目开发人员关联表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:14
 */
public interface LinkProjectDevelopService extends IService<LinkProjectDevelopEntity> {

    PageResult queryPage(Map<String, Object> params);
}

