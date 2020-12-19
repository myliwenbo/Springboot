/*
 Navicat Premium Data Transfer

 Source Server         : 117.150
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : 192.168.117.150:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 12/04/2020 12:32:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `tb_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `tb_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tb_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tb_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`tb_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1008 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
