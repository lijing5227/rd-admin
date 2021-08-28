package com.noriental.modules.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 项目表
 *
 * @author Jing.Li
 * @String 2020-09-14 16:01:06
 */
@Data
public class ProjectRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目级别
     */
    private Integer projectLevel;
    /**
     * 项目负责人
     */
    private String projectLeader;
    /**
     * 项目进度
     */
    private Integer projectProcess;
    /**
     * 0 待开发 1开发中 2开发完成 3联调 4 测试 5完成
     */
    private Integer projectState;
    /**
     * 项目上线时间
     */
    private String projectLanchTime;
    /**
     * 项目开发人员
     */
    private String projectDeveloper;
    /**
     * 研发负责人
     */
    private String rdLeader;
    /**
     * 产品负责人
     */
    private String pmLeader;
    /**
     * 研发开始时间
     */
    private String developStartTime;
    /**
     * 研发结束时间
     */
    private String developEndTime;
    /**
     * 联调开始时间
     */
    private String debugStartTime;
    /**
     * 联调结束时间
     */
    private String debugEndTime;
    /**
     * 测试开始时间
     */
    private String testStartTime;
    /**
     * 测试结束时间
     */
    private String testEndTime;
    /**
     * 项目开始时间
     */
    private String projectStartTime;
    /**
     * 项目结束时间
     */
    private String projectEndTime;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String upStringTime;

}
