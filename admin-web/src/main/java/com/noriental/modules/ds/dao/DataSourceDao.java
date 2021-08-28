package com.noriental.modules.ds.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noriental.modules.ds.entity.DataSourceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源管理
 *
 * @author Jing.Li
 * @email ja_ckli@126.com
 * @date 2020-06-08 16:21:47
 */
@Mapper
public interface DataSourceDao extends BaseMapper<DataSourceEntity> {

}
