/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.okay.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.noriental.common.utils;

/**
 * Redis所有Keys
 *
 * @author Jing.Li ja_ckli@126.com
 */
public class RedisKeys {

    public static String getSysConfigKey(String key) {
        return "sys:config:" + key;
    }
}