/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.okay.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.noriental.modules.oss.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.Query;
import com.noriental.modules.oss.dao.SysOssDao;
import com.noriental.modules.oss.entity.SysOssEntity;
import com.noriental.modules.oss.service.SysOssService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

    @Override
    public PageResult queryPage(Map<String, Object> params) {
        IPage<SysOssEntity> page = this.page(
                new Query<SysOssEntity>().getPage(params)
        );

        return new PageResult(page);
    }

}
