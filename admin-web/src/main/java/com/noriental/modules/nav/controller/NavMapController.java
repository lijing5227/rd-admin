package com.noriental.modules.nav.controller;

import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.R;
import com.noriental.common.validator.ValidatorUtils;
import com.noriental.modules.nav.entity.NavMapEntity;
import com.noriental.modules.nav.service.NavMapService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 网站导航
 *
 * @author Jing.Li
 * @email ja_ckli@126.com
 * @date 2020-06-08 15:00:14
 */
@RestController
@RequestMapping("nav/navmap")
public class NavMapController {
    @Autowired
    private NavMapService navMapService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("nav:navmap:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageResult page = navMapService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/listByEnv")
    @RequiresPermissions("nav:navmap:listByEnv")
    public R listByEnv(@RequestParam String env) {
        List<NavMapEntity> list = navMapService.listbyEnv(env);
        return R.ok().put("list", list);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("nav:navmap:info")
    public R info(@PathVariable("id") Long id) {
        NavMapEntity navMap = navMapService.getById(id);

        return R.ok().put("navMap", navMap);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("nav:navmap:save")
    public R save(@RequestBody NavMapEntity navMap) {
        navMap.setCreateTime(new Date());
        if (null == navMap.getOrderNum()) {
            navMap.setOrderNum(0);
        }
        navMapService.save(navMap);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("nav:navmap:update")
    public R update(@RequestBody NavMapEntity navMap) {
        ValidatorUtils.validateEntity(navMap);
        navMap.setUpdateTime(new Date());
        navMapService.updateById(navMap);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("nav:navmap:delete")
    public R delete(@RequestBody Long[] ids) {
        navMapService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
