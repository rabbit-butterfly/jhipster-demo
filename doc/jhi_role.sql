/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : pcms

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2017-07-27 20:05:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `jhi_role`
-- ----------------------------
DROP TABLE IF EXISTS `jhi_role`;
CREATE TABLE `jhi_role` (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(32) NOT NULL COMMENT '权限名称',
  `CODE` varchar(16) NOT NULL COMMENT '编码',
  `LEVEL` smallint(1) NOT NULL COMMENT '级别',
  `PARENT_ID` bigint(9) NOT NULL COMMENT '父节点',
  `CREATED_BY` varchar(16) DEFAULT NULL COMMENT '创建人',
  `CREATED_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `LAST_MODIFIED_BY` varchar(16) DEFAULT NULL COMMENT '修改人',
  `LAST_MODIFIED_DATE` date DEFAULT NULL COMMENT '修改时间',
  `jhi_level` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_mb9tqo2iyj8hivjx38pay26vt` (`CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jhi_role
-- ----------------------------
INSERT INTO `jhi_role` VALUES ('1', '系统管理员', 'SYSTEM_ADMINISTR', '0', '0', 'admin', '0000-00-00 00:00:00', 'admin', null, '0');
INSERT INTO `jhi_role` VALUES ('2', '项目管理员', 'PROJECT_ADMIN', '1', '2', 'admin', '0000-00-00 00:00:00', 'admin', null, '0');
