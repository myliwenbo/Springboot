/*
 Navicat Premium Data Transfer

 Source Server         : 117.141
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : 192.168.117.141:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 30/12/2020 14:16:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_Id`) USING BTREE,
  INDEX `id_card`(`user_Name`) USING BTREE,
  INDEX `name_age`(`password`, `phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
