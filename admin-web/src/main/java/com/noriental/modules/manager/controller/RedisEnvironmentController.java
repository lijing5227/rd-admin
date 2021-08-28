package com.noriental.modules.manager.controller;

import com.noriental.common.utils.R;
import com.noriental.modules.manager.service.RedisEnvironmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
 * *   功能描述：redis环境
 * *
 * *   @DATE    2020/1/3
 * *   @AUTHOR  Jing.Li
 ***/
@RequestMapping("redis/env")
@RestController
public class RedisEnvironmentController {
    @Autowired
    private RedisEnvironmentService environmentService;

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        List list = environmentService.getHostList();
        return R.ok().put("list", list);
    }

    @GetMapping("/listEnv")
    public R listEnv() {
        List list = environmentService.listEnv();
        return R.ok().put("environments", list);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manager:redisauth:save")
    public R save(@RequestParam String host) {
        environmentService.save(host);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteByParam")
    @RequiresPermissions("manager:redisauth:delete")
    public R delete(@RequestParam String host) {
        environmentService.delete(host);
        return R.ok();
    }
}
