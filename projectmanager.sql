/*
Navicat MySQL Data Transfer

Source Server         : wampMysql
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : projectmanager

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-06-16 22:57:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mf_position
-- ----------------------------
DROP TABLE IF EXISTS `mf_position`;
CREATE TABLE `mf_position` (
  `positionID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '职位名称',
  `numbers` int(11) DEFAULT '0' COMMENT '职位人数',
  PRIMARY KEY (`positionID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for mf_project
-- ----------------------------
DROP TABLE IF EXISTS `mf_project`;
CREATE TABLE `mf_project` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `title` varchar(30) DEFAULT NULL COMMENT '项目名称',
  `description` varchar(60) DEFAULT NULL COMMENT '项目描述',
  `principalID` int(11) DEFAULT NULL COMMENT '项目负责人ID',
  `memberID` varchar(60) DEFAULT NULL COMMENT '项目组成员ID',
  `startTime` datetime DEFAULT NULL COMMENT '项目开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '项目结束时间',
  `status` int(11) DEFAULT '0' COMMENT '项目状态：0、正常进行中 1、完成 2、挂起3、延期',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mf_user
-- ----------------------------
DROP TABLE IF EXISTS `mf_user`;
CREATE TABLE `mf_user` (
  `userID` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(60) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(60) DEFAULT NULL COMMENT '密码',
  `name` varchar(11) DEFAULT NULL COMMENT '用户真实姓名',
  `sex` int(1) DEFAULT NULL COMMENT '用户性别 1男性 2 女性',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `positionID` int(11) DEFAULT NULL COMMENT '职位ID',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `address` varchar(60) DEFAULT NULL COMMENT '联系地址',
  `logStamp` datetime DEFAULT NULL COMMENT '账号注册日期',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
