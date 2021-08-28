package com.noriental.modules.manager.service.impl;

import com.noriental.modules.manager.bean.enums.EnvironmentEnum;
import com.noriental.modules.manager.service.RedisEnvironmentService;
import com.noriental.modules.manager.zk.EnvironmentFactory;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：环境实现类
 * *
 * *   @DATE    2020/1/3
 * *   @AUTHOR  Jing.Li
 ***/
@Service
public class RedisEnvironmentServiceImpl implements RedisEnvironmentService {
    @Override
    public void save(String host) {
        EnvironmentFactory.getEnvironment(host);
    }

    @Override
    public void delete(String host) {
        EnvironmentFactory.removeEnvironment(host);
    }

    @Override
    public void destroy(String host) {
        EnvironmentFactory.getEnvironment(host).close();
    }

    @Override
    public CuratorFramework get(String host) {
        return EnvironmentFactory.getEnvironment(host);
    }

    @Override
    public List<String> getHostList() {
        return EnvironmentFactory.getHosts();
    }

    @Override
    public List listEnv() {
        return Arrays.asList(EnvironmentEnum.values()).stream().map(e -> e.name()).collect(Collectors.toList());
    }
}
