/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : myfirstproject

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-20 17:21:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `mf_project`
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mf_project
-- ----------------------------
INSERT INTO `mf_project` VALUES ('1', '微信跳一跳小程序', '一款风靡全球的减压小游戏', '1', '1;2', '2018-01-20 16:06:45', '2018-02-15 16:06:49', '0');
INSERT INTO `mf_project` VALUES ('2', '轮胎全生命周期管理系统', '基于物联网技术的针对大型客货车的轮胎整个生命周期的管理系统', '1', '1;2', '2018-01-20 16:38:41', '2018-02-22 16:38:44', '0');

-- ----------------------------
-- Table structure for `mf_user`
-- ----------------------------
DROP TABLE IF EXISTS `mf_user`;
CREATE TABLE `mf_user` (
  `userID` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(60) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(60) DEFAULT NULL COMMENT '密码',
  `logStamp` datetime DEFAULT NULL COMMENT '账号注册日期',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mf_user
-- ----------------------------
INSERT INTO `mf_user` VALUES ('1', '123@163.com', '96e79218965eb72c92a549dd5a330112', '2018-01-19 15:16:28');
INSERT INTO `mf_user` VALUES ('2', '1234@163.com', '96e79218965eb72c92a549dd5a330112', '2018-01-19 15:17:37');
