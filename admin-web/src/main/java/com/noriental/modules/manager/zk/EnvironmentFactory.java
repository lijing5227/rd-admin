package com.noriental.modules.manager.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：环境工厂
 * *
 * *   @DATE    2020/1/3
 * *   @AUTHOR  Jing.Li
 ***/
public class EnvironmentFactory {
    private static Map<String, CuratorFramework> environmentMap = new ConcurrentHashMap<>();

    static {
//        environmentMap.put(ZooKeeperConstant.LOCAL_ZK, initClient(ZooKeeperConstant.LOCAL_ZK));
//        environmentMap.put(ZooKeeperConstant.DEV_ZK, initClient(ZooKeeperConstant.DEV_ZK));
    }

    /**
     * 获取当前host的连接
     *
     * @param host
     * @return
     */
    public static CuratorFramework getEnvironment(String host) {
        if (EnvironmentFactory.environmentMap.containsKey(host)) {
            return EnvironmentFactory.environmentMap.get(host);
        }
        return null;
    }

    /**
     * 新增、当前host的连接
     *
     * @param host
     * @return
     */
    public static void setEnvironment(String host) {
        EnvironmentFactory.environmentMap.put(host, initClient(host));
    }

    /**
     * 移除当前环境
     *
     * @param host
     */
    public static void removeEnvironment(String host) {
        if (EnvironmentFactory.environmentMap.containsKey(host)) {
            CuratorFramework curatorFramework = EnvironmentFactory.environmentMap.get(host);
            curatorFramework.close();
            EnvironmentFactory.environmentMap.remove(host);
            return;
        }
    }

    /**
     * 获取所有环境
     *
     * @return
     */
    public static List<String> getHosts() {
        List<String> hosts = new ArrayList<>(6);
        EnvironmentFactory.environmentMap.forEach(
                (key, value) -> {
                    hosts.add(key);
                }
        );
        return hosts;
    }

    /**
     * 判断当前host是否存在
     *
     * @param host
     * @return
     */
    public static Boolean exist(String host) {
        return EnvironmentFactory.environmentMap.containsKey(host);
    }

    /**
     * 初始化zk客户端
     * ExponentialBackoffRetry：重试指定的次数, 且每一次重试之间停顿的时间逐渐增加
     * RetryNTimes：指定最大重试次数的重试策略
     * RetryOneTime：仅重试一次
     * RetryForever：永远重试
     * RetryUntilElapsed：一直重试直到达到规定的时间
     *
     * @param host
     * @return
     */
    private static CuratorFramework initClient(String host) {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(host)
                .sessionTimeoutMs(ZooKeeperConstant.ZK_SESSION_TIMEOUT)
                .connectionTimeoutMs(ZooKeeperConstant.ZK_CONNECTION_TIMEOUT)
                .retryPolicy(new ExponentialBackoffRetry(ZooKeeperConstant.ZK_RETRY_TIME, ZooKeeperConstant.ZK_RETRY_TIMES))
                .build();
        client.start();
        return client;
    }

    @PreDestroy
    private void destroy() {
        Map<String, CuratorFramework> environmentMap = EnvironmentFactory.environmentMap;
        if (!environmentMap.isEmpty()) {
            environmentMap.forEach((key, value) -> {
                if (value != null) {
                    value.close();
                }
            });
        }
    }

}
