# yqyblog
## 基于mvc+jdbc+jsp的web学习项目

### 视图界面

    - 用户登录界面
    - error界面
    - 主界面
    - 下载界面

### controller
    - LoginController
    - CreateVerifyImageController
    - GetDownloadListController
    - DownloadController
    - LogoutController
    
### model
    本质就是普通的Java类
	数据的封装：VO(value object)
User.java：封装用户信息
Download.java：对下载资源信息进行封装
	操作的封装：DAO(data access Object)
UserDao.java：封装对用户对象的数据库操作
CreateImage.java：封装对验证码图片操作
DownloadDao.java：封装对下载资源的数据库操作



##  .sql

/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : excise

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 10/10/2020 10:26:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_downloadList
-- ----------------------------
DROP TABLE IF EXISTS `t_downloadList`;
CREATE TABLE `t_downloadList` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表示',
  `name` varchar(255) DEFAULT NULL COMMENT '显示名称',
  `path` varchar(255) DEFAULT NULL COMMENT '存放路径及文件名',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `size` mediumtext COMMENT '文件大小',
  `star` int(11) DEFAULT NULL COMMENT '星级',
  `image` varchar(255) DEFAULT NULL COMMENT '图片路径及名称',
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_downloadList
-- ----------------------------
BEGIN;
INSERT INTO `t_downloadList` VALUES (1, 'Java教案', '/resource/Java教案.docx', '物联网通信技术PPT', '22.2MB', 4, '/images/PPT.jpg', '2020-08-02');
COMMIT;

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `resourceId` int(11) NOT NULL,
  `resourceName` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resourceId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
BEGIN;
INSERT INTO `t_resource` VALUES (1, '资源下载', '/download.jsp');
INSERT INTO `t_resource` VALUES (2, '资源管理', '/resourceManage.jsp');
INSERT INTO `t_resource` VALUES (4, '用户管理', '/userManage.jsp');
INSERT INTO `t_resource` VALUES (5, '个人中心', '/user.jsp');
COMMIT;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (1, 'administrator');
INSERT INTO `t_role` VALUES (2, 'user');
COMMIT;

-- ----------------------------
-- Table structure for t_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource`;
CREATE TABLE `t_role_resource` (
  `id` int(11) NOT NULL,
  `resourceId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `roleId` (`roleId`) USING BTREE,
  KEY `resourceId` (`resourceId`) USING BTREE,
  CONSTRAINT `t_role_resource_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`),
  CONSTRAINT `t_role_resource_ibfk_2` FOREIGN KEY (`resourceId`) REFERENCES `t_resource` (`resourceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_role_resource
-- ----------------------------
BEGIN;
INSERT INTO `t_role_resource` VALUES (1, 1, 1);
INSERT INTO `t_role_resource` VALUES (2, 2, 1);
INSERT INTO `t_role_resource` VALUES (3, 4, 1);
INSERT INTO `t_role_resource` VALUES (4, 5, 1);
INSERT INTO `t_role_resource` VALUES (5, 1, 2);
INSERT INTO `t_role_resource` VALUES (6, 5, 2);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userName` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `chrName` varchar(255) DEFAULT NULL COMMENT '中文名',
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('admin', '666', '管理员');
INSERT INTO `t_user` VALUES ('niegang', '123', '聂刚');
INSERT INTO `t_user` VALUES ('user1', '123', 'user1');
INSERT INTO `t_user` VALUES ('user2', '321', 'user2');
COMMIT;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL,
  `roleId` int(11) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `roleId` (`roleId`) USING BTREE,
  KEY `userName` (`userName`) USING BTREE,
  CONSTRAINT `t_user_role_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`roleId`),
  CONSTRAINT `t_user_role_ibfk_2` FOREIGN KEY (`userName`) REFERENCES `t_user` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` VALUES (1, 1, 'niegang');
INSERT INTO `t_user_role` VALUES (2, 2, 'user2');
INSERT INTO `t_user_role` VALUES (3, 1, 'admin');
INSERT INTO `t_user_role` VALUES (4, 2, 'user1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
