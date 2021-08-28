package com.noriental.modules.project.beans.response;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JackLi
 * @description 项目返回参数
 * @date 2020/9/11 14:23
 */
@Data
public class ProjectResponse implements Serializable {
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
    private Date projectLanchTime;
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
     * 联调开始时间
     */
    private String debugStartTime;
    /**
     * 测试开始时间
     */
    private String testStartTime;
    /**
     * 项目开始时间
     */
    private String projectStartTime;
    /**
     * 备注
     */
    private String remarks;
}
