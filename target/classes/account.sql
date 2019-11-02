/*
Navicat MySQL Data Transfer

Source Server         : main
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : doms

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-11-01 22:13:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `userno` varchar(20) NOT NULL,
  `money` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`,`userno`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'jack', '132213', '12113.89');
INSERT INTO `account` VALUES ('2', 'rose', '342343', '56778.89');
INSERT INTO `account` VALUES ('3', 'sun', '123412', '23080.89');
INSERT INTO `account` VALUES ('4', 'marin', '323123', '10000.00');
INSERT INTO `account` VALUES ('5', 'mary', '343243', '12312.89');
INSERT INTO `account` VALUES ('6', 'levis', '343243', '3678.95');
INSERT INTO `account` VALUES ('7', 'bean', '232123', '13000.00');
INSERT INTO `account` VALUES ('8', 'kris', '454513', '566.77');
INSERT INTO `account` VALUES ('9', 'andreson', '676756', '689.98');
INSERT INTO `account` VALUES ('10', 'mask', '324324', '3457.89');
SET FOREIGN_KEY_CHECKS=1;
