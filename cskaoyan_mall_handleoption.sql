/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : cskaoyanmall

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 23/08/2019 11:46:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cskaoyan_mall_handleoption
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_handleoption`;
CREATE TABLE `cskaoyan_mall_handleoption`  (
  `order_id` int(11) NOT NULL,
  `cancel` tinyint(1) NULL DEFAULT NULL,
  `comment` tinyint(1) NULL DEFAULT NULL,
  `confirm` tinyint(1) NULL DEFAULT NULL,
  `delete` tinyint(1) NULL DEFAULT NULL,
  `pay` tinyint(1) NULL DEFAULT NULL,
  `rebuy` tinyint(1) NULL DEFAULT NULL,
  `refund` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_handleoption
-- ----------------------------
INSERT INTO `cskaoyan_mall_handleoption` VALUES (1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `cskaoyan_mall_handleoption` VALUES (2, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `cskaoyan_mall_handleoption` VALUES (3, 1, 1, 1, 1, 1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
