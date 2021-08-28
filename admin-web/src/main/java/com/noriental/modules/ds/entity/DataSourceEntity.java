package com.noriental.modules.ds.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据源管理
 *
 * @author Jing.Li
 * @email ja_ckli@126.com
 * @date 2020-06-08 16:21:47
 */
@Data
@TableName("entity_data_source")
public class DataSourceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * jdbcurl
	 */
	private String url;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 删除标记(0 未删除 1 已删除)
	 */
	private Integer delFlag;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新
	 */
	private Date updateTime;

}
