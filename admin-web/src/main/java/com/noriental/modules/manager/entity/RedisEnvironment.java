package com.noriental.modules.manager.entity;

import lombok.Data;
import org.apache.curator.framework.CuratorFramework;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：Redis环境实体
 * *
 * *   @DATE    2020/1/3
 * *   @AUTHOR  Jing.Li
 ***/
@Data
public class RedisEnvironment {
    private String host;

    private CuratorFramework client;
}
