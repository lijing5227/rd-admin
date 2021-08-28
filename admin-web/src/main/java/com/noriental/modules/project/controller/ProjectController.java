package com.noriental.modules.project.controller;

import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.R;
import com.noriental.modules.project.entity.ProjectEntity;
import com.noriental.modules.project.service.ProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * 项目表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:25
 */
@RestController
@RequestMapping("project/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("project:project:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageResult page = projectService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("project:project:info")
    public R info(@PathVariable("id") Long id) {
        ProjectEntity project = projectService.getById(id);
        return R.ok().put("project", project);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("project:project:save")
    public R save(@RequestBody ProjectEntity project) {
        project.setCreateTime(new Date());
        projectService.save(project);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("project:project:update")
    public R update(@RequestBody ProjectEntity project) {
        projectService.updateById(project);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("project:project:delete")
    public R delete(@RequestBody Long[] ids) {
        projectService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

}
