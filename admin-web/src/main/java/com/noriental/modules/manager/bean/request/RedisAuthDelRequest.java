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
public class RedisAuthDelRequest extends RedisZKBaseReqeust {
    private static final long serialVersionUID = 1L;

    /**
     * 项目路径
     */
    private String projectPath;

    /**
     * 环境
     */
    private String environment;

}
