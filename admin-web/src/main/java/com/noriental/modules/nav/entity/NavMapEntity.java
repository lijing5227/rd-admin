package com.noriental.modules.nav.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 网站导航
 *
 * @author Jing.Li
 * @email ja_ckli@126.com
 * @date 2020-06-08 15:00:14
 */
@Data
@TableName("entity_nav_map")
public class NavMapEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 网站名称
	 */
	private String name;
	/**
	 * 网站链接
	 */
	private String link;
	/**
	 * 环境
	 */
	private String env;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

}
