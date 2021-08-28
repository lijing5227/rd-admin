package com.noriental.modules.nav.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noriental.modules.nav.entity.NavMapEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 网站导航
 *
 * @author Jing.Li
 * @email ja_ckli@126.com
 * @date 2020-06-08 15:00:14
 */
@Mapper
public interface NavMapDao extends BaseMapper<NavMapEntity> {

}
