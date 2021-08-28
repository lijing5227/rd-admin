package com.noriental.modules.ds.controller;

import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.R;
import com.noriental.modules.ds.entity.DataSourceEntity;
import com.noriental.modules.ds.service.DataSourceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;


/**
 * 数据源管理
 *
 * @author Jing.Li
 * @email ja_ckli@126.com
 * @date 2020-06-08 16:21:47
 */
@RestController
@RequestMapping("ds/datasource")
public class DataSourceController {
    @Autowired
    private DataSourceService dataSourceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ds:datasource:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageResult page = dataSourceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("ds:datasource:info")
    public R info(@PathVariable("id") Long id) {
        DataSourceEntity dataSource = dataSourceService.getById(id);

        return R.ok().put("dataSource", dataSource);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ds:datasource:save")
    public R save(@RequestBody DataSourceEntity dataSource) {
        dataSourceService.save(dataSource);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ds:datasource:update")
    public R update(@RequestBody DataSourceEntity dataSource) {
        dataSourceService.updateById(dataSource);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ds:datasource:delete")
    public R delete(@RequestBody Long[] ids) {
        dataSourceService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 查询全部数据源
     *
     * @return
     */
    @GetMapping("/listAll")
    public R listAll() {
        return R.ok().put("data", dataSourceService.listAll());
    }

}
