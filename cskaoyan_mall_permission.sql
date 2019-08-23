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

 Date: 23/08/2019 09:21:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cskaoyan_mall_permission
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_permission`;
CREATE TABLE `cskaoyan_mall_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `permission` varchar(63) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_permission
-- ----------------------------
INSERT INTO `cskaoyan_mall_permission` VALUES (1, 1, '*', '2019-01-01 00:00:00', '2019-01-01 00:00:00', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (2, 2, 'GET /admin/collect/list', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (3, 2, 'POST /admin/topic/create', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (4, 2, 'POST /admin/ad/create', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (5, 2, 'GET /admin/coupon/listuser', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (6, 2, 'GET /admin/topic/read', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (7, 2, 'GET /admin/config/wx', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (8, 2, 'GET /admin/footprint/list', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (9, 2, 'GET /admin/history/list', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (10, 2, 'GET /admin/coupon/list', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (11, 2, 'POST /admin/groupon/delete', '2019-01-07 15:18:53', '2019-01-07 15:18:53', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (12, 3, 'GET /admin/collect/list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (13, 3, 'POST /admin/topic/create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (14, 3, 'POST /admin/ad/create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (15, 3, 'GET /admin/coupon/listuser', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (16, 3, 'GET /admin/topic/read', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (17, 3, 'GET /admin/footprint/list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (18, 3, 'GET /admin/history/list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (19, 3, 'GET /admin/coupon/list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (20, 3, 'POST /admin/groupon/delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (21, 3, 'GET /admin/user/list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (22, 3, 'POST /admin/ad/delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (23, 3, 'POST /admin/ad/update', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (24, 3, 'GET /admin/ad/list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (25, 3, 'GET /admin/feedback/list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (26, 3, 'POST /admin/groupon/create', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (27, 3, 'POST /admin/coupon/update', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (28, 3, 'POST /admin/coupon/delete', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (29, 3, 'GET /admin/ad/read', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (30, 3, 'GET /admin/groupon/list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (31, 3, 'GET /admin/address/list', '2019-01-07 15:18:57', '2019-01-07 15:18:57', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (32, 3, 'POST /admin/topic/delete', '2019-08-22 14:26:57', '2019-08-28 14:27:01', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (33, 3, 'POST /admin/groupon/update', '2019-07-05 14:27:11', '2019-08-14 14:27:16', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (34, 2, 'GET /admin/config/order', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (35, 2, 'GET /admin/user/list', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (36, 2, 'POST /admin/config/order', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (37, 2, 'POST /admin/ad/delete', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (38, 2, 'GET /admin/config/mall', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (39, 2, 'POST /admin/ad/update', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (40, 2, 'GET /admin/ad/list', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (41, 2, 'POST /admin/config/express', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (42, 2, 'GET /admin/stat/order', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (43, 2, 'GET /admin/feedback/list', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (44, 2, 'POST /admin/groupon/create', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (45, 2, 'GET /admin/stat/user', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (46, 2, 'POST /admin/coupon/update', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (47, 2, 'POST /admin/config/mall', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (48, 2, 'POST /admin/coupon/delete', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (49, 2, 'GET /admin/ad/read', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (50, 2, 'POST /admin/config/wx', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (51, 2, 'GET /admin/config/express', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (52, 2, 'GET /admin/groupon/list', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (53, 2, 'GET /admin/stat/goods', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (54, 2, 'GET /admin/address/list', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (55, 2, 'POST /admin/topic/delete', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (56, 2, 'POST /admin/groupon/update', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (57, 2, 'GET /admin/groupon/listRecord', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (58, 2, 'POST /admin/coupon/create', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (59, 2, 'GET /admin/topic/list', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (60, 2, 'GET /admin/coupon/read', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (61, 2, 'POST /admin/topic/update', NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
