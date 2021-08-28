package com.noriental.modules.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目开发人员关联表
 *
 * @author Jing.Li
 * @date 2020-09-11 10:58:14
 */
@Data
@TableName("link_project_develop")
public class LinkProjectDevelopEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 项目id
	 */
	private Long projectId;
	/**
	 * 开发人员id
	 */
	private Long developId;
	/**
	 *
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
