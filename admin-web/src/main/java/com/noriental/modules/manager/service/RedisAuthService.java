package com.noriental.modules.manager.service;

import com.noriental.common.utils.PageResult;
import com.noriental.modules.manager.bean.request.RedisAuthDelRequest;
import com.noriental.modules.manager.bean.request.RedisAuthRequest;
import com.noriental.modules.manager.bean.request.ZkDataListReqeustRedisZK;
import com.noriental.modules.manager.bean.response.RedisAuthResponse;

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
public interface RedisAuthService {

    /**
     * @param reqeust
     * @return
     */
    PageResult queryPage(ZkDataListReqeustRedisZK reqeust);

    /**
     * @param request
     * @return
     */
    boolean update(RedisAuthRequest request);

    /**
     * @param redisAuthRequest
     * @return
     */
    boolean delete(RedisAuthDelRequest redisAuthRequest);

    /**
     * @param redisAuth
     */
    void save(RedisAuthRequest redisAuth);

    /**
     * @param id
     * @param host
     * @return
     */
    RedisAuthResponse getByIdFake(Long id, String host);
}

