package com.noriental.modules.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noriental.common.utils.PageResult;
import com.noriental.modules.project.entity.DeveloperEntity;

import java.util.Map;

/**
 * 项目开发人员表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:31
 */
public interface DeveloperService extends IService<DeveloperEntity> {

    PageResult queryPage(Map<String, Object> params);
}

