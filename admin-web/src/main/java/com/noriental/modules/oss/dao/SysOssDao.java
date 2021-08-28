/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.okay.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.noriental.modules.oss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.noriental.modules.oss.entity.SysOssEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 *
 * @author Jing.Li ja_ckli@126.com
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {

}
