package com.noriental.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 代码生成
 *
 * @author Jing.Li
 * @email ja_ckli@126.com
 * @date 2020-06-07 17:10:51
 */
@Data
@TableName("entity_generator")
public class EntityGeneratorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Integer id;
    /**
     * 表名
     */
    private String name;
    /**
     * 引擎
     */
    private String engine;
    /**
     * 表备注
     */
    private String comment;
    /**
     * 创建时间
     */
    private Date createTime;

}
