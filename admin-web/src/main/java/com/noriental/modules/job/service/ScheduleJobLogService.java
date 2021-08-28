/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.okay.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.noriental.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noriental.common.utils.PageResult;
import com.noriental.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author Jing.Li ja_ckli@126.com
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

    PageResult queryPage(Map<String, Object> params);

}
