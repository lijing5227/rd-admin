/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.okay.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.noriental.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noriental.common.utils.PageResult;
import com.noriental.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Jing.Li ja_ckli@126.com
 */
public interface SysOssService extends IService<SysOssEntity> {

    PageResult queryPage(Map<String, Object> params);
}
