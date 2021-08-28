package com.noriental.modules.generator.entity;

import lombok.Data;

/**
 * 列的属性
 *
 * @author Jing.Li
 * @email ja_ckli@126.com
 * @date 2016年12月20日 上午12:01:45
 */
@Data
public class ColumnEntity {
    /**
     * 列名
     */
    private String columnName;
    /**
     * 列名类型
     */
    private String dataType;
    /**
     * 列名备注
     */
    private String comments;
    /**
     * 属性名称(第一个字母大写)，如：user_name => UserName
     */
    private String caseAttrName;
    /**
     * 属性名称(第一个字母小写)，如：user_name => userName
     */
    private String lowerAttrName;
    /**
     * 属性类型
     */
    private String attrType;
    /**
     * auto_increment
     */
    private String extra;
    /**
     * 字段类型
     */
    private String columnType;
    /**
     * 是否可以为空
     */
    private Boolean nullable;
    /**
     * 是否隐藏
     */
    private Boolean hidden;
}
