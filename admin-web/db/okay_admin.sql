/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : okay_admin

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-11-03 16:17:56
*/

SET
FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for entity_auth_redis
-- ----------------------------
DROP TABLE IF EXISTS `entity_auth_redis`;
CREATE TABLE `entity_auth_redis`
(
    `id`           bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
    `environment`  varchar(255) DEFAULT NULL COMMENT '环境',
    `secret_key`   varchar(255) DEFAULT NULL COMMENT '密钥',
    `index`        varchar(255) DEFAULT NULL COMMENT '数据库下标',
    `prefix`       varchar(255) DEFAULT NULL COMMENT '前缀',
    `is_isolate`   varchar(255) DEFAULT NULL COMMENT '是否隔离',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='redis管理';

-- ----------------------------
-- Records of entity_auth_redis
-- ----------------------------

-- ----------------------------
-- Table structure for entity_data_source
-- ----------------------------
DROP TABLE IF EXISTS `entity_data_source`;
CREATE TABLE `entity_data_source`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`        varchar(255)                                                  DEFAULT NULL COMMENT '名称',
    `url`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'jdbcurl',
    `username`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
    `password`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码',
    `del_flag`    tinyint(1) DEFAULT '0' COMMENT '删除标记',
    `create_time` datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='数据源管理';

-- ----------------------------
-- Records of entity_data_source
-- ----------------------------
INSERT INTO `entity_data_source`
VALUES ('1', 'local_okay_admin',
        'jdbc:mysql://localhost:3306/okay_admin?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai',
        'root', 'UtROEWZnI7ZQYVN8NK6N3A==', '0', '2020-06-08 19:18:18', '2020-06-14 21:26:03');
INSERT INTO `entity_data_source`
VALUES ('2', 'local_mall_cloud',
        'jdbc:mysql://localhost:3306/mallcloud?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai',
        'root', 'y/hg8ZC0sshQXQmyQRy0cA==', '0', '2020-06-14 21:27:15', '2020-06-14 21:27:15');
INSERT INTO `entity_data_source`
VALUES ('3', 'local_neworiental_user',
        'jdbc:mysql://localhost:3306/neworiental_user?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai',
        'root', '2WONRM9plO51W+Uk6by3tQ==', '0', '2020-07-08 14:01:12', '2020-07-08 14:01:11');
INSERT INTO `entity_data_source`
VALUES ('4', 'dev-user',
        'jdbc:mysql://10.60.0.36:3306/neworiental_user?useUnicode=true&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&useSSL=true',
        'admin', 'kfgQC/r6OgUIMn4uOJcgMxpCoVyfaNyc', '0', '2020-08-31 16:10:44', '2020-08-31 16:10:44');

-- ----------------------------
-- Table structure for entity_developer
-- ----------------------------
DROP TABLE IF EXISTS `entity_developer`;
CREATE TABLE `entity_developer`
(
    `id`          int         NOT NULL AUTO_INCREMENT COMMENT '主键',
    `dev_name`    varchar(20) NOT NULL COMMENT '开发人员姓名',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目开发人员表';

-- ----------------------------
-- Records of entity_developer
-- ----------------------------
INSERT INTO `entity_developer`
VALUES ('1', '曹林', '2020-09-11 13:28:32', '2020-09-11 13:28:32');
INSERT INTO `entity_developer`
VALUES ('2', '高梦娇', '2020-09-11 13:28:47', '2020-09-11 13:28:47');

-- ----------------------------
-- Table structure for entity_generator
-- ----------------------------
DROP TABLE IF EXISTS `entity_generator`;
CREATE TABLE `entity_generator`
(
    `id`          int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '表名',
    `engine`      varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '引擎',
    `comment`     varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '表备注',
    `create_time` datetime                                                      DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='代码生成';

-- ----------------------------
-- Records of entity_generator
-- ----------------------------

-- ----------------------------
-- Table structure for entity_nav_map
-- ----------------------------
DROP TABLE IF EXISTS `entity_nav_map`;
CREATE TABLE `entity_nav_map`
(
    `id`          bigint   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`        varchar(255)      DEFAULT NULL COMMENT '网站名称',
    `link`        varchar(255)      DEFAULT NULL COMMENT '网站链接',
    `env`         varchar(255)      DEFAULT NULL COMMENT '环境',
    `order_num`   int               DEFAULT NULL COMMENT '排序',
    `remark`      varchar(255)      DEFAULT NULL COMMENT '备注',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='网站导航';

-- ----------------------------
-- Records of entity_nav_map
-- ----------------------------
INSERT INTO `entity_nav_map`
VALUES ('1', '教师空间', 'http://xin.jiaoshi.xk12.cn/', 'dev', '10', '账号： 密码：', '2020-06-08 13:48:59',
        '2020-10-28 10:24:41');
INSERT INTO `entity_nav_map`
VALUES ('2', '学生空间', 'http://xin-student.xk12.cn/', 'dev', '10', null, '2020-06-08 13:48:59', '2020-06-08 18:35:54');
INSERT INTO `entity_nav_map`
VALUES ('3', '机构后台', 'http://xin.private.xk12.cn/', 'dev', '10', null, '2020-06-08 13:48:59', '2020-06-08 18:35:56');
INSERT INTO `entity_nav_map`
VALUES ('4', '教师空间', 'https://jiaoshi-dev.xk12.cn/', 'docker-dev', '20', null, '2020-06-08 13:48:59',
        '2020-10-28 10:36:13');
INSERT INTO `entity_nav_map`
VALUES ('5', '学生空间', 'https://student-dev.xk12.cn/', 'docker-dev', '20', null, '2020-06-08 13:48:59',
        '2020-10-28 10:36:21');
INSERT INTO `entity_nav_map`
VALUES ('6', '机构后台', 'https://jigou-dev.xk12.cn/', 'docker-dev', '20', null, '2020-06-08 13:48:59',
        '2020-10-28 10:36:31');
INSERT INTO `entity_nav_map`
VALUES ('7', '教师空间', 'https://jiaoshi-hotfix.xk12.cn/', 'docker-hotfix', '20', null, '2020-06-08 13:48:59',
        '2020-10-28 10:36:46');
INSERT INTO `entity_nav_map`
VALUES ('8', '学生空间', 'https://student-hotfix.xk12.cn/', 'docker-hotfix', '20', null, '2020-06-08 13:48:59',
        '2020-10-28 10:36:59');
INSERT INTO `entity_nav_map`
VALUES ('9', '机构后台', 'https://jigou-hotfix.xk12.cn/', 'docker-hotfix', '20', null, '2020-06-08 13:48:59',
        '2020-10-28 10:37:15');
INSERT INTO `entity_nav_map`
VALUES ('10', '教师空间', 'https://jiaoshi.okjiaoyu.cn/', 'prod', '30', null, '2020-06-08 13:48:59', '2020-06-08 18:36:17');
INSERT INTO `entity_nav_map`
VALUES ('11', '学生空间', 'https://student.okjiaoyu.cn/', 'prod', '30', null, '2020-06-08 13:48:59', '2020-06-08 18:36:15');
INSERT INTO `entity_nav_map`
VALUES ('12', '机构后台', 'https://jigou.okjiaoyu.cn/', 'prod', '30', null, '2020-06-08 13:48:59', '2020-06-08 18:36:18');
INSERT INTO `entity_nav_map`
VALUES ('13', 'Rancher 管理平台', 'https://rancher.xk12.cn/login', 'docker-dev', '20', null, '2020-06-08 13:48:59',
        '2020-10-28 10:21:25');
INSERT INTO `entity_nav_map`
VALUES ('14', '配置中心', 'http://zk.xk12.cn/', 'docker-dev', '20', null, '2020-06-08 13:48:59', '2020-10-28 10:21:25');
INSERT INTO `entity_nav_map`
VALUES ('15', 'ZK管理工具', 'http://10.60.0.46:9999/', 'dev', '10', null, '2020-06-08 13:48:59', '2020-06-08 18:35:57');
INSERT INTO `entity_nav_map`
VALUES ('16', 'Moco', 'http://moco.okjiaoyu.cn/', 'dev', '0', null, '2020-06-08 13:48:59', '2020-10-28 10:52:33');
INSERT INTO `entity_nav_map`
VALUES ('17', '配置中心', 'http://10.60.0.64:8081/', 'dev', '10', null, '2020-06-08 18:34:40', '2020-06-08 18:35:59');
INSERT INTO `entity_nav_map`
VALUES ('18', 'Family', 'http://family.okjiaoyu.cn/#/login', 'dev', '0', null, '2020-06-08 18:37:00',
        '2020-10-28 10:52:08');
INSERT INTO `entity_nav_map`
VALUES ('19', 'Wiki', 'http://wiki.okjiaoyu.cn/dashboard.action', 'dev', '0', null, '2020-06-08 18:38:00',
        '2020-10-28 10:52:15');
INSERT INTO `entity_nav_map`
VALUES ('20', 'Gitlab', 'http://git.okjiaoyu.cn/users/sign_in', 'dev', '0', null, '2020-06-08 18:38:27',
        '2020-10-28 10:52:23');
INSERT INTO `entity_nav_map`
VALUES ('21', 'Relay跳板机', 'http://relay.okjiaoyu.cn/', 'prod', '0', null, '2020-06-08 18:39:34', '2020-10-28 10:53:04');
INSERT INTO `entity_nav_map`
VALUES ('22', 'Solr 开发控制台', 'http://10.60.0.157:7002/solr/#/~cloud', 'dev', '10', null, '2020-06-09 18:26:02',
        '2020-06-10 09:33:41');
INSERT INTO `entity_nav_map`
VALUES ('23', 'Solr 线上控制台', 'http://solr86.okjiaoyu.cn/solr/#/', 'prod', '30', null, '2020-06-09 18:26:40',
        '2020-06-10 09:34:02');
INSERT INTO `entity_nav_map`
VALUES ('24', 'RabbitMQ 控制台', 'http://10.60.0.67:15555/', 'dev', '10', null, '2020-06-09 18:27:46',
        '2020-06-10 09:33:38');
INSERT INTO `entity_nav_map`
VALUES ('25', 'Solr控制台', 'http://solrui-dev.xk12.cn/solr/#/', 'docker-dev', '20', '用户名：solradmin 密码：Okay@123!@#',
        '2020-06-09 18:28:18', '2020-10-28 10:38:05');
INSERT INTO `entity_nav_map`
VALUES ('26', '极光', 'https://www.jiguang.cn/', 'dev', '0', '用户名：okay@okjiaoyu.cn  密码：0l9k8jpoi', '2020-06-09 18:29:08',
        '2020-10-28 10:35:17');
INSERT INTO `entity_nav_map`
VALUES ('27', 'Redis 管理平台', 'http://redis-manager.xk12.cn/login', 'tool', '0', 'common / Oi3sL+2=eyIrd',
        '2020-06-09 18:31:08', '2020-06-10 09:33:46');
INSERT INTO `entity_nav_map`
VALUES ('28', 'RabbitMQ', 'https://rabbitmq-dev.xk12.cn/#/', 'docker-dev', '20', '用户名/密码 guest/guest  ',
        '2020-06-09 18:33:08', '2020-10-28 10:44:51');
INSERT INTO `entity_nav_map`
VALUES ('29', 'Kibana', 'http://kibana-hotfix.xk12.cn/app/kibana#/home?_g=()', 'docker-dev', '20', null,
        '2020-06-09 18:34:00', '2020-10-28 10:37:56');
INSERT INTO `entity_nav_map`
VALUES ('30', '禅道', 'http://bug.okjiaoyu.cn/index.php', 'tool', '0', null, '2020-06-09 18:35:10',
        '2020-06-10 09:33:58');
INSERT INTO `entity_nav_map`
VALUES ('32', 'Canal 控制台', 'http://10.60.0.82:28089/', 'dev', '10', 'admin / 123456', '2020-06-10 09:43:59',
        '2020-06-10 09:43:59');
INSERT INTO `entity_nav_map`
VALUES ('33', '腾讯QQ企业邮箱', 'https://exmail.qq.com/cgi-bin/loginpage', 'dev', '0', null, '2020-06-10 09:46:55',
        '2020-10-28 10:52:54');
INSERT INTO `entity_nav_map`
VALUES ('35', 'Dubbo Monitor 监控', 'http://10.60.0.46:9990/', 'dev', '10', null, '2020-06-10 09:51:39',
        '2020-06-10 09:51:39');
INSERT INTO `entity_nav_map`
VALUES ('36', 'Dubbo Monitor  线上监控', 'http://dubbo-monitor.okjiaoyu.cn/services.html', 'prod', '30', null,
        '2020-06-10 09:52:18', '2020-06-10 09:52:18');
INSERT INTO `entity_nav_map`
VALUES ('37', 'Skywalking 链路', 'http://skywalking.okjiaoyu.cn/', 'prod', '30', null, '2020-06-11 10:09:47',
        '2020-06-11 10:09:47');
INSERT INTO `entity_nav_map`
VALUES ('38', '线上solr 控制台', 'http://10.10.9.160:8982/', 'prod', '30', null, '2020-06-29 15:44:04',
        '2020-06-29 15:44:04');
INSERT INTO `entity_nav_map`
VALUES ('39', '校后台', 'http://xin-sso.xk12.cn/login?service=http%3A%2F%2Fxin.public.xk12.cn%2F', 'dev', '10',
        '61951237320 Okay@123', '2020-07-03 11:25:28', '2020-07-03 11:25:28');
INSERT INTO `entity_nav_map`
VALUES ('40', 'ok-job调度中心', 'http://10.60.0.18:8090/okay-job-admin/', 'dev', '10', 'admin/123456',
        '2020-07-03 18:09:15', '2020-07-03 18:09:15');
INSERT INTO `entity_nav_map`
VALUES ('41', 'ok-job调度中心', 'http://okjob-dev.xk12.cn/okay-job-admin/', 'docker-dev', '20', 'admin/123456',
        '2020-07-03 18:10:10', '2020-10-28 10:35:02');
INSERT INTO `entity_nav_map`
VALUES ('42', 'ok-job调度中心', 'http://okjob.okjiaoyu.cn/okay-job-admin/', 'prod', '30', '', '2020-07-03 18:10:43',
        '2020-07-03 18:10:43');
INSERT INTO `entity_nav_map`
VALUES ('43', 'oms', 'http://oms-xin.xk12.cn', 'dev', null, 'oms开发环境', '2020-07-21 15:20:19', '2020-07-21 15:20:19');
INSERT INTO `entity_nav_map`
VALUES ('44', 'Dubbo Monitor 监控', 'http://dubbo-monitor-dev.xk12.cn/', 'docker-dev', null, 'Dubbo Monitor 监控 (qa-dev)',
        '2020-10-15 15:30:40', '2020-10-28 10:38:29');
INSERT INTO `entity_nav_map`
VALUES ('45', 'ok-job调度中心', 'http://okjob-stress.xk12.cn/okay-job-admin/jobgroup', 'docker-stress', '0',
        '账号密码admin admin', '2020-11-02 16:53:57', '2020-11-02 16:53:57');

-- ----------------------------
-- Table structure for entity_project
-- ----------------------------
DROP TABLE IF EXISTS `entity_project`;
CREATE TABLE `entity_project`
(
    `id`                 bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `project_name`       varchar(100)                                                  NOT NULL DEFAULT '' COMMENT '项目名称',
    `project_level`      tinyint unsigned NOT NULL DEFAULT '2' COMMENT '项目级别',
    `project_leader`     varchar(100)                                                  NOT NULL DEFAULT '' COMMENT '项目负责人',
    `project_process`    int unsigned NOT NULL DEFAULT '0' COMMENT '项目进度',
    `project_state`      tinyint unsigned NOT NULL DEFAULT '0' COMMENT '0 待开发 1开发中 2开发完成 3联调 4 测试 5完成',
    `project_lanch_time` datetime                                                               DEFAULT NULL COMMENT '项目上线时间',
    `project_developer`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '项目开发人员',
    `rd_leader`          varchar(100)                                                  NOT NULL DEFAULT '' COMMENT '研发负责人',
    `pm_leader`          varchar(100)                                                  NOT NULL DEFAULT '' COMMENT '产品负责人',
    `develop_start_time` datetime                                                               DEFAULT NULL COMMENT '研发开始时间',
    `develop_end_time`   datetime                                                               DEFAULT NULL COMMENT '研发结束时间',
    `debug_start_time`   datetime                                                               DEFAULT NULL COMMENT '联调开始时间',
    `debug_end_time`     datetime                                                               DEFAULT NULL COMMENT '联调结束时间',
    `test_start_time`    datetime                                                               DEFAULT NULL COMMENT '测试开始时间',
    `test_end_time`      datetime                                                               DEFAULT NULL COMMENT '测试结束时间',
    `project_start_time` datetime                                                               DEFAULT NULL COMMENT '项目开始时间',
    `project_end_time`   datetime                                                               DEFAULT NULL COMMENT '项目结束时间',
    `remarks`            varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT '' COMMENT '备注',
    `create_time`        datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`        datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目表';

-- ----------------------------
-- Records of entity_project
-- ----------------------------
INSERT INTO `entity_project`
VALUES ('1', '1', '3', '1', '0', '5', '2020-09-14 00:00:00', '', '', '', null, null, null, null, null, null, null, null,
        '', '2020-09-14 17:43:14', '2020-09-14 17:43:14');
INSERT INTO `entity_project`
VALUES ('2', '测试', '0', '', '0', '0', '2020-10-29 00:00:00', '', '', '', null, null, null, null, null, null, null, null,
        '', '2020-10-27 20:01:42', '2020-10-27 20:01:42');

-- ----------------------------
-- Table structure for link_project_develop
-- ----------------------------
DROP TABLE IF EXISTS `link_project_develop`;
CREATE TABLE `link_project_develop`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `project_id`  bigint unsigned NOT NULL COMMENT '项目id',
    `develop_id`  bigint unsigned NOT NULL COMMENT '开发人员id',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目开发人员关联表';

-- ----------------------------
-- Records of link_project_develop
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`
(
    `SCHED_NAME`    varchar(120) NOT NULL,
    `TRIGGER_NAME`  varchar(200) NOT NULL,
    `TRIGGER_GROUP` varchar(200) NOT NULL,
    `BLOB_DATA`     blob,
    PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`),
    KEY             `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
    CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`
(
    `SCHED_NAME`    varchar(120) NOT NULL,
    `CALENDAR_NAME` varchar(200) NOT NULL,
    `CALENDAR`      blob         NOT NULL,
    PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`
(
    `SCHED_NAME`      varchar(120) NOT NULL,
    `TRIGGER_NAME`    varchar(200) NOT NULL,
    `TRIGGER_GROUP`   varchar(200) NOT NULL,
    `CRON_EXPRESSION` varchar(120) NOT NULL,
    `TIME_ZONE_ID`    varchar(80) DEFAULT NULL,
    PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`),
    CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers`
VALUES ('okayScheduler', 'TASK_1', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`
(
    `SCHED_NAME`        varchar(120) NOT NULL,
    `ENTRY_ID`          varchar(95)  NOT NULL,
    `TRIGGER_NAME`      varchar(200) NOT NULL,
    `TRIGGER_GROUP`     varchar(200) NOT NULL,
    `INSTANCE_NAME`     varchar(200) NOT NULL,
    `FIRED_TIME`        bigint       NOT NULL,
    `SCHED_TIME`        bigint       NOT NULL,
    `PRIORITY`          int          NOT NULL,
    `STATE`             varchar(16)  NOT NULL,
    `JOB_NAME`          varchar(200) DEFAULT NULL,
    `JOB_GROUP`         varchar(200) DEFAULT NULL,
    `IS_NONCONCURRENT`  varchar(1)   DEFAULT NULL,
    `REQUESTS_RECOVERY` varchar(1)   DEFAULT NULL,
    PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`),
    KEY                 `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
    KEY                 `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
    KEY                 `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
    KEY                 `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
    KEY                 `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
    KEY                 `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`
(
    `SCHED_NAME`        varchar(120) NOT NULL,
    `JOB_NAME`          varchar(200) NOT NULL,
    `JOB_GROUP`         varchar(200) NOT NULL,
    `DESCRIPTION`       varchar(250) DEFAULT NULL,
    `JOB_CLASS_NAME`    varchar(250) NOT NULL,
    `IS_DURABLE`        varchar(1)   NOT NULL,
    `IS_NONCONCURRENT`  varchar(1)   NOT NULL,
    `IS_UPDATE_DATA`    varchar(1)   NOT NULL,
    `REQUESTS_RECOVERY` varchar(1)   NOT NULL,
    `JOB_DATA`          blob,
    PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`),
    KEY                 `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
    KEY                 `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details`
VALUES ('okayScheduler', 'TASK_1', 'DEFAULT', null, 'com.noriental.modules.job.utils.ScheduleJob', '0', '0', '0', '0',
        0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720032636F6D2E6E6F7269656E74616C2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000172837BDBC07874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017400046F6B617974000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`
(
    `SCHED_NAME` varchar(120) NOT NULL,
    `LOCK_NAME`  varchar(40)  NOT NULL,
    PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks`
VALUES ('okayScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks`
VALUES ('okayScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`
(
    `SCHED_NAME`    varchar(120) NOT NULL,
    `TRIGGER_GROUP` varchar(200) NOT NULL,
    PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`
(
    `SCHED_NAME`        varchar(120) NOT NULL,
    `INSTANCE_NAME`     varchar(200) NOT NULL,
    `LAST_CHECKIN_TIME` bigint       NOT NULL,
    `CHECKIN_INTERVAL`  bigint       NOT NULL,
    PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state`
VALUES ('okayScheduler', 'legion1600074242015', '1600075564177', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`
(
    `SCHED_NAME`      varchar(120) NOT NULL,
    `TRIGGER_NAME`    varchar(200) NOT NULL,
    `TRIGGER_GROUP`   varchar(200) NOT NULL,
    `REPEAT_COUNT`    bigint       NOT NULL,
    `REPEAT_INTERVAL` bigint       NOT NULL,
    `TIMES_TRIGGERED` bigint       NOT NULL,
    PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`),
    CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`
(
    `SCHED_NAME`    varchar(120) NOT NULL,
    `TRIGGER_NAME`  varchar(200) NOT NULL,
    `TRIGGER_GROUP` varchar(200) NOT NULL,
    `STR_PROP_1`    varchar(512)   DEFAULT NULL,
    `STR_PROP_2`    varchar(512)   DEFAULT NULL,
    `STR_PROP_3`    varchar(512)   DEFAULT NULL,
    `INT_PROP_1`    int            DEFAULT NULL,
    `INT_PROP_2`    int            DEFAULT NULL,
    `LONG_PROP_1`   bigint         DEFAULT NULL,
    `LONG_PROP_2`   bigint         DEFAULT NULL,
    `DEC_PROP_1`    decimal(13, 4) DEFAULT NULL,
    `DEC_PROP_2`    decimal(13, 4) DEFAULT NULL,
    `BOOL_PROP_1`   varchar(1)     DEFAULT NULL,
    `BOOL_PROP_2`   varchar(1)     DEFAULT NULL,
    PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`),
    CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`
(
    `SCHED_NAME`     varchar(120) NOT NULL,
    `TRIGGER_NAME`   varchar(200) NOT NULL,
    `TRIGGER_GROUP`  varchar(200) NOT NULL,
    `JOB_NAME`       varchar(200) NOT NULL,
    `JOB_GROUP`      varchar(200) NOT NULL,
    `DESCRIPTION`    varchar(250) DEFAULT NULL,
    `NEXT_FIRE_TIME` bigint       DEFAULT NULL,
    `PREV_FIRE_TIME` bigint       DEFAULT NULL,
    `PRIORITY`       int          DEFAULT NULL,
    `TRIGGER_STATE`  varchar(16)  NOT NULL,
    `TRIGGER_TYPE`   varchar(8)   NOT NULL,
    `START_TIME`     bigint       NOT NULL,
    `END_TIME`       bigint       DEFAULT NULL,
    `CALENDAR_NAME`  varchar(200) DEFAULT NULL,
    `MISFIRE_INSTR`  smallint     DEFAULT NULL,
    `JOB_DATA`       blob,
    PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`),
    KEY              `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
    KEY              `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
    KEY              `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
    KEY              `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
    KEY              `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
    KEY              `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
    KEY              `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
    KEY              `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
    KEY              `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
    KEY              `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
    KEY              `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
    KEY              `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
    CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers`
VALUES ('okayScheduler', 'TASK_1', 'DEFAULT', 'TASK_1', 'DEFAULT', null, '1591344000000', '-1', '5', 'PAUSED', 'CRON',
        '1591343866000', '0', null, '2',
        0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720032636F6D2E6E6F7269656E74616C2E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200074C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000172837BDBC07874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000000000017400046F6B617974000CE58F82E695B0E6B58BE8AF95737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job`
(
    `job_id`          bigint NOT NULL AUTO_INCREMENT COMMENT '任务id',
    `bean_name`       varchar(200)  DEFAULT NULL COMMENT 'spring bean名称',
    `params`          varchar(2000) DEFAULT NULL COMMENT '参数',
    `cron_expression` varchar(100)  DEFAULT NULL COMMENT 'cron表达式',
    `status`          tinyint       DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
    `remark`          varchar(255)  DEFAULT NULL COMMENT '备注',
    `create_time`     datetime      DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job`
VALUES ('1', 'testTask', 'okay', '0 0/30 * * * ?', '1', '参数测试', '2020-06-05 15:57:12');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log`
(
    `log_id`      bigint  NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
    `job_id`      bigint  NOT NULL COMMENT '任务id',
    `bean_name`   varchar(200)  DEFAULT NULL COMMENT 'spring bean名称',
    `params`      varchar(2000) DEFAULT NULL COMMENT '参数',
    `status`      tinyint NOT NULL COMMENT '任务状态    0：成功    1：失败',
    `error`       varchar(2000) DEFAULT NULL COMMENT '失败信息',
    `times`       int     NOT NULL COMMENT '耗时(单位：毫秒)',
    `create_time` datetime      DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`log_id`),
    KEY           `job_id` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log`
VALUES ('1', '1', 'testTask', 'okay', '0', null, '1', '2020-06-05 16:00:00');

-- ----------------------------
-- Table structure for sys_captcha
-- ----------------------------
DROP TABLE IF EXISTS `sys_captcha`;
CREATE TABLE `sys_captcha`
(
    `uuid`        char(36)   NOT NULL COMMENT 'uuid',
    `code`        varchar(6) NOT NULL COMMENT '验证码',
    `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
    PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统验证码';

-- ----------------------------
-- Records of sys_captcha
-- ----------------------------
INSERT INTO `sys_captcha`
VALUES ('013ff506-c6e0-4111-8fc4-8a759696ed5a', 'n4weg', '2020-06-08 23:05:32');
INSERT INTO `sys_captcha`
VALUES ('1456b4e3-5f8a-44df-8e84-80a5f5a4aa4d', 'y4e5y', '2020-06-08 11:51:33');
INSERT INTO `sys_captcha`
VALUES ('173491c3-983f-4e12-8e0d-50327e6a8a1e', '76x73', '2020-06-08 11:10:29');
INSERT INTO `sys_captcha`
VALUES ('26f16b5e-b41c-402e-8724-06bd02367a2a', 'gbn6e', '2020-06-08 09:53:56');
INSERT INTO `sys_captcha`
VALUES ('2ef830ef-7251-42a0-8a9f-f924b3ae2749', 'wnfxx', '2020-09-14 17:07:45');
INSERT INTO `sys_captcha`
VALUES ('420a7198-5c52-46fb-8df2-33fafa118b7a', '2b3x5', '2020-09-14 17:08:06');
INSERT INTO `sys_captcha`
VALUES ('74e0ae66-4a50-4cb7-8679-c561f077070c', 'bp8y2', '2020-09-14 17:07:41');
INSERT INTO `sys_captcha`
VALUES ('754480e3-c909-4e2c-8ec4-057d6912671a', '7p7nw', '2020-06-07 18:16:26');
INSERT INTO `sys_captcha`
VALUES ('83637fd9-3a77-434d-8e57-42d8a5072195', 'ndcfc', '2020-09-14 17:07:37');
INSERT INTO `sys_captcha`
VALUES ('9144fd11-f7db-48d2-8b02-8a9e2a5f1bd8', 'a7gm4', '2020-06-08 21:21:23');
INSERT INTO `sys_captcha`
VALUES ('f9a1d55a-93da-4302-80bf-b8d750ca186c', 'dnm26', '2020-06-07 18:19:10');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`
(
    `id`          bigint NOT NULL AUTO_INCREMENT,
    `param_key`   varchar(50)   DEFAULT NULL COMMENT 'key',
    `param_value` varchar(2000) DEFAULT NULL COMMENT 'value',
    `status`      tinyint       DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
    `remark`      varchar(500)  DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`),
    UNIQUE KEY `param_key` (`param_key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config`
VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY',
        '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}',
        '0', '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`
(
    `id`          bigint NOT NULL AUTO_INCREMENT,
    `username`    varchar(50)   DEFAULT NULL COMMENT '用户名',
    `operation`   varchar(50)   DEFAULT NULL COMMENT '用户操作',
    `method`      varchar(200)  DEFAULT NULL COMMENT '请求方法',
    `params`      varchar(5000) DEFAULT NULL COMMENT '请求参数',
    `time`        bigint NOT NULL COMMENT '执行时长(毫秒)',
    `ip`          varchar(64)   DEFAULT NULL COMMENT 'IP地址',
    `create_date` datetime      DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log`
VALUES ('1', 'admin', '暂停定时任务', 'com.noriental.modules.job.controller.ScheduleJobController.pause()', '[[1]]', '36',
        '127.0.0.1', '2020-06-05 16:03:29');
INSERT INTO `sys_log`
VALUES ('2', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":31,\"parentId\":1,\"name\":\"测试\",\"url\":\"www.baidu.com\",\"perms\":\"baidu\",\"type\":1,\"icon\":\"sousuo\"}]',
        '13', '0:0:0:0:0:0:0:1', '2020-06-05 21:15:17');
INSERT INTO `sys_log`
VALUES ('3', 'admin', '修改菜单', 'com.noriental.modules.sys.controller.SysMenuController.update()',
        '[{\"menuId\":31,\"parentId\":1,\"name\":\"测试\",\"url\":\"https://www.baidu.com\",\"perms\":\"baidu\",\"type\":1,\"icon\":\"sousuo\",\"orderNum\":0}]',
        '13', '0:0:0:0:0:0:0:1', '2020-06-05 21:15:59');
INSERT INTO `sys_log`
VALUES ('4', 'admin', '删除菜单', 'com.noriental.modules.sys.controller.SysMenuController.delete()', '[31]', '0',
        '127.0.0.1', '2020-06-07 16:33:14');
INSERT INTO `sys_log`
VALUES ('5', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":37,\"parentId\":0,\"name\":\"代码生成\",\"url\":\"code/generate\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":1}]',
        '17', '127.0.0.1', '2020-06-07 16:49:23');
INSERT INTO `sys_log`
VALUES ('6', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":42,\"parentId\":1,\"name\":\"代码生成\",\"url\":\"/sys/generator\",\"perms\":\"\",\"type\":1,\"icon\":\"bianji\",\"orderNum\":7}]',
        '22', '127.0.0.1', '2020-06-07 18:00:24');
INSERT INTO `sys_log`
VALUES ('7', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":44,\"parentId\":0,\"name\":\"开发工具\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"zonghe\",\"orderNum\":2}]',
        '12', '127.0.0.1', '2020-06-07 18:19:22');
INSERT INTO `sys_log`
VALUES ('8', 'admin', '修改菜单', 'com.noriental.modules.sys.controller.SysMenuController.update()',
        '[{\"menuId\":37,\"parentId\":44,\"name\":\"代码生成\",\"url\":\"sys/generator\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":1}]',
        '15', '127.0.0.1', '2020-06-07 18:20:09');
INSERT INTO `sys_log`
VALUES ('9', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":45,\"parentId\":44,\"name\":\"图片处理\",\"url\":\"sys/image\",\"perms\":\"\",\"type\":1,\"icon\":\"admin\",\"orderNum\":2}]',
        '19', '127.0.0.1', '2020-06-07 18:32:57');
INSERT INTO `sys_log`
VALUES ('10', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":46,\"parentId\":42,\"name\":\"GUID生成\",\"url\":\"generator/guid\",\"perms\":\"\",\"type\":1,\"icon\":\"menu\",\"orderNum\":3}]',
        '13', '127.0.0.1', '2020-06-08 11:15:35');
INSERT INTO `sys_log`
VALUES ('11', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":47,\"parentId\":42,\"name\":\"UNICODE转换\",\"url\":\"unicode/unicode\",\"perms\":\"\",\"type\":1,\"icon\":\"geren\",\"orderNum\":0}]',
        '11', '127.0.0.1', '2020-06-08 11:17:00');
INSERT INTO `sys_log`
VALUES ('12', 'admin', '修改菜单', 'com.noriental.modules.sys.controller.SysMenuController.update()',
        '[{\"menuId\":37,\"parentId\":42,\"name\":\"代码生成\",\"url\":\"generator/generator\",\"perms\":\"\",\"type\":1,\"icon\":\"zhedie\",\"orderNum\":0}]',
        '11', '127.0.0.1', '2020-06-08 11:17:28');
INSERT INTO `sys_log`
VALUES ('13', 'admin', '修改菜单', 'com.noriental.modules.sys.controller.SysMenuController.update()',
        '[{\"menuId\":47,\"parentId\":42,\"name\":\"UNICODE转换\",\"url\":\"unicode/unicode\",\"perms\":\"\",\"type\":1,\"icon\":\"geren\",\"orderNum\":4}]',
        '9', '127.0.0.1', '2020-06-08 11:17:40');
INSERT INTO `sys_log`
VALUES ('14', 'admin', '修改菜单', 'com.noriental.modules.sys.controller.SysMenuController.update()',
        '[{\"menuId\":42,\"parentId\":0,\"name\":\"开发工具\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"zonghe\",\"orderNum\":0}]',
        '9', '127.0.0.1', '2020-06-08 11:17:48');
INSERT INTO `sys_log`
VALUES ('15', 'admin', '修改菜单', 'com.noriental.modules.sys.controller.SysMenuController.update()',
        '[{\"menuId\":42,\"parentId\":0,\"name\":\"开发工具\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"zonghe\",\"orderNum\":1}]',
        '10', '127.0.0.1', '2020-06-08 11:17:57');
INSERT INTO `sys_log`
VALUES ('16', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":48,\"parentId\":42,\"name\":\"身份证号生成\",\"url\":\"id/id\",\"perms\":\"\",\"type\":1,\"icon\":\"sql\",\"orderNum\":4}]',
        '19', '127.0.0.1', '2020-06-08 11:27:52');
INSERT INTO `sys_log`
VALUES ('17', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":49,\"parentId\":42,\"name\":\"PDF转WORD\",\"url\":\"pdf/word\",\"perms\":\"\",\"type\":1,\"icon\":\"oss\",\"orderNum\":0}]',
        '13', '127.0.0.1', '2020-06-08 11:31:21');
INSERT INTO `sys_log`
VALUES ('18', 'admin', '修改菜单', 'com.noriental.modules.sys.controller.SysMenuController.update()',
        '[{\"menuId\":49,\"parentId\":42,\"name\":\"PDF转WORD\",\"url\":\"pdf/word\",\"perms\":\"\",\"type\":1,\"icon\":\"oss\",\"orderNum\":3}]',
        '15', '127.0.0.1', '2020-06-08 11:31:33');
INSERT INTO `sys_log`
VALUES ('19', 'admin', '修改菜单', 'com.noriental.modules.sys.controller.SysMenuController.update()',
        '[{\"menuId\":46,\"parentId\":42,\"name\":\"GUID生成\",\"url\":\"generator/guid\",\"perms\":\"\",\"type\":1,\"icon\":\"menu\",\"orderNum\":4}]',
        '10', '127.0.0.1', '2020-06-08 11:31:45');
INSERT INTO `sys_log`
VALUES ('20', 'admin', '删除菜单', 'com.noriental.modules.sys.controller.SysMenuController.delete()', '[50]', '22',
        '127.0.0.1', '2020-06-08 16:25:10');
INSERT INTO `sys_log`
VALUES ('21', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":60,\"parentId\":42,\"name\":\"多数据源\",\"url\":\"gen/index\",\"perms\":\"\",\"type\":1,\"icon\":\"config\",\"orderNum\":5}]',
        '16', '127.0.0.1', '2020-06-08 19:24:28');
INSERT INTO `sys_log`
VALUES ('22', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":61,\"parentId\":42,\"name\":\"多数据源\",\"url\":\"gen/index\",\"perms\":\"\",\"type\":1,\"icon\":\"config\",\"orderNum\":5}]',
        '17', '127.0.0.1', '2020-06-09 08:49:22');
INSERT INTO `sys_log`
VALUES ('23', 'admin', '删除菜单', 'com.noriental.modules.sys.controller.SysMenuController.delete()', '[61]', '21',
        '127.0.0.1', '2020-06-14 18:31:31');
INSERT INTO `sys_log`
VALUES ('24', 'admin', '保存菜单', 'com.noriental.modules.sys.controller.SysMenuController.save()',
        '[{\"menuId\":72,\"parentId\":0,\"name\":\"项目管理\",\"url\":\"\",\"perms\":\"\",\"type\":0,\"icon\":\"admin\",\"orderNum\":0}]',
        '13', '127.0.0.1', '2020-09-11 11:08:10');
INSERT INTO `sys_log`
VALUES ('25', 'admin', '修改菜单', 'com.noriental.modules.sys.controller.SysMenuController.update()',
        '[{\"menuId\":62,\"parentId\":72,\"name\":\"项目管理\",\"url\":\"project/project\",\"type\":1,\"icon\":\"config\",\"orderNum\":0}]',
        '16', '127.0.0.1', '2020-09-11 11:09:46');
INSERT INTO `sys_log`
VALUES ('26', 'admin', '修改菜单', 'com.noriental.modules.sys.controller.SysMenuController.update()',
        '[{\"menuId\":67,\"parentId\":72,\"name\":\"开发人员管理\",\"url\":\"project/developer\",\"type\":1,\"icon\":\"config\",\"orderNum\":1}]',
        '11', '127.0.0.1', '2020-09-11 11:10:14');
INSERT INTO `sys_log`
VALUES ('27', 'admin', '保存用户', 'com.noriental.modules.sys.controller.SysUserController.save()',
        '[{\"userId\":2,\"username\":\"java\",\"password\":\"518833c8819a5252942ced06586c81d304b8dab6366d3c2504ca21adefc4f639\",\"salt\":\"4cgosADorP5kisghuEpt\",\"email\":\"ja_ckli@126.com\",\"mobile\":\"13171912510\",\"status\":1,\"roleIdList\":[],\"createUserId\":1,\"createTime\":\"Oct 28, 2020 10:49:21 AM\"}]',
        '114', '127.0.0.1', '2020-10-28 10:49:22');
INSERT INTO `sys_log`
VALUES ('28', 'admin', '保存角色', 'com.noriental.modules.sys.controller.SysRoleController.save()',
        '[{\"roleId\":1,\"roleName\":\"java\",\"remark\":\"java开发团队\",\"createUserId\":1,\"menuIdList\":[37,38,39,40,41,55,56,57,58,59,73,74,75,76,77,-666666,42],\"createTime\":\"Oct 28, 2020 10:50:13 AM\"}]',
        '66', '127.0.0.1', '2020-10-28 10:50:14');
INSERT INTO `sys_log`
VALUES ('29', 'admin', '修改角色', 'com.noriental.modules.sys.controller.SysRoleController.update()',
        '[{\"roleId\":1,\"roleName\":\"java\",\"remark\":\"java开发团队\",\"createUserId\":1,\"menuIdList\":[4,23,24,25,26,37,38,39,40,41,55,56,57,58,59,73,74,75,76,77,-666666,1,42]}]',
        '173', '127.0.0.1', '2020-10-28 10:56:39');
INSERT INTO `sys_log`
VALUES ('30', 'admin', '修改用户', 'com.noriental.modules.sys.controller.SysUserController.update()',
        '[{\"userId\":2,\"username\":\"java\",\"password\":\"518833c8819a5252942ced06586c81d304b8dab6366d3c2504ca21adefc4f639\",\"salt\":\"4cgosADorP5kisghuEpt\",\"email\":\"ja_ckli@126.com\",\"mobile\":\"13171912510\",\"status\":1,\"roleIdList\":[1],\"createUserId\":1}]',
        '47', '127.0.0.1', '2020-10-28 10:59:46');
INSERT INTO `sys_log`
VALUES ('31', 'admin', '修改角色', 'com.noriental.modules.sys.controller.SysRoleController.update()',
        '[{\"roleId\":1,\"roleName\":\"java\",\"remark\":\"java开发团队\",\"createUserId\":1,\"menuIdList\":[37,38,39,40,41,55,56,57,58,59,73,74,75,76,77,-666666,42]}]',
        '48', '127.0.0.1', '2020-10-28 11:00:06');
INSERT INTO `sys_log`
VALUES ('32', 'admin', '修改角色', 'com.noriental.modules.sys.controller.SysRoleController.update()',
        '[{\"roleId\":1,\"roleName\":\"java\",\"remark\":\"java开发团队\",\"createUserId\":1,\"menuIdList\":[55,56,57,58,59,73,74,75,76,77,-666666,42]}]',
        '46', '127.0.0.1', '2020-10-28 11:03:03');
INSERT INTO `sys_log`
VALUES ('33', 'admin', '修改角色', 'com.noriental.modules.sys.controller.SysRoleController.update()',
        '[{\"roleId\":1,\"roleName\":\"java\",\"remark\":\"java开发团队\",\"createUserId\":1,\"menuIdList\":[37,38,39,40,41,55,56,57,58,59,73,74,75,76,77,-666666,42]}]',
        '48', '127.0.0.1', '2020-10-28 11:10:20');
INSERT INTO `sys_log`
VALUES ('34', 'admin', '修改角色', 'com.noriental.modules.sys.controller.SysRoleController.update()',
        '[{\"roleId\":1,\"roleName\":\"java\",\"remark\":\"java开发团队\",\"createUserId\":1,\"menuIdList\":[4,23,24,25,26,37,38,39,40,41,55,56,57,58,59,73,74,75,76,77,-666666,1,42]}]',
        '184', '127.0.0.1', '2020-11-03 09:43:37');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `menu_id`   bigint NOT NULL AUTO_INCREMENT,
    `parent_id` bigint       DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
    `name`      varchar(50)  DEFAULT NULL COMMENT '菜单名称',
    `url`       varchar(200) DEFAULT NULL COMMENT '菜单URL',
    `perms`     varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
    `type`      int          DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
    `icon`      varchar(50)  DEFAULT NULL COMMENT '菜单图标',
    `order_num` int          DEFAULT NULL COMMENT '排序',
    PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu`
VALUES ('1', '0', '系统管理', null, null, '0', 'system', '0');
INSERT INTO `sys_menu`
VALUES ('2', '1', '管理员列表', 'sys/user', null, '1', 'admin', '1');
INSERT INTO `sys_menu`
VALUES ('3', '1', '角色管理', 'sys/role', null, '1', 'role', '2');
INSERT INTO `sys_menu`
VALUES ('4', '1', '菜单管理', 'sys/menu', null, '1', 'menu', '3');
INSERT INTO `sys_menu`
VALUES ('5', '1', 'SQL监控', 'http://localhost:8080/okay-fast/druid/sql.html', null, '1', 'sql', '4');
INSERT INTO `sys_menu`
VALUES ('6', '1', '定时任务', 'job/schedule', null, '1', 'job', '5');
INSERT INTO `sys_menu`
VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('27', '1', '参数管理', 'sys/config',
        'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'config', '6');
INSERT INTO `sys_menu`
VALUES ('29', '1', '系统日志', 'sys/log', 'sys:log:list', '1', 'log', '7');
INSERT INTO `sys_menu`
VALUES ('30', '1', '文件上传', 'oss/oss', 'sys:oss:all', '1', 'oss', '6');
INSERT INTO `sys_menu`
VALUES ('31', '1', 'redis管理', 'manager/redisauth', null, '1', 'config', '6');
INSERT INTO `sys_menu`
VALUES ('32', '31', '查看', null, 'manager:redisauth:list,manager:redisauth:info', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('33', '31', '新增', null, 'manager:redisauth:save', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('34', '31', '修改', null, 'generator:authredis:update', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('35', '31', '删除', null, 'manager:redisauth:delete', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('37', '42', '代码生成', 'generator/generator', '', '1', 'zhedie', '2');
INSERT INTO `sys_menu`
VALUES ('38', '37', '查看', null, 'sys:generator:list,sys:generator:info', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('39', '37', '新增', null, 'sys:generator:save', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('40', '37', '修改', null, 'sys:generator:update', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('41', '37', '生成代码', null, 'sys:generator:code', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('42', '0', '开发工具', '', '', '0', 'zonghe', '1');
INSERT INTO `sys_menu`
VALUES ('43', '42', '图片处理', 'sys/image', '', '1', 'admin', '3');
INSERT INTO `sys_menu`
VALUES ('46', '42', 'GUID生成', 'generator/guid', '', '1', 'menu', '4');
INSERT INTO `sys_menu`
VALUES ('47', '42', 'UNICODE转换', 'unicode/unicode', '', '1', 'geren', '4');
INSERT INTO `sys_menu`
VALUES ('48', '42', '身份证号生成', 'id/id', '', '1', 'sql', '4');
INSERT INTO `sys_menu`
VALUES ('49', '42', 'PDF转WORD', 'pdf/word', '', '1', 'oss', '3');
INSERT INTO `sys_menu`
VALUES ('55', '42', '数据源管理', 'ds/datasource', null, '1', 'config', '1');
INSERT INTO `sys_menu`
VALUES ('56', '55', '查看', null, 'ds:datasource:list,ds:datasource:info', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('57', '55', '新增', null, 'ds:datasource:save', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('58', '55', '修改', null, 'ds:datasource:update', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('59', '55', '删除', null, 'ds:datasource:delete', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('62', '72', '项目管理', 'project/project', null, '1', 'config', '0');
INSERT INTO `sys_menu`
VALUES ('63', '62', '查看', null, 'project:project:list,project:project:info', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('64', '62', '新增', null, 'project:project:save', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('65', '62', '修改', null, 'project:project:update', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('66', '62', '删除', null, 'project:project:delete', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('67', '72', '开发人员管理', 'project/developer', null, '1', 'config', '1');
INSERT INTO `sys_menu`
VALUES ('68', '67', '查看', null, 'project:developer:list,project:developer:info', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('69', '67', '新增', null, 'project:developer:save', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('70', '67', '修改', null, 'project:developer:update', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('71', '67', '删除', null, 'project:developer:delete', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('72', '0', '项目管理', '', '', '0', 'admin', '0');
INSERT INTO `sys_menu`
VALUES ('73', '42', '网站导航', 'nav/navmap', null, '1', 'config', '0');
INSERT INTO `sys_menu`
VALUES ('74', '73', '查看', null, 'nav:navmap:list,nav:navmap:info', '2', null, '0');
INSERT INTO `sys_menu`
VALUES ('75', '73', '新增', null, 'nav:navmap:save', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('76', '73', '修改', null, 'nav:navmap:update', '2', null, '6');
INSERT INTO `sys_menu`
VALUES ('77', '73', '删除', null, 'nav:navmap:delete', '2', null, '6');

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss`
(
    `id`          bigint NOT NULL AUTO_INCREMENT,
    `url`         varchar(200) DEFAULT NULL COMMENT 'URL地址',
    `create_date` datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `role_id`        bigint NOT NULL AUTO_INCREMENT,
    `role_name`      varchar(100) DEFAULT NULL COMMENT '角色名称',
    `remark`         varchar(100) DEFAULT NULL COMMENT '备注',
    `create_user_id` bigint       DEFAULT NULL COMMENT '创建者ID',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role`
VALUES ('1', 'java', 'java开发团队', '1', '2020-10-28 10:50:14');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `id`      bigint NOT NULL AUTO_INCREMENT,
    `role_id` bigint DEFAULT NULL COMMENT '角色ID',
    `menu_id` bigint DEFAULT NULL COMMENT '菜单ID',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu`
VALUES ('87', '1', '4');
INSERT INTO `sys_role_menu`
VALUES ('88', '1', '23');
INSERT INTO `sys_role_menu`
VALUES ('89', '1', '24');
INSERT INTO `sys_role_menu`
VALUES ('90', '1', '25');
INSERT INTO `sys_role_menu`
VALUES ('91', '1', '26');
INSERT INTO `sys_role_menu`
VALUES ('92', '1', '37');
INSERT INTO `sys_role_menu`
VALUES ('93', '1', '38');
INSERT INTO `sys_role_menu`
VALUES ('94', '1', '39');
INSERT INTO `sys_role_menu`
VALUES ('95', '1', '40');
INSERT INTO `sys_role_menu`
VALUES ('96', '1', '41');
INSERT INTO `sys_role_menu`
VALUES ('97', '1', '55');
INSERT INTO `sys_role_menu`
VALUES ('98', '1', '56');
INSERT INTO `sys_role_menu`
VALUES ('99', '1', '57');
INSERT INTO `sys_role_menu`
VALUES ('100', '1', '58');
INSERT INTO `sys_role_menu`
VALUES ('101', '1', '59');
INSERT INTO `sys_role_menu`
VALUES ('102', '1', '73');
INSERT INTO `sys_role_menu`
VALUES ('103', '1', '74');
INSERT INTO `sys_role_menu`
VALUES ('104', '1', '75');
INSERT INTO `sys_role_menu`
VALUES ('105', '1', '76');
INSERT INTO `sys_role_menu`
VALUES ('106', '1', '77');
INSERT INTO `sys_role_menu`
VALUES ('107', '1', '-666666');
INSERT INTO `sys_role_menu`
VALUES ('108', '1', '1');
INSERT INTO `sys_role_menu`
VALUES ('109', '1', '42');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `user_id`        bigint      NOT NULL AUTO_INCREMENT,
    `username`       varchar(50) NOT NULL COMMENT '用户名',
    `password`       varchar(100) DEFAULT NULL COMMENT '密码',
    `salt`           varchar(20)  DEFAULT NULL COMMENT '盐',
    `email`          varchar(100) DEFAULT NULL COMMENT '邮箱',
    `mobile`         varchar(100) DEFAULT NULL COMMENT '手机号',
    `status`         tinyint      DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
    `create_user_id` bigint       DEFAULT NULL COMMENT '创建者ID',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user`
VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e',
        'root@okay.io', '13612345678', '1', '1', '2016-11-11 11:11:11');
INSERT INTO `sys_user`
VALUES ('2', 'java', '518833c8819a5252942ced06586c81d304b8dab6366d3c2504ca21adefc4f639', '4cgosADorP5kisghuEpt',
        'ja_ckli@126.com', '13171912510', '1', '1', '2020-10-28 10:49:22');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `id`      bigint NOT NULL AUTO_INCREMENT,
    `user_id` bigint DEFAULT NULL COMMENT '用户ID',
    `role_id` bigint DEFAULT NULL COMMENT '角色ID',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role`
VALUES ('1', '2', '1');

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token`
(
    `user_id`     bigint       NOT NULL,
    `token`       varchar(100) NOT NULL COMMENT 'token',
    `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户Token';

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token`
VALUES ('1', 'e995e53d217a1d8d79f805cf22ff3a4a', '2020-11-03 21:43:03', '2020-11-03 09:43:03');
INSERT INTO `sys_user_token`
VALUES ('2', '26d1bcfb0388552b2573b1d3f68f50e4', '2020-11-03 21:43:47', '2020-11-03 09:43:47');

-- ----------------------------
-- Procedure structure for proc_create_class
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_create_class`;
DELIMITER;;
CREATE
DEFINER=`admin`@`%` PROCEDURE `proc_create_class`()
lable2end:
BEGIN
  DECLARE
proc_error INTEGER DEFAULT 0;
  DECLARE
ERR_MSG TEXT;
	DECLARE
class INTEGER DEFAULT 0;
	DECLARE
grade INTEGER DEFAULT 0;
	DECLARE
org INTEGER DEFAULT 0;
    DECLARE
proc_note VARCHAR(255) DEFAULT 'proc_create_class 执行成功';
    DECLARE
CONTINUE HANDLER FOR SQLSTATE '23000'
BEGIN
GET DIAGNOSTICS CONDITION 1 ERR_MSG= MESSAGE_TEXT; /*输出错误信息*/
SET
proc_error=1;
        SET
proc_note='主键冲突;';
END;
    DECLARE
CONTINUE HANDLER FOR SQLWARNING
BEGIN
GET DIAGNOSTICS CONDITION 1 ERR_MSG= MESSAGE_TEXT;
SET
proc_error=0;
        SET
proc_note='警告错误;';
END;
    DECLARE
CONTINUE HANDLER FOR SQLEXCEPTION,NOT FOUND
BEGIN
GET DIAGNOSTICS CONDITION 1 ERR_MSG= MESSAGE_TEXT;
SET
proc_error=1;
        SET
proc_note='其他错误;';
END;

START TRANSACTION;

/*执行内容1*/
SET
org=347;
		WHILE
org <= 461 DO
			SET grade=1;
			WHILE
grade <= 6 DO
				SET class=1;
				WHILE
class <= 20 DO
					insert into `neworiental_user`.`entity_classes`( `year` , `name` , `stage_id` , `grade_id` , `type` , `student_number` , `teacher_number` , `head_teacher_system_id` , `head_teacher_name` , `status` , `org_id` , `org_type` , `area_org_id` , `area_org_type` , `city_org_id` , `city_org_type` , `province_org_id` , `province_org_type` , `platform` , `begin_time` , `end_time` , `all_teacher_name` , `cid`) values( '2016' , class , '3' , grade , '0' , '' , '' , '' , '' , '1' , org , '2' , '110326' , '2' , '110327' , '2' , '110328' , '2' , '0' , '2016-09-01 00:00:00' , '2017-07-20 00:00:00' , '' , null);
					SET
class=class+1;
END WHILE;
				SET
grade=grade+1;
END WHILE;
			SET
org=org+1;
END WHILE;

    /*出错控制1*/
    IF
proc_error = 1 THEN
    ROLLBACK;
SELECT proc_note;
SELECT concat('\nproc_error=', proc_error, ';\n', proc_note, '\n `错误信息1`！', '\nERR_MSG:\n', ERR_MSG);
leave
lable2end;
END IF;

	IF
proc_error = 1 THEN
        ROLLBACK;
SELECT proc_note;
SELECT concat('\nproc_error=', proc_error, ';\n', proc_note, '\n `操作失败信息`！', '\nERR_MSG:\n', ERR_MSG);
ELSE
        COMMIT;
SELECT proc_note;
SELECT concat('\nproc_error=', proc_error, ';\n', proc_note, '\n proc_tongji_profit_by_day 执行成功！');
END IF;
END
;
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for update_user_property
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_user_property`;
DELIMITER;;
CREATE
DEFINER=`admin`@`10.60.0.123` PROCEDURE `update_user_property`()
BEGIN
	-- 定义游标遍历时，作为判断是否遍历完全部记录的标记
	DECLARE
num INT DEFAULT 0;
 -- 定义变量
  DECLARE
systemId bigint(20);
	DECLARE
count INT DEFAULT 0;
	-- 定义游标，并将sql结果集赋值到游标中
	DECLARE
company_list CURSOR FOR
SELECT a.system_id
FROM entity_user a
WHERE a.org_id = 640
  AND a.org_type = 4
  AND a.create_time BETWEEN "2017-01-01" AND "2018-02-28"
  AND a.type = 2
  AND a.`status` != 2;
-- 声明当游标遍历完全部记录后将标志变量置成某个值
DECLARE
CONTINUE HANDLER FOR NOT FOUND SET num=1;
	-- 打开游标
OPEN company_list;
-- 将游标中的值赋值给变量，要注意sql结果列的顺序
FETCH company_list INTO systemId;
-- while循环
WHILE
num<>1 DO
SELECT count(a.id)
into count
FROM link_user_property a
WHERE a.org_id = 640 AND a.org_type = 4 AND a.system_id = systemId;
IF
count=0 THEN
				INSERT INTO `link_user_property` (`system_id`, `intention_grade_id`,`org_id`, `org_type`, `create_time`) VALUES (systemId,4,640,4,NOW());
END IF;
fetch company_list INTO systemId;
END WHILE;
	-- 关闭游标
CLOSE company_list;
END
;;
DELIMITER ;
