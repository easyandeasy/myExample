/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50614
Source Host           : 127.0.0.1:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2017-07-30 18:29:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '23');
INSERT INTO `student` VALUES ('2', '李四', '24');
INSERT INTO `student` VALUES ('3', '王五', '25');
