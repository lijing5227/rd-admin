package com.noriental.modules.manager.zk;

import com.google.common.base.Charsets;
import com.noriental.modules.manager.exception.OkayException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.framework.api.GetDataBuilder;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：zk客户端工具类
 * *
 * *   @DATE    2019/12/6
 * *   @AUTHOR  Jing.Li
 ***/
@Service
public class CuratorClientHelper {
    private static Logger logger = LoggerFactory.getLogger(CuratorClientHelper.class);

    private volatile static CuratorFramework client;

    public static CuratorFramework getInstance(String zkAddress) {
        if (client == null) {
            synchronized (CuratorFramework.class) {
                if (client == null) {
                    client = CuratorFrameworkFactory.builder()
                            .connectString(zkAddress)
                            .sessionTimeoutMs(ZooKeeperConstant.ZK_SESSION_TIMEOUT)
                            .connectionTimeoutMs(ZooKeeperConstant.ZK_CONNECTION_TIMEOUT)
                            .retryPolicy(new ExponentialBackoffRetry(ZooKeeperConstant.ZK_RETRY_TIME, ZooKeeperConstant.ZK_RETRY_TIMES))
                            .build();
                    client.start();
                }
            }
        }
        return client;
    }

    /**
     * 创建节点
     *
     * @param nodeName
     * @param value
     * @return
     */
    public static boolean createNode(CuratorFramework client, String nodeName, String value) {
        boolean isSuccessFlag = false;
        try {
            Stat stat = client.checkExists().forPath(nodeName);
            if (stat == null) {
                String opResult = null;
                if (StringUtils.isEmpty(value)) {
                    opResult = client.create().creatingParentsIfNeeded().forPath(nodeName);
                } else {
                    opResult = client.create().creatingParentsIfNeeded().forPath(nodeName, value.getBytes(Charsets.UTF_8));
                }
                isSuccessFlag = StringUtils.pathEquals(nodeName, opResult);
            }
        } catch (Exception e) {
            logger.error("zk 创建node节点出错{}", e);
            throw new OkayException("zk 创建node节点出错", e);
        }

        return isSuccessFlag;
    }


    /**
     * 更新节点
     *
     * @param path
     * @param value
     * @return
     */

    public static boolean updateNode(CuratorFramework client, String path, String value) {
        boolean isSuccessFlag = false;
        try {
            Stat stat = client.checkExists().forPath(path);
            if (!ObjectUtils.isEmpty(stat)) {
                Stat returnResut = client.setData().forPath(path, value.getBytes(Charsets.UTF_8));
                if (!ObjectUtils.isEmpty(returnResut)) {
                    isSuccessFlag = true;
                }
            }
        } catch (Exception e) {
            logger.error("zk 更新node节点出错{}", e);
            throw new OkayException("zk 更新node节点出错", e);
        }
        return isSuccessFlag;

    }

    /**
     * 级联删除子节点
     *
     * @param path
     */
    public static void delNode(CuratorFramework client, String path) {
        try {
            client.delete().deletingChildrenIfNeeded().forPath(path);
        } catch (Exception e) {
            logger.error("节点删除异常{}", e);
            throw new OkayException("节点删除异常", e);
        }
    }

    /**
     * 获取指定节点下的所有子节点的名称与值
     *
     * @param path
     * @return
     */
    public static Map<String, String> showChildrenDetail(CuratorFramework client, String path) {
        Map<String, String> nodeMap = new HashMap<>(16);
        try {
            GetChildrenBuilder childrenBuilder = client.getChildren();
            List<String> childrenList = childrenBuilder.forPath(path);
            GetDataBuilder dataBuilder = client.getData();
            if (!CollectionUtils.isEmpty(childrenList)) {
                childrenList.forEach(item -> {
                    String propPath = ZKPaths.makePath(path, item);
                    try {
                        nodeMap.put(item, new String(dataBuilder.forPath(propPath), Charsets.UTF_8));
                    } catch (Exception e) {
                        logger.error("nodeMap 处理异常{}", e);
                        throw new OkayException("nodeMap 处理异常", e);
                    }
                });
            }
        } catch (Exception e) {
            logger.error("获取节点下子节点数据出错{}", e);
            throw new OkayException("获取节点下子节点数据出错", e);
        }
        return nodeMap;
    }

    /**
     * 列出节点下所有的子节点，但是不带子节点的数据
     *
     * @param path
     * @return
     */
    public static List<String> showChildren(CuratorFramework client, String path) {
        List<String> childenList = new ArrayList<>();
        try {
            GetChildrenBuilder childrenBuilder = client.getChildren();
            childenList = childrenBuilder.forPath(path);
        } catch (Exception e) {
            logger.error("获取子节点出错{}", e);
            throw new OkayException("获取子节点出错", e);
        }
        return childenList;
    }

    /**
     * 销毁资源
     */
    public static void destory() {
        if (client != null) {
            client.close();
        }
    }

    /**
     * 检查节点是否存在
     *
     * @param client
     * @param path
     * @return
     * @throws Exception
     */
    public static Boolean checkExists(CuratorFramework client, String path) {
        Stat stat = null;
        try {
            stat = client.checkExists().forPath(path);
        } catch (Exception e) {
            logger.error("zk检查节点出错{}", e);
            throw new OkayException("zk检查节点出错", e);
        }
        return stat != null;
    }

    public static byte[] getData(CuratorFramework client, String path) {
        byte[] bytes = null;
        try {
            bytes = client.getData().forPath(path);
        } catch (Exception e) {
            logger.error("zk获取数据出错{}", e);
            throw new OkayException("zk获取数据出错", e);
        }
        return bytes;
    }

}
