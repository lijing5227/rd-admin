package com.noriental.modules.manager.zk;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：zk常量
 * *
 * *   @DATE    2019/12/6
 * *   @AUTHOR  Jing.Li
 ***/
public class ZooKeeperConstant {
    /**
     * 连接超时时间
     */
    public static int ZK_CONNECTION_TIMEOUT = 3 * 1000;

    /**
     * 会话超时时间
     */
    public static int ZK_SESSION_TIMEOUT = 30 * 1000;

    /**
     * zk重试时间
     */
    public static int ZK_RETRY_TIME = 2000;

    /**
     * zk重试次数
     */
    public static int ZK_RETRY_TIMES = 3;

    /**
     * zk Redis配置根节点
     */
    public static String ZK_REDIS_NODE_ROOT = "/redis_zk";

    /**
     * zk Redis配置项目父节点
     */
    public static String ZK_NODE_PROJECT_PARENT = "/xdfapp";

    /**
     * 本地zk地址
     */
    public static String LOCAL_ZK = "localhost:2181";

    /**
     * 开发环境zk地址
     */
    public static String DEV_ZK = "10.60.0.63:2181";
}
