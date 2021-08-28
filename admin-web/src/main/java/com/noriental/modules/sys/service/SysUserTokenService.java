/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.okay.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.noriental.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noriental.common.utils.R;
import com.noriental.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 *
 * @author Jing.Li ja_ckli@126.com
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    /**
     * 生成token
     *
     * @param userId 用户ID
     */
    R createToken(long userId);

    /**
     * 退出，修改token值
     *
     * @param userId 用户ID
     */
    void logout(long userId);

}
