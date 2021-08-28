package com.noriental.modules.manager.bean.request;

import lombok.Data;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：redis鉴权配置请求
 * *
 * *   @DATE    2019-12-31 19:32:24
 * *   @AUTHOR  Jing.Li
 ***/
@Data
public class RedisAuthUpdateRequest extends RedisZKBaseReqeust {
    private static final long serialVersionUID = 1L;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 环境
     */
    private String environment;

    /**
     * 下标
     */
    private String index;

    /**
     * 前缀
     */
    private String prefix;

    /**
     * 是否隔离
     */
    private String isIsolate;

}
