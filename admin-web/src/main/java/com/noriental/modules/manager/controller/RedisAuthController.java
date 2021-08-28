package com.noriental.modules.manager.controller;

import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.R;
import com.noriental.common.validator.ValidatorUtils;
import com.noriental.modules.manager.bean.request.RedisAuthDelRequest;
import com.noriental.modules.manager.bean.request.RedisAuthRequest;
import com.noriental.modules.manager.bean.request.ZkDataListReqeustRedisZK;
import com.noriental.modules.manager.bean.response.RedisAuthResponse;
import com.noriental.modules.manager.service.RedisAuthService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：redis鉴权配置
 * *
 * *   @DATE    2019-12-31 19:32:24
 * *   @AUTHOR  Jing.Li
 ***/
@RestController
@RequestMapping("manager/redisauth")
public class RedisAuthController {
    @Autowired
    private RedisAuthService redisAuthService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("manager:redisauth:list")
    public R list(@RequestBody ZkDataListReqeustRedisZK reqeust) {
        PageResult page = redisAuthService.queryPage(reqeust);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}/{host}")
    @RequiresPermissions("manager:redisauth:info")
    public R info(@PathVariable("id") Long id, @PathVariable("host") String host) {
        RedisAuthResponse redisAuth = redisAuthService.getByIdFake(id, host);
        return R.ok().put("redisAuth", redisAuth);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("manager:redisauth:save")
    public R save(@RequestBody RedisAuthRequest redisAuth) {
        redisAuthService.save(redisAuth);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("manager:redisauth:update")
    public R update(@RequestBody RedisAuthRequest redisAuth) {
        ValidatorUtils.validateEntity(redisAuth);
        redisAuthService.update(redisAuth);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteByParam")
    @RequiresPermissions("manager:redisauth:delete")
    public R deleteByParam(@RequestBody RedisAuthDelRequest redisAuthRequest) {
        redisAuthService.delete(redisAuthRequest);
        return R.ok();
    }
}
