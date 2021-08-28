package com.noriental.modules.manager.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.noriental.common.utils.PageResult;
import com.noriental.modules.manager.bean.request.RedisAuthDelRequest;
import com.noriental.modules.manager.bean.request.RedisAuthRequest;
import com.noriental.modules.manager.bean.request.ZkDataListReqeustRedisZK;
import com.noriental.modules.manager.bean.response.RedisAuthResponse;
import com.noriental.modules.manager.service.RedisAuthService;
import com.noriental.modules.manager.utils.MD5Util;
import com.noriental.modules.manager.utils.MemoryPageUtil;
import com.noriental.modules.manager.zk.CuratorClientHelper;
import com.noriental.modules.manager.zk.EnvironmentFactory;
import com.noriental.modules.manager.zk.ZooKeeperConstant;
import org.apache.commons.lang.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


/**
 * @author Jing.Li
 */
@Service("redisAuthService")
public class RedisAuthServiceImpl implements RedisAuthService {
    private AtomicInteger count = new AtomicInteger(1);

    /**
     * 查询数据
     * 如果host为null直接返回
     * host不存在，新增
     *
     * @param reqeust
     * @return
     */
    @Override
    public PageResult queryPage(ZkDataListReqeustRedisZK reqeust) {
        String host = reqeust.getHost();
        if (StringUtils.isEmpty(host)) {
            return new PageResult(new Page<>());
        }
        if (!EnvironmentFactory.exist(host)) {
            EnvironmentFactory.setEnvironment(host);
        }
        Boolean isPage = reqeust.getIsPage();
        List<RedisAuthResponse> response = getRedisAuthResponses(host);
        int curPage = 1;
        int pageSize = Integer.MAX_VALUE;
        if (isPage) {
            curPage = reqeust.getCurrentPage();
            pageSize = reqeust.getPageSize();
        }
        String projectPath = reqeust.getProjectPath();
        if (StringUtils.isNotBlank(projectPath)) {
            response = response.stream().filter(node -> node.getProjectPath().equalsIgnoreCase(projectPath)).collect(Collectors.toList());
        }
        Page<RedisAuthResponse> page = MemoryPageUtil.getPage(response, curPage, pageSize);
        return new PageResult(page);
    }

    @Override
    public boolean update(RedisAuthRequest request) {
        String projectPath = request.getProjectPath();
        String environment = request.getEnvironment();
        String index = request.getIndex();
        String isIsolate = request.getIsIsolate();
        String prefix = request.getPrefix();
        String secretKey = MD5Util.MD5(projectPath);
        String data = secretKey + ":" + prefix + ":" + index + ":" + isIsolate;
        String path = ZooKeeperConstant.ZK_REDIS_NODE_ROOT + projectPath + "/" + environment;
        String host = request.getHost();
        CuratorFramework client = EnvironmentFactory.getEnvironment(host);
        return CuratorClientHelper.updateNode(client, path, data);
    }

    @Override
    public boolean delete(RedisAuthDelRequest request) {
        String projectName = request.getProjectPath();
        String environment = request.getEnvironment();
        String projectPath = ZooKeeperConstant.ZK_REDIS_NODE_ROOT + projectName;
        String path = projectPath + "/" + environment;
        String host = request.getHost();
        CuratorFramework client = EnvironmentFactory.getEnvironment(host);
        List<String> children = CuratorClientHelper.showChildren(client, projectPath);
        if (children.size() < 2) {
            path = projectPath;
        }
        CuratorClientHelper.delNode(client, path);
        return true;
    }

    @Override
    public void save(RedisAuthRequest request) {
        String projectPath = request.getProjectPath();
        if (!projectPath.contains(ZooKeeperConstant.ZK_NODE_PROJECT_PARENT)) {
            return;
        }
        String environment = request.getEnvironment();
        String index = request.getIndex();
        String secretKey = MD5Util.MD5(projectPath);
        String isIsolate = request.getIsIsolate();
        String prefix = request.getPrefix();
        String data = secretKey + ":" + prefix + ":" + index + ":" + isIsolate;
        String path = ZooKeeperConstant.ZK_REDIS_NODE_ROOT + projectPath + "/" + environment;
        String host = request.getHost();
        CuratorFramework client = EnvironmentFactory.getEnvironment(host);
        CuratorClientHelper.createNode(client, path, data);
    }

    @Override
    public RedisAuthResponse getByIdFake(Long id, String host) {
        List<RedisAuthResponse> response = getRedisAuthResponses(host);
        if (CollectionUtil.isEmpty(response)) {
            return new RedisAuthResponse();
        }
        return response.stream().filter(res -> res.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    private List<RedisAuthResponse> getRedisAuthResponses(String host) {
        CuratorFramework client = EnvironmentFactory.getEnvironment(host);
        boolean equals = client.getState().equals(CuratorFrameworkState.STARTED);
        String projectPath = ZooKeeperConstant.ZK_REDIS_NODE_ROOT + ZooKeeperConstant.ZK_NODE_PROJECT_PARENT;
        List<String> projectNode = CuratorClientHelper.showChildren(client, projectPath);
        List<RedisAuthResponse> response = new ArrayList<>(projectNode.size() * 4);
        for (String node : projectNode) {
            Map<String, String> envDataMap = CuratorClientHelper.showChildrenDetail(client, projectPath + "/" + node);
            initData(response, node, envDataMap);
        }
        count.set(1);
        return response;
    }

    /**
     * 遍历数据存放节点，组装数据返回
     *
     * @param response
     * @param node
     * @param envDataMap
     */
    private void initData(List<RedisAuthResponse> response, String node, Map<String, String> envDataMap) {
        for (String env : envDataMap.keySet()) {
            RedisAuthResponse redisAuth = new RedisAuthResponse();
            String data = envDataMap.get(env);
            if (StringUtils.isNotBlank(data)) {
                String[] dataString = data.split(":");
                if (dataString.length < 4) {
                    continue;
                }
                String md5 = dataString[0];
                String prefix = dataString[1];
                String index = dataString[2];
                redisAuth.setIsIsolate(dataString[3]);
                redisAuth.setPrefix(prefix);
                redisAuth.setSecretKey(md5);
                redisAuth.setIndex(index);
                redisAuth.setId(count.longValue());
                count.getAndIncrement();
            }
            redisAuth.setEnvironment(env);
            redisAuth.setProjectPath(ZooKeeperConstant.ZK_NODE_PROJECT_PARENT + "/" + node);
            response.add(redisAuth);
        }
    }

}
