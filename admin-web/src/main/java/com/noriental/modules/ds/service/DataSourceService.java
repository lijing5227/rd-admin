package com.noriental.modules.ds.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noriental.common.utils.PageResult;
import com.noriental.modules.ds.entity.DataSourceEntity;

import java.util.List;
import java.util.Map;

/**
 * 数据源管理
 *
 * @author Jing.Li
 * @email ja_ckli@126.com
 * @date 2020-06-08 16:21:47
 */
public interface DataSourceService extends IService<DataSourceEntity> {

    PageResult queryPage(Map<String, Object> params);

    List listAll();
}

