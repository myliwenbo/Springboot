/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50552
Source Host           : localhost:3306
Source Database       : quartz03

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2017-11-25 22:52:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `job_name` varchar(255) DEFAULT NULL COMMENT '任务名',
  `job_group` varchar(255) DEFAULT NULL COMMENT '任务组',
  `method_name` varchar(255) DEFAULT NULL COMMENT '要执行的方法',
  `bean_class` varchar(255) DEFAULT NULL COMMENT '定时任务所在的类路径',
  `status` int(11) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `cron_expression` varchar(255) DEFAULT NULL COMMENT '时间表达式',
  `params` varchar(255) DEFAULT NULL COMMENT '参数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('1', 'test', 'tiny', 'run1', 'com.demo.schedule.TaskTest1', '0', '0/5 * * * * ?', '', '启动状态测试', '2017-11-25 20:16:10', '2017-11-25 20:16:12');
INSERT INTO `schedule_job` VALUES ('2', 'test1', 'tiny', 'run2', 'com.demo.schedule.TaskTest1', '0', '0/5 * * * * ?', null, '启动状态测试', '2017-11-25 20:16:15', '2017-11-25 20:16:18');
INSERT INTO `schedule_job` VALUES ('3', 'test2', 'tiny', 'run3', 'com.demo.schedule.TaskTest1', '1', '0/5 * * * * ?', null, '暂停状态测试', '2017-11-25 20:16:59', '2017-11-25 20:17:03');
INSERT INTO `schedule_job` VALUES ('4', 'test3', 'tiny', 'run4', 'com.demo.schedule.TaskTest1', '1', '0/1 * * * * ?', null, '暂停状态测试', '2017-11-25 20:17:35', '2017-11-25 20:17:39');
