/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : pcms

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2017-07-25 20:13:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `corporator` varchar(10) DEFAULT NULL,
  `address` varchar(100) NOT NULL,
  `province` varchar(10) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `area` varchar(10) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `mobile` varchar(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(32) DEFAULT NULL,
  `last_modify_date` timestamp NULL DEFAULT NULL,
  `update_time` tinyblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '2', '3', '1', '1', '1', '1', '1', '1', '1', '1', '2017-07-22 15:35:54', '1', '0000-00-00 00:00:00', '');
INSERT INTO `company` VALUES ('2', 'aaa', 'bbb', 'ccc', '1', '1', '1', '1', '1', '1', '1', '2017-07-22 15:35:53', '1', '0000-00-00 00:00:00', '');
INSERT INTO `company` VALUES ('3', 'ccc', '1', '1', '3', '1', '1', '1', '1', '1', '1', '2017-07-22 15:35:52', '1', '0000-00-00 00:00:00', '');
INSERT INTO `company` VALUES ('4', 'ddd', '1', '1', '3', '1', '1', '1', '1', '1', '1', '2017-07-22 15:35:51', '1', '0000-00-00 00:00:00', '');
INSERT INTO `company` VALUES ('5', '123', '1231', '3', '123', '1231', '3131', '3', '111', null, null, null, null, null, '');
INSERT INTO `company` VALUES ('6', 'bbb', 'ccc', 'dd', '11', '123', '123', '132', '11', null, null, null, null, null, '');
INSERT INTO `company` VALUES ('10', 'test', 'XXX公司', '登云路', '浙江', '杭州', '3001', null, '13503120521', null, null, null, null, null, '');
INSERT INTO `company` VALUES ('11', '1', '1', '1', '1', '1', '1', '1', '1', null, null, null, null, null, '');
INSERT INTO `company` VALUES ('12', '2', '2', '2', '2', '2', '2', '2', '22222', null, null, null, 'admin', null, '');

-- ----------------------------
-- Table structure for `databasechangelog`
-- ----------------------------
DROP TABLE IF EXISTS `databasechangelog`;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of databasechangelog
-- ----------------------------
INSERT INTO `databasechangelog` VALUES ('00000000000001', 'jhipster', 'classpath:config/liquibase/changelog/00000000000000_initial_schema.xml', '2017-07-19 19:43:59', '1', 'EXECUTED', '7:e5d421759980df5ea9b5cd2ebcfd994c', 'createTable, createIndex (x2), createTable (x2), addPrimaryKey, createTable, addForeignKeyConstraint (x3), loadData, dropDefaultValue, loadData (x2), createTable (x2), addPrimaryKey, createIndex (x2), addForeignKeyConstraint', '', null, '3.4.2', null, null, null);
INSERT INTO `databasechangelog` VALUES ('20170712103800-1', 'jhipster', 'classpath:config/liquibase/changelog/20170712103800_added_entity_Company.xml', '2017-07-19 19:44:02', '2', 'EXECUTED', '7:b8785c6c818bc7541b206b2598990f15', 'createTable, dropDefaultValue (x2)', '', null, '3.4.2', null, null, null);
INSERT INTO `databasechangelog` VALUES ('20170712103801-1', 'jhipster', 'classpath:config/liquibase/changelog/20170712103801_added_entity_Project.xml', '2017-07-19 19:44:05', '3', 'EXECUTED', '7:88966f330cd28d9713215404174a4231', 'createTable, dropDefaultValue (x4)', '', null, '3.4.2', null, null, null);

-- ----------------------------
-- Table structure for `databasechangeloglock`
-- ----------------------------
DROP TABLE IF EXISTS `databasechangeloglock`;
CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of databasechangeloglock
-- ----------------------------
INSERT INTO `databasechangeloglock` VALUES ('1', '', '2017-07-22 16:08:27', 'USER-20150810TD (169.254.142.151)');

