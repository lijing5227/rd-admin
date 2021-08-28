/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.okay.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.noriental.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noriental.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Jing.Li ja_ckli@126.com
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
