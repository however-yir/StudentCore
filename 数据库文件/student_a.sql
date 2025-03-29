/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80025
Source Host           : 127.0.0.1:3306
Source Database       : student_a

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2021-06-26 22:42:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Aid` int NOT NULL,
  `Aname` varchar(30) NOT NULL,
  `Apwd` varchar(10) NOT NULL,
  PRIMARY KEY (`Aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('123456', '管理员', '123456');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Cnum` int NOT NULL AUTO_INCREMENT,
  `Cno` int NOT NULL,
  `Cname` varchar(20) NOT NULL,
  `Ctime` int NOT NULL,
  `Ccredit` int NOT NULL,
  PRIMARY KEY (`Cnum`,`Cno`),
  KEY `Cname` (`Cname`),
  KEY `Cno` (`Cno`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '1001', '数据库原理', '48', '3');
INSERT INTO `course` VALUES ('2', '1002', '操作系统', '64', '4');
INSERT INTO `course` VALUES ('3', '1003', '计算机网络', '64', '4');
INSERT INTO `course` VALUES ('4', '1004', 'java', '64', '4');
INSERT INTO `course` VALUES ('6', '1005', 'python', '48', '3');
INSERT INTO `course` VALUES ('7', '1006', '软件工程', '48', '3');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `Sno` int NOT NULL,
  `Sname` varchar(20) NOT NULL,
  `Cno` int NOT NULL,
  `Cname` varchar(20) DEFAULT NULL,
  `Sscore` decimal(10,0) DEFAULT '0',
  `Rescore` decimal(10,0) DEFAULT '0',
  PRIMARY KEY (`Sno`,`Cno`),
  KEY `Cname` (`Cname`),
  KEY `Cno` (`Cno`),
  KEY `Sname` (`Sname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('20210601', '李伟', '1001', '数据库原理', '100', '0');
INSERT INTO `score` VALUES ('20210601', '李伟', '1002', '操作系统', '100', '0');
INSERT INTO `score` VALUES ('20210601', '李伟', '1003', '计算机网络', '100', '0');
INSERT INTO `score` VALUES ('20210601', '李伟', '1004', 'java', '100', '0');
INSERT INTO `score` VALUES ('20210602', '王伟', '1001', '数据库原理', '100', '0');
INSERT INTO `score` VALUES ('20210602', '王伟', '1004', 'java', '100', '0');
INSERT INTO `score` VALUES ('20210603', '刘伟', '1004', 'java', '100', '0');
INSERT INTO `score` VALUES ('20210604', '刘伟', '1001', '数据库原理', '100', '0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `Sno` int NOT NULL,
  `Sname` varchar(30) NOT NULL,
  `Sgender` char(2) NOT NULL,
  `Sage` int NOT NULL,
  `Sbirthday` datetime DEFAULT '1999-01-01 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `Sclass` varchar(10) NOT NULL,
  `Smajor` varchar(20) NOT NULL,
  `Sdept` varchar(20) NOT NULL,
  `Spwd` varchar(10) NOT NULL DEFAULT '123',
  PRIMARY KEY (`Sno`),
  KEY `Sname` (`Sname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('20210601', '李伟', '男', '20', '1999-01-01 00:00:00', '2021061', '软件工程', '计算机学院', '123');
INSERT INTO `student` VALUES ('20210602', '王伟', '女', '20', '2021-06-26 21:29:26', '2021061', '软件工程', '计算机学院', '123');
INSERT INTO `student` VALUES ('20210603', '刘伟', '男', '20', '2021-06-26 21:29:30', '2021062', '软件工程', '计算机学院', '123');
INSERT INTO `student` VALUES ('20210604', '赵伟', '男', '20', '2021-06-26 21:29:32', '2021062', '软件工程', '计算机学院', '123');