-- ----------------------------
-- Table structure for `jhi_authority`
-- ----------------------------
DROP TABLE IF EXISTS `jhi_authority`;
CREATE TABLE `jhi_authority` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jhi_authority
-- ----------------------------
INSERT INTO `jhi_authority` VALUES ('ROLE_ADMIN');
INSERT INTO `jhi_authority` VALUES ('ROLE_USER');

-- ----------------------------
-- Table structure for `jhi_persistent_audit_event`
-- ----------------------------
DROP TABLE IF EXISTS `jhi_persistent_audit_event`;
CREATE TABLE `jhi_persistent_audit_event` (
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `principal` varchar(255) NOT NULL,
  `event_date` timestamp NULL DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `idx_persistent_audit_event` (`principal`,`event_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jhi_persistent_audit_event
-- ----------------------------

-- ----------------------------
-- Table structure for `jhi_persistent_audit_evt_data`
-- ----------------------------
DROP TABLE IF EXISTS `jhi_persistent_audit_evt_data`;
CREATE TABLE `jhi_persistent_audit_evt_data` (
  `event_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`,`name`),
  KEY `idx_persistent_audit_evt_data` (`event_id`),
  CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jhi_persistent_audit_evt_data
-- ----------------------------

-- ----------------------------
-- Table structure for `jhi_persistent_token`
-- ----------------------------
DROP TABLE IF EXISTS `jhi_persistent_token`;
CREATE TABLE `jhi_persistent_token` (
  `series` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `token_value` varchar(255) NOT NULL,
  `token_date` date DEFAULT NULL,
  `ip_address` varchar(39) DEFAULT NULL,
  `user_agent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`series`),
  KEY `fk_user_persistent_token` (`user_id`),
  CONSTRAINT `fk_user_persistent_token` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jhi_persistent_token
-- ----------------------------
INSERT INTO `jhi_persistent_token` VALUES ('9Nf5ymGZEOY/6Wj1ZJAyLQ==', '3', 'mleSi7L9gAWXqB4O5ClDAQ==', '2017-07-25', '192.168.1.89', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3047.4 Safari/537.36');
INSERT INTO `jhi_persistent_token` VALUES ('d4QiTN3kVfyhkEtBgQH7VA==', '3', 'NnzmbBctcYban7yNsd1jfg==', '2017-07-25', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.3226.400 QQBrowser/9.6.11681.400');
INSERT INTO `jhi_persistent_token` VALUES ('E2bKLQXQr+1rKDKgBvz1xA==', '3', 'hm71aMTS6+YMYC2QVCdwiw==', '2017-07-25', '192.168.1.89', 'Mozilla/5.0 (Linux; Android 4.4.2; H60-L11 Build/HDH60-L11; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043305 Safari/537.36 V1_AND_SQ_6.5.3_398_YYB_D QQ/6.5.3.2855 NetType/WIFI WebP/0.3.0 Pixel/72');
INSERT INTO `jhi_persistent_token` VALUES ('lNew40dAETeFgFDADULu2w==', '3', 'C6O0J7jiPoSjBQMO5lXnSQ==', '2017-07-25', '192.168.1.89', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36');
INSERT INTO `jhi_persistent_token` VALUES ('vfN4zP77sWwEjbAhNVAERQ==', '3', 'Z0Xqy2jh0MOvHi1L7ZrYfA==', '2017-07-21', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36');
INSERT INTO `jhi_persistent_token` VALUES ('vsb0ud2rZItnNGHQTRKn6Q==', '3', 'uuY5QuH+kvW7cI/96TYilA==', '2017-07-25', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36');

-- ----------------------------
-- Table structure for `jhi_user`
-- ----------------------------
DROP TABLE IF EXISTS `jhi_user`;
CREATE TABLE `jhi_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password_hash` varchar(60) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(5) DEFAULT NULL,
  `activation_key` varchar(20) DEFAULT NULL,
  `reset_key` varchar(20) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` timestamp NOT NULL,
  `reset_date` timestamp NULL DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `idx_user_login` (`login`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `idx_user_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jhi_user
-- ----------------------------
INSERT INTO `jhi_user` VALUES ('1', 'system', '$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG', 'System', 'System', 'system@localhost', '', 'en', null, null, 'system', '2017-07-19 19:43:44', null, 'admin', '2017-07-25 14:48:06');
INSERT INTO `jhi_user` VALUES ('2', 'anonymousUser', '$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO', 'Anonymous', 'User', 'anonymous@localhost', '', 'en', null, null, 'system', '2017-07-19 19:43:44', null, null, null);
INSERT INTO `jhi_user` VALUES ('3', 'admin', '$2a$10$V/89HwUy6hXqZODFYjnxT.yVBgL7PhElIlENYYG8Gt0VyI5BEbHrC', 'Administrator', 'Administrator', 'admin@localhost', '', 'en', null, null, 'system', '2017-07-19 19:43:44', null, 'admin', '2017-07-25 14:47:13');
INSERT INTO `jhi_user` VALUES ('4', 'user', '$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K', 'User', 'User', 'user@localhost', '', 'en', null, null, 'system', '2017-07-19 19:43:44', null, 'admin', '2017-07-25 14:47:49');
INSERT INTO `jhi_user` VALUES ('8', '13503120521', '$2a$10$baZ72qfijFkW4hUUdOZ3MenVrg5AVuUBjFdijQJ7/oXyDg1A/5lWO', '13503120521', null, null, '', 'zh', '23642398927936177518', null, 'admin', '2017-07-23 15:06:40', null, 'admin', '2017-07-23 15:06:40');
INSERT INTO `jhi_user` VALUES ('9', '1', '$2a$10$4FmEdVyCzYmfcuDweSrNNOVozV0buebrY2oC9GOQX2FOV86bhTsgm', '1', null, null, '', 'zh', '05857412738938992247', null, 'admin', '2017-07-23 15:36:56', null, 'admin', '2017-07-23 15:36:56');
INSERT INTO `jhi_user` VALUES ('10', '22222', '$2a$10$4CTKJE1.cnYjPZdCKA.FB.AzEgUlNNjK1hP6dFimjA.IqVqugUMUC', '22222', null, null, '', 'zh', '94820749622013114073', null, 'admin', '2017-07-23 15:44:39', null, 'admin', '2017-07-23 15:44:39');

-- ----------------------------
-- Table structure for `jhi_user_authority`
-- ----------------------------
DROP TABLE IF EXISTS `jhi_user_authority`;
CREATE TABLE `jhi_user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_name`),
  KEY `fk_authority_name` (`authority_name`),
  CONSTRAINT `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES `jhi_authority` (`name`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jhi_user_authority
-- ----------------------------
INSERT INTO `jhi_user_authority` VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `jhi_user_authority` VALUES ('3', 'ROLE_ADMIN');
INSERT INTO `jhi_user_authority` VALUES ('1', 'ROLE_USER');
INSERT INTO `jhi_user_authority` VALUES ('3', 'ROLE_USER');
INSERT INTO `jhi_user_authority` VALUES ('4', 'ROLE_USER');
INSERT INTO `jhi_user_authority` VALUES ('8', 'ROLE_USER');
INSERT INTO `jhi_user_authority` VALUES ('9', 'ROLE_USER');
INSERT INTO `jhi_user_authority` VALUES ('10', 'ROLE_USER');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `ID` bigint(18) NOT NULL,
  `PROJ_COMP_ID` bigint(9) NOT NULL COMMENT '项目公司ID',
  `PROJ_COMP_NAME` varchar(128) NOT NULL COMMENT '项目公司名称',
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(80) DEFAULT NULL,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `SUPERVISOR` varchar(100) DEFAULT NULL,
  `OWNER_CONTRACTOR` varchar(100) DEFAULT NULL,
  `TOTAL_CONTRACTOR` varchar(100) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `STATUS` int(11) DEFAULT '0' COMMENT '0：待审核\r\n            1：审核通过\r\n            2：审核失败\r\n            3：终结',
  `DEL_FLAG` int(11) DEFAULT '0',
  `REMARK` varchar(500) DEFAULT NULL,
  `EXTEND_ATTR` varchar(50) DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存放项目的基本信息:开始时间，结束时间，是否停工等';

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for `project_copy`
-- ----------------------------
DROP TABLE IF EXISTS `project_copy`;
CREATE TABLE `project_copy` (
  `ID` bigint(18) NOT NULL,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(80) DEFAULT NULL,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `SUPERVISOR` varchar(100) DEFAULT NULL,
  `OWNER_CONTRACTOR` varchar(100) DEFAULT NULL,
  `TOTAL_CONTRACTOR` varchar(100) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `STATUS` int(11) DEFAULT '0' COMMENT '0：待审核\r\n            1：审核通过\r\n            2：审核失败\r\n            3：终结',
  `DEL_FLAG` int(11) DEFAULT '0',
  `REMARK` varchar(500) DEFAULT NULL,
  `EXTEND_ATTR` varchar(50) DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存放项目的基本信息:开始时间，结束时间，是否停工等';

-- ----------------------------
-- Records of project_copy
-- ----------------------------

-- ----------------------------
-- Table structure for `project_copy1`
-- ----------------------------
DROP TABLE IF EXISTS `project_copy1`;
CREATE TABLE `project_copy1` (
  `ID` bigint(18) NOT NULL,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(80) DEFAULT NULL,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `SUPERVISOR` varchar(100) DEFAULT NULL,
  `OWNER_CONTRACTOR` varchar(100) DEFAULT NULL,
  `TOTAL_CONTRACTOR` varchar(100) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `STATUS` int(11) DEFAULT '0' COMMENT '0：待审核\r\n            1：审核通过\r\n            2：审核失败\r\n            3：终结',
  `DEL_FLAG` int(11) DEFAULT '0',
  `REMARK` varchar(500) DEFAULT NULL,
  `EXTEND_ATTR` varchar(50) DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存放项目的基本信息:开始时间，结束时间，是否停工等';

-- ----------------------------
-- Records of project_copy1
-- ----------------------------

-- ----------------------------
-- Table structure for `project_copy2`
-- ----------------------------
DROP TABLE IF EXISTS `project_copy2`;
CREATE TABLE `project_copy2` (
  `ID` bigint(18) NOT NULL,
  `CODE` varchar(20) NOT NULL,
  `NAME` varchar(80) DEFAULT NULL,
  `EN_NAME` varchar(32) DEFAULT NULL,
  `SUPERVISOR` varchar(100) DEFAULT NULL,
  `OWNER_CONTRACTOR` varchar(100) DEFAULT NULL,
  `TOTAL_CONTRACTOR` varchar(100) DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `STATUS` int(11) DEFAULT '0' COMMENT '0：待审核\r\n            1：审核通过\r\n            2：审核失败\r\n            3：终结',
  `DEL_FLAG` int(11) DEFAULT '0',
  `REMARK` varchar(500) DEFAULT NULL,
  `EXTEND_ATTR` varchar(50) DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存放项目的基本信息:开始时间，结束时间，是否停工等';

-- ----------------------------
-- Records of project_copy2
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT,
  `COMP_ID` bigint(9) NOT NULL COMMENT '公司ID',
  `CODE` bigint(9) DEFAULT NULL COMMENT '用户工号',
  `MOBILE` varchar(16) DEFAULT NULL COMMENT '手机号码',
  `STATUS` smallint(1) DEFAULT NULL COMMENT '0：无效\r\n            1：有效',
  `JOB_TITLE` varchar(16) DEFAULT NULL COMMENT '岗位@',
  `MAJOR` varchar(16) DEFAULT NULL COMMENT '专业@',
  `JH_USER_ID` bigint(9) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='公司成员表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '10', '1', null, '0', 'kpbtotle', 'major', '8');
INSERT INTO `user_info` VALUES ('2', '11', '1', null, '0', 'kpbtotle', 'major', '9');
INSERT INTO `user_info` VALUES ('3', '12', '1', null, '0', 'kpbtotle', 'major', '10');
