package com.noriental.modules.nav.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.Query;
import com.noriental.modules.nav.dao.NavMapDao;
import com.noriental.modules.nav.entity.NavMapEntity;
import com.noriental.modules.nav.service.NavMapService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("navMapService")
public class NavMapServiceImpl extends ServiceImpl<NavMapDao, NavMapEntity> implements NavMapService {

    @Override
    public PageResult queryPage(Map<String, Object> params) {
        String paramKey = (String) params.get("key");
        String envKey = (String) params.get("env");
        IPage<NavMapEntity> page = this.page(
                new Query<NavMapEntity>().getPage(params),
                new QueryWrapper<NavMapEntity>().like(StringUtils.isNotBlank(paramKey), "name", paramKey).eq(StringUtils.isNotBlank(envKey), "env", envKey)
        );
        return new PageResult(page);
    }

    @Override
    public List<NavMapEntity> listbyEnv(String env) {
        QueryWrapper<NavMapEntity> query = new QueryWrapper<NavMapEntity>().eq("env", env);
        return baseMapper.selectList(query);
    }
}
