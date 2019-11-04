/*
Navicat MySQL Data Transfer

Source Server         : main
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : doms

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-11-05 00:47:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `userNo` varchar(20) NOT NULL,
  `money` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`,`userNo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'jack', '300123', '14045.80');
INSERT INTO `account` VALUES ('3', 'sun', '300124', '13933.09');
INSERT INTO `account` VALUES ('4', 'marin', '300125', '1133315.00');
INSERT INTO `account` VALUES ('5', 'mary', '300126', '12312.89');
INSERT INTO `account` VALUES ('6', 'levis', '300127', '3678.95');
INSERT INTO `account` VALUES ('7', 'bean', '300128', '13000.00');
INSERT INTO `account` VALUES ('8', 'kris', '300129', '566.77');
INSERT INTO `account` VALUES ('9', 'anderson', '300130', '689.98');
INSERT INTO `account` VALUES ('10', 'michael', '300131', '3457.89');
INSERT INTO `account` VALUES ('11', 'jack', '300132', '796951.76');
INSERT INTO `account` VALUES ('12', '张三', '600123', '22542.36');
INSERT INTO `account` VALUES ('13', '李四', '600124', '33922.88');
SET FOREIGN_KEY_CHECKS=1;
