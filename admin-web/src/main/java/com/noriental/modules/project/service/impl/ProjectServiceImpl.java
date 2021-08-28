package com.noriental.modules.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noriental.common.utils.PageResult;
import com.noriental.common.utils.Query;
import com.noriental.modules.project.beans.response.ProjectResponse;
import com.noriental.modules.project.entity.ProjectEntity;
import com.noriental.modules.project.mapper.ProjectMapper;
import com.noriental.modules.project.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 项目表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:25
 */
@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, ProjectEntity> implements ProjectService {

    @Override
    public PageResult queryPage(Map<String, Object> params) {
        IPage<ProjectEntity> page = this.page(
                new Query<ProjectEntity>().getPage(params),
                new QueryWrapper<ProjectEntity>()
        );
        List<ProjectEntity> records = page.getRecords();
        if (CollectionUtil.isNotEmpty(records)) {
            List<ProjectResponse> list = new ArrayList<>(records.size());
            for (ProjectEntity record : records) {
                ProjectResponse projectResponse = new ProjectResponse();
                BeanUtil.copyProperties(record, projectResponse);
                Date developStartTime = record.getDevelopStartTime();
                Date developEndTime = record.getDevelopEndTime();
                Date debugStartTime = record.getDebugStartTime();
                Date debugEndTime = record.getDebugEndTime();
                Date testStartTime = record.getTestStartTime();
                Date testEndTime = record.getTestEndTime();
                // 字符串
                String devStartStr = DateUtil.formatDateTime(developStartTime);
                String devEndStr = DateUtil.formatDateTime(developEndTime);
                String debugStartStr = DateUtil.formatDateTime(debugStartTime);
                String debugEndStr = DateUtil.formatDateTime(debugEndTime);
                String testStartStr = DateUtil.formatDateTime(testStartTime);
                String testEndStr = DateUtil.formatDateTime(testEndTime);
                // 间隔时长
                if (null != developStartTime && null != developEndTime) {
                    long devDays = DateUtil.betweenDay(developStartTime, developEndTime, true);
                    String devReturnStr = devStartStr + "-" + devEndStr + "(" + devDays + "天" + ")";
                    projectResponse.setDevelopStartTime(devReturnStr);
                }
                if (null != debugStartTime && null != debugEndTime) {
                    long debugDays = DateUtil.betweenDay(debugStartTime, debugEndTime, true);
                    String debugReturnStr = debugStartStr + "-" + debugEndStr + "(" + debugDays + "天" + ")";
                    projectResponse.setDebugStartTime(debugReturnStr);
                }
                if (null != testStartTime && null != testEndTime) {
                    long testDays = DateUtil.betweenDay(testStartTime, testEndTime, true);
                    String testReturnStr = testStartStr + "-" + testEndStr + "(" + testDays + "天" + ")";
                    // 拼接字符串
                    projectResponse.setTestStartTime(testReturnStr);
                }
                list.add(projectResponse);
            }
            IPage<ProjectResponse> returnPage = new Page<>();
            returnPage.setRecords(list);
            returnPage.setPages(page.getPages());
            returnPage.setTotal(page.getTotal());
            returnPage.setCurrent(page.getCurrent());
            returnPage.setSize(page.getSize());
            return new PageResult(returnPage);
        }

        return new PageResult(page);
    }

}