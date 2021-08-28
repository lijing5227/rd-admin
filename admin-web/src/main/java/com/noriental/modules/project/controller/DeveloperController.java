package com.noriental.modules.project.controller;

import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.R;
import com.noriental.modules.project.entity.DeveloperEntity;
import com.noriental.modules.project.service.DeveloperService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 项目开发人员表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:31
 */
@RestController
@RequestMapping("project/developer")
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("project:developer:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageResult page = developerService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("project:developer:info")
    public R info(@PathVariable("id") Integer id) {
        DeveloperEntity developer = developerService.getById(id);

        return R.ok().put("developer", developer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("project:developer:save")
    public R save(@RequestBody DeveloperEntity developer) {
        developerService.save(developer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("project:developer:update")
    public R update(@RequestBody DeveloperEntity developer) {
        developerService.updateById(developer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("project:developer:delete")
    public R delete(@RequestBody Integer[] ids) {
        developerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
