package com.noriental.modules.manager.bean.enums;

/***
 * *   ____  ___________  ___________           ________   ____  __.  _____ _____.___.
 * *   \   \/  /\______ \ \_   _____/           \_____  \ |    |/ _| /  _  \\__  |   |
 * *    \     /  |    |  \ |    __)     ______   /   |   \|      <  /  /_\  \/   |   |
 * *    /     \  |    `   \|     \     /_____/  /    |    \    |  \/    |    \____   |
 * *   /___/\  \/_______  /\___  /              \_______  /____|__ \____|__  / ______|
 * *    	 \_/        \/     \/                       \/        \/       \/\/
 * *
 * *   功能描述：环境枚举
 * *
 * *   @DATE    2020/1/4
 * *   @AUTHOR  Jing.Li
 ***/
public enum EnvironmentEnum {
    DH("开发环境"),
    TH("测试环境"),
    PR("预发布环境"),
    GA("正式环境");

    private String desc;

    EnvironmentEnum(String desc) {
        this.desc = desc;
    }
}
