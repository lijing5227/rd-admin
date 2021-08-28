package com.noriental.modules.manager.service;

import org.apache.curator.framework.CuratorFramework;

import java.util.List;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：Redis环境服务
 * *
 * *   @DATE    2020/1/3
 * *   @AUTHOR  Jing.Li
 ***/
public interface RedisEnvironmentService {
    /**
     * 新增环境
     */
    void save(String host);

    /**
     * 获取环境
     */
    CuratorFramework get(String host);

    /**
     * 删除环境
     */
    void delete(String host);

    /**
     * 销毁链接
     */
    void destroy(String host);

    /**
     * 获取环境列表
     *
     * @return
     */
    List<String> getHostList();

    /**
     * 获取环境列表
     *
     * @return
     */
    List listEnv();

}
