/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50156
Source Host           : localhost:3306
Source Database       : easy_spring

Target Server Type    : MYSQL
Target Server Version : 50156
File Encoding         : 65001

Date: 2015-03-16 00:12:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`url`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`icon`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`parent`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`permission_ids`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id`  int(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
`username`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`password`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`email`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`salt`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  int(1) NOT NULL DEFAULT 1 ,
`role_ids`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Auto increment value for `resource`
-- ----------------------------
ALTER TABLE `resource` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `role`
-- ----------------------------
ALTER TABLE `role` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `user`
-- ----------------------------
ALTER TABLE `user` AUTO_INCREMENT=1;
