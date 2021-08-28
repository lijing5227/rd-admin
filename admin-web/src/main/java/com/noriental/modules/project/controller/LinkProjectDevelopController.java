package com.noriental.modules.project.controller;

import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.R;
import com.noriental.modules.project.entity.LinkProjectDevelopEntity;
import com.noriental.modules.project.service.LinkProjectDevelopService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 项目开发人员关联表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:14
 */
@RestController
@RequestMapping("project/linkprojectdevelop")
public class LinkProjectDevelopController {
    @Autowired
    private LinkProjectDevelopService linkProjectDevelopService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("project:linkprojectdevelop:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageResult page = linkProjectDevelopService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("project:linkprojectdevelop:info")
    public R info(@PathVariable("id") Long id) {
        LinkProjectDevelopEntity linkProjectDevelop = linkProjectDevelopService.getById(id);

        return R.ok().put("linkProjectDevelop", linkProjectDevelop);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("project:linkprojectdevelop:save")
    public R save(@RequestBody LinkProjectDevelopEntity linkProjectDevelop) {
        linkProjectDevelopService.save(linkProjectDevelop);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("project:linkprojectdevelop:update")
    public R update(@RequestBody LinkProjectDevelopEntity linkProjectDevelop) {
        linkProjectDevelopService.updateById(linkProjectDevelop);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("project:linkprojectdevelop:delete")
    public R delete(@RequestBody Long[] ids) {
        linkProjectDevelopService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
