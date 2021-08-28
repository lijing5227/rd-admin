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
 * *   功能描述：zk节点获取
 * *
 * *   @DATE    2020/1/4
 * *   @AUTHOR  Jing.Li
 ***/
@Data
public class ZkDataListReqeustRedisZK extends RedisZKBaseReqeust {
    private Integer currentPage;

    private Integer pageSize;

    private String projectPath;

    private Boolean isPage = true;
}
