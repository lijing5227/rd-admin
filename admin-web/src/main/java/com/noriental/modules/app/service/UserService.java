/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.okay.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.noriental.modules.app.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.noriental.modules.app.entity.UserEntity;
import com.noriental.modules.app.form.LoginForm;

/**
 * 用户
 *
 * @author Jing.Li ja_ckli@126.com
 */
public interface UserService extends IService<UserEntity> {

    UserEntity queryByMobile(String mobile);

    /**
     * 用户登录
     *
     * @param form 登录表单
     * @return 返回用户ID
     */
    long login(LoginForm form);
}
