/*
Navicat MySQL Data Transfer

Source Server         : administrator1
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : supermarket_pssmsys

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-03-17 17:32:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pssm_goods`
-- ----------------------------
DROP TABLE IF EXISTS `pssm_goods`;
CREATE TABLE `pssm_goods` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品主键',
  `name` varchar(50) NOT NULL COMMENT '商品名称',
  `category_level2_id` int(20) NOT NULL COMMENT '二级类别编号',
  `stock_number` int(20) NOT NULL,
  `input_price` decimal(20,2) NOT NULL COMMENT '进价',
  `output_price` decimal(20,2) NOT NULL COMMENT '售价',
  `supplier_name` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pssm_goods
-- ----------------------------
INSERT INTO `pssm_goods` VALUES ('1', '百事可乐', '102', '201', '5.00', '5.50', '娃哈哈XX公司', '2019-04-14 18:56:12', '2019-04-27 11:30:40');
INSERT INTO `pssm_goods` VALUES ('2', '江小白', '103', '800', '45.00', '55.00', '江苏江小白', '2019-04-26 21:10:46', '2019-04-27 11:59:08');
INSERT INTO `pssm_goods` VALUES ('3', '3+2夹心饼干', '105', '30', '4.50', '6.00', '康师傅', '2019-04-26 21:10:32', '2019-04-26 21:10:32');
INSERT INTO `pssm_goods` VALUES ('4', '银鹭花生牛奶', '102', '300', '4.50', '6.00', '娃哈哈万通食品有限公司', '2019-04-27 11:34:10', '2019-04-27 11:35:08');

-- ----------------------------
-- Table structure for `pssm_goods_category`
-- ----------------------------
DROP TABLE IF EXISTS `pssm_goods_category`;
CREATE TABLE `pssm_goods_category` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '类别主键',
  `name` varchar(50) NOT NULL COMMENT '类别名称',
  `category_level1` int(20) DEFAULT NULL COMMENT '一级类别',
  `category_level2` int(20) DEFAULT NULL COMMENT '二级类别',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pssm_goods_category
-- ----------------------------
INSERT INTO `pssm_goods_category` VALUES ('1', '食品类', '0', '0', '2019-04-14 17:51:50', '2019-04-14 17:56:33');
INSERT INTO `pssm_goods_category` VALUES ('2', '生鲜类', '0', '0', '2019-04-14 17:52:48', '2019-04-14 17:56:34');
INSERT INTO `pssm_goods_category` VALUES ('3', '洗化类', '0', '0', '2019-04-14 17:53:11', '2019-04-14 18:19:14');
INSERT INTO `pssm_goods_category` VALUES ('4', '家百类', '0', '0', '2019-04-14 17:53:26', '2019-04-14 18:19:20');
INSERT INTO `pssm_goods_category` VALUES ('5', '家电类', '0', '0', '2019-04-14 17:53:39', '2019-04-14 18:19:37');
INSERT INTO `pssm_goods_category` VALUES ('6', '家纺类', '0', '0', '2019-04-14 17:53:55', '2019-04-14 18:19:43');
INSERT INTO `pssm_goods_category` VALUES ('7', '文体箱包', '0', '0', '2019-04-14 17:57:20', '2019-04-14 18:20:00');
INSERT INTO `pssm_goods_category` VALUES ('8', '饮料', '102', '0', '2019-04-14 17:57:53', '2019-04-14 18:20:06');
INSERT INTO `pssm_goods_category` VALUES ('9', '酒', '103', '0', '2019-04-14 17:58:12', '2019-04-14 17:58:48');
INSERT INTO `pssm_goods_category` VALUES ('10', '香烟', '104', '0', '2019-04-14 17:58:35', '2019-04-14 17:58:52');
INSERT INTO `pssm_goods_category` VALUES ('11', '饼干', '105', '0', '2019-04-14 17:59:40', '2019-04-14 17:59:43');
INSERT INTO `pssm_goods_category` VALUES ('12', '糕点类', '106', '0', '2019-04-14 17:59:52', '2019-04-14 17:59:55');
INSERT INTO `pssm_goods_category` VALUES ('13', '果脯蜜饯', '107', '0', '2019-04-14 18:01:27', '2019-04-14 18:01:29');
INSERT INTO `pssm_goods_category` VALUES ('14', '炒货', '108', '0', '2019-04-14 18:02:22', '2019-04-14 18:02:25');
INSERT INTO `pssm_goods_category` VALUES ('15', '糖果', '109', '0', '2019-04-14 18:02:59', '2019-04-14 18:03:02');
INSERT INTO `pssm_goods_category` VALUES ('16', '休闲膨化', '110', '0', '2019-04-14 18:03:26', '2019-04-14 18:03:29');
INSERT INTO `pssm_goods_category` VALUES ('17', '罐头', '111', '0', '2019-04-14 18:03:45', '2019-04-14 18:03:47');
INSERT INTO `pssm_goods_category` VALUES ('18', '冲饮', '112', '0', '2019-04-14 18:04:06', '2019-04-14 18:04:08');
INSERT INTO `pssm_goods_category` VALUES ('19', '奶粉', '113', '0', '2019-04-14 18:04:47', '2019-04-14 18:04:50');
INSERT INTO `pssm_goods_category` VALUES ('20', '米粉果酱', '114', '0', '2019-04-14 18:05:24', '2019-04-14 18:05:26');
INSERT INTO `pssm_goods_category` VALUES ('21', '蜂蜜', '115', '0', '2019-04-14 18:05:54', '2019-04-14 18:05:55');
INSERT INTO `pssm_goods_category` VALUES ('22', '干调类', '116', '0', '2019-04-14 18:06:25', '2019-04-14 18:06:28');
INSERT INTO `pssm_goods_category` VALUES ('23', '湿调', '117', '0', '2019-04-14 18:06:51', '2019-04-14 18:06:53');
INSERT INTO `pssm_goods_category` VALUES ('24', '南北干货', '118', '0', '2019-04-14 18:07:27', '2019-04-14 18:07:29');
INSERT INTO `pssm_goods_category` VALUES ('25', '米面', '119', '0', '2019-04-14 18:07:52', '2019-04-14 18:07:55');
INSERT INTO `pssm_goods_category` VALUES ('26', '油类', '120', '0', '2019-04-14 18:08:13', '2019-04-14 18:08:15');
INSERT INTO `pssm_goods_category` VALUES ('27', '咸菜', '121', '0', '2019-04-14 18:08:29', '2019-04-14 18:08:32');
INSERT INTO `pssm_goods_category` VALUES ('28', '杂粮', '201', '0', '2019-04-14 18:09:02', '2019-04-14 18:12:58');
INSERT INTO `pssm_goods_category` VALUES ('29', '乳制品', '202', '0', '2019-04-14 18:09:41', '2019-04-14 18:10:15');
INSERT INTO `pssm_goods_category` VALUES ('30', '蔬菜类', '203', '0', '2019-04-14 18:10:05', '2019-04-14 18:10:17');
INSERT INTO `pssm_goods_category` VALUES ('31', '肉品', '204', '0', '2019-04-14 18:10:26', '2019-04-14 18:10:29');
INSERT INTO `pssm_goods_category` VALUES ('32', '水产', '205', '0', '2019-04-14 18:10:41', '2019-04-14 18:10:44');
INSERT INTO `pssm_goods_category` VALUES ('33', '熟食', '206', '0', '2019-04-14 18:11:01', '2019-04-14 18:11:03');
INSERT INTO `pssm_goods_category` VALUES ('34', '洗发水', '301', '0', '2019-04-14 18:11:38', '2019-04-14 18:11:40');
INSERT INTO `pssm_goods_category` VALUES ('35', '沐浴露', '302', '0', '2019-04-14 18:11:56', '2019-04-14 18:11:59');
INSERT INTO `pssm_goods_category` VALUES ('36', '香皂', '303', '0', '2019-04-14 18:12:16', '2019-04-14 18:12:18');
INSERT INTO `pssm_goods_category` VALUES ('37', '牙刷', '304', '0', '2019-04-14 18:13:25', '2019-04-14 18:13:28');
INSERT INTO `pssm_goods_category` VALUES ('38', '牙膏', '305', '0', '2019-04-14 18:13:44', '2019-04-14 18:13:46');
INSERT INTO `pssm_goods_category` VALUES ('39', '纸巾', '306', '0', '2019-04-14 18:14:21', '2019-04-14 18:14:23');
INSERT INTO `pssm_goods_category` VALUES ('40', '杯子', '401', '0', '2019-04-14 18:14:46', '2019-04-14 18:14:48');
INSERT INTO `pssm_goods_category` VALUES ('41', '一次性用品', '402', '0', '2019-04-14 18:15:26', '2019-04-14 18:15:29');
INSERT INTO `pssm_goods_category` VALUES ('42', '小家电', '501', '0', '2019-04-14 18:15:50', '2019-04-14 18:15:53');
INSERT INTO `pssm_goods_category` VALUES ('43', '不锈钢类', '502', '0', '2019-04-14 18:16:19', '2019-04-14 18:16:23');
INSERT INTO `pssm_goods_category` VALUES ('44', '毛巾类', '601', '0', '2019-04-14 18:16:43', '2019-04-14 18:16:45');
INSERT INTO `pssm_goods_category` VALUES ('45', '袜子', '602', '0', '2019-04-14 18:17:01', '2019-04-14 18:17:03');
INSERT INTO `pssm_goods_category` VALUES ('46', '内衣裤', '603', '0', '2019-04-14 18:17:20', '2019-04-14 18:17:22');
INSERT INTO `pssm_goods_category` VALUES ('47', '床品', '604', '0', '2019-04-14 18:17:39', '2019-04-14 18:17:41');
INSERT INTO `pssm_goods_category` VALUES ('48', '鞋', '605', '0', '2019-04-14 18:18:06', '2019-04-14 18:18:08');
INSERT INTO `pssm_goods_category` VALUES ('49', '办公用品1', '701', '0', '2019-04-14 18:20:35', '2019-12-12 13:51:34');
INSERT INTO `pssm_goods_category` VALUES ('50', '玩具', '702', '0', '2019-04-14 18:20:56', '2019-04-14 18:43:33');

-- ----------------------------
-- Table structure for `pssm_into_stock_list`
-- ----------------------------
DROP TABLE IF EXISTS `pssm_into_stock_list`;
CREATE TABLE `pssm_into_stock_list` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '进货单主键',
  `unique_id` varchar(50) DEFAULT NULL COMMENT '进货单编号',
  `goods_id` int(20) NOT NULL COMMENT '商品编号',
  `into_stock_number` int(20) NOT NULL COMMENT '进货数量',
  `into_stock_price` decimal(20,2) NOT NULL COMMENT '进价',
  `is_finished` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否完成,1完成0未完成',
  `supplier_name` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pssm_into_stock_list
-- ----------------------------
INSERT INTO `pssm_into_stock_list` VALUES ('2', '20190427012', '1', '500', '3000.00', '1', '浙江金星食品有限公司', '2019-04-27 10:23:18', '2019-04-27 11:09:06');
INSERT INTO `pssm_into_stock_list` VALUES ('3', '20190427012', '2', '1000', '60000.00', '1', '江小白酒业有限公司', '2019-04-27 10:23:31', '2019-04-27 11:02:07');
INSERT INTO `pssm_into_stock_list` VALUES ('9', '20190427012', '1', '100', '200.00', '1', '浙江金星食品有限公司', '2019-04-27 11:30:30', '2019-04-27 11:30:39');
INSERT INTO `pssm_into_stock_list` VALUES ('10', '20190427012', '4', '100', '450.00', '1', '娃哈哈万通食品有限公司', '2019-04-27 11:34:59', '2019-04-27 11:35:08');

-- ----------------------------
-- Table structure for `pssm_job_department`
-- ----------------------------
DROP TABLE IF EXISTS `pssm_job_department`;
CREATE TABLE `pssm_job_department` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '部门表主键',
  `name` varchar(10) NOT NULL COMMENT '部门名称',
  `content` varchar(200) NOT NULL COMMENT '部门职能简介',
  `create_time` timestamp NULL DEFAULT NULL,
  `edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pssm_job_department
-- ----------------------------
INSERT INTO `pssm_job_department` VALUES ('1', '采购部', '负责购', '2019-04-22 22:21:06', '2019-04-22 23:16:37');
INSERT INTO `pssm_job_department` VALUES ('2', '销售部', '负责销售', '2019-04-25 10:21:20', '2019-04-25 10:21:22');
INSERT INTO `pssm_job_department` VALUES ('3', 'IT部', '负责电脑等设备的使用维护', '2019-04-25 10:21:47', '2019-04-25 10:21:49');

-- ----------------------------
-- Table structure for `pssm_job_position`
-- ----------------------------
DROP TABLE IF EXISTS `pssm_job_position`;
CREATE TABLE `pssm_job_position` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '职位表主键',
  `name` varchar(10) NOT NULL COMMENT '职位名称',
  `content` varchar(200) NOT NULL COMMENT '职位简介',
  `create_time` timestamp NULL DEFAULT NULL,
  `edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pssm_job_position
-- ----------------------------
INSERT INTO `pssm_job_position` VALUES ('1', '采购专员', '负责每日商品的采购', '2019-04-22 23:23:07', '2019-04-24 11:40:15');
INSERT INTO `pssm_job_position` VALUES ('2', '技术专员', '负责电脑管理', '2019-04-25 10:28:59', '2019-04-25 10:29:01');
INSERT INTO `pssm_job_position` VALUES ('3', '销售专员', '负责销售', '2019-04-25 10:29:18', '2019-04-25 10:29:20');
INSERT INTO `pssm_job_position` VALUES ('4', '销售主管', '主管销售部门', '2019-04-25 10:29:36', '2019-04-25 10:29:38');

-- ----------------------------
-- Table structure for `pssm_local_account`
-- ----------------------------
DROP TABLE IF EXISTS `pssm_local_account`;
CREATE TABLE `pssm_local_account` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '账号主键',
  `user_id` int(20) NOT NULL COMMENT '所属用户编号',
  `account_string` varchar(100) NOT NULL COMMENT '账号',
  `password_string` varchar(100) NOT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pssm_local_account
-- ----------------------------
INSERT INTO `pssm_local_account` VALUES ('1', '1', 'lixf', '123456', '2019-04-23 20:42:40', '2019-04-23 20:53:32');

-- ----------------------------
-- Table structure for `pssm_outof_stock_list`
-- ----------------------------
DROP TABLE IF EXISTS `pssm_outof_stock_list`;
CREATE TABLE `pssm_outof_stock_list` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '出货单主键',
  `unique_id` varchar(50) DEFAULT NULL COMMENT '出货单编号',
  `goods_id` int(20) NOT NULL COMMENT '商品编号',
  `outof_stock_number` int(20) NOT NULL COMMENT '出货数量',
  `outof_stock_price` decimal(20,2) NOT NULL COMMENT '售价',
  `is_finished` int(20) NOT NULL DEFAULT '0' COMMENT '是否完成，1完成0未完成',
  `supplier_name` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pssm_outof_stock_list
-- ----------------------------
INSERT INTO `pssm_outof_stock_list` VALUES ('2', '20190427001', '2', '200', '1200.00', '1', '江小白XX公司', '2019-04-27 11:58:53', '2019-04-27 11:59:07');

-- ----------------------------
-- Table structure for `pssm_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `pssm_user_info`;
CREATE TABLE `pssm_user_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` tinyint(1) NOT NULL COMMENT '1男0女',
  `id_card` varchar(30) NOT NULL COMMENT '身份证',
  `is_married` tinyint(1) DEFAULT NULL COMMENT '是否结婚，1结0未结',
  `department_id` int(10) DEFAULT NULL COMMENT '部门编号',
  `position_id` int(10) DEFAULT NULL COMMENT '职位编号',
  `phone` varchar(30) DEFAULT NULL COMMENT '手机号',
  `priority` tinyint(1) DEFAULT NULL COMMENT '权限',
  `entry_time` date DEFAULT NULL COMMENT '入职时间',
  `full_time` date DEFAULT NULL COMMENT '转正时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `edit_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '编辑时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pssm_user_info
-- ----------------------------
INSERT INTO `pssm_user_info` VALUES ('1', '李想封', '0', '421307199812135563', '0', '1', '3', '18566302274', '1', '2019-04-22', '2019-04-22', '2019-04-22 23:51:15', '2019-04-25 11:35:05');
INSERT INTO `pssm_user_info` VALUES ('2', '王洪', '1', '421307199712135563', '0', '1', '1', '18566802273', '1', null, null, '2019-04-22 23:52:45', '2019-04-25 11:35:44');
INSERT INTO `pssm_user_info` VALUES ('3', '张鹏', '1', '456774198909074174', null, '2', '2', '18852302263', '1', null, null, '2019-04-26 08:42:15', '2019-04-26 08:42:15');
INSERT INTO `pssm_user_info` VALUES ('4', '赵刚', '1', '456741198811124517', null, '2', '3', '15001147546', '1', null, null, '2019-04-26 08:43:04', '2019-04-26 08:43:04');
INSERT INTO `pssm_user_info` VALUES ('5', '韦晓花', '0', '456174199002124536', null, '2', '4', '18906322245', '1', null, null, '2019-04-26 08:44:40', '2019-04-26 08:44:40');
INSERT INTO `pssm_user_info` VALUES ('7', '谭红', '0', '456384199206032563', null, '2', '3', '18936203362', '1', null, null, '2019-04-26 08:46:42', '2019-04-26 08:46:42');
INSERT INTO `pssm_user_info` VALUES ('8', '张文娟', '0', '452634199308126347', null, '2', '3', '18632467516', '1', null, null, '2019-04-26 08:47:33', '2019-04-26 08:47:33');
INSERT INTO `pssm_user_info` VALUES ('9', '蒙芳', '0', '456321199507062136', null, '2', '3', '15603215563', '1', null, null, '2019-04-26 08:48:22', '2019-04-26 08:48:22');
