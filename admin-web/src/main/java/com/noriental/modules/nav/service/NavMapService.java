package com.noriental.modules.nav.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noriental.common.utils.PageResult;
import com.noriental.modules.nav.entity.NavMapEntity;

import java.util.List;
import java.util.Map;

/**
 * 网站导航
 *
 * @author Jing.Li
 * @email ja_ckli@126.com
 * @date 2020-06-08 15:00:14
 */
public interface NavMapService extends IService<NavMapEntity> {

    PageResult queryPage(Map<String, Object> params);

    List<NavMapEntity> listbyEnv(String env);
}

