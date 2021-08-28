package com.noriental.modules.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noriental.common.utils.PageResult;
import com.noriental.modules.project.entity.ProjectEntity;

import java.util.Map;

/**
 * 项目表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:25
 */
public interface ProjectService extends IService<ProjectEntity> {

    PageResult queryPage(Map<String, Object> params);
}

