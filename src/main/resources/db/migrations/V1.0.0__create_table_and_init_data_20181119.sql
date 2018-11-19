/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17 : Database - ligu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ligu` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `ligu`;

/*Table structure for table `app_config` */

DROP TABLE IF EXISTS `app_config`;

CREATE TABLE `app_config` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `config_desc` varchar(100) DEFAULT NULL COMMENT '配置描述',
  `config_type` varchar(1000) DEFAULT NULL COMMENT '配置类型',
  `config_key` varchar(1000) DEFAULT NULL COMMENT '配置key',
  `config_value` varchar(1000) DEFAULT NULL COMMENT '配置value',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `doc_question` */

DROP TABLE IF EXISTS `doc_question`;

CREATE TABLE `doc_question` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(10) DEFAULT NULL COMMENT '题目类别：1单选题 2多选题 3其他',
  `name` varchar(50) DEFAULT NULL COMMENT '题目简称',
  `content` varchar(255) DEFAULT NULL COMMENT '题目内容',
  `level` int(10) DEFAULT NULL COMMENT '题目难度：1简单 2一般 3困难',
  `score` int(10) DEFAULT NULL COMMENT '分值',
  `a` varchar(100) DEFAULT NULL COMMENT '答案A',
  `b` varchar(100) DEFAULT NULL COMMENT '答案B',
  `c` varchar(100) DEFAULT NULL COMMENT '答案C',
  `d` varchar(100) DEFAULT NULL COMMENT '答案D',
  `e` varchar(100) DEFAULT NULL COMMENT '答案E',
  `f` varchar(100) DEFAULT NULL COMMENT '答案F',
  `g` varchar(100) DEFAULT NULL COMMENT '答案G',
  `o` varchar(100) DEFAULT NULL COMMENT '其他答案',
  `answer_correct` varchar(100) DEFAULT NULL COMMENT '正确答案(单选：A,多选：A,B,C)',
  `answer_explain` varchar(255) DEFAULT NULL COMMENT '答案解析',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建日期(时间戳格式)',
  `create_by` int(10) DEFAULT NULL COMMENT '创建人',
  `update_date` bigint(20) DEFAULT NULL COMMENT '修改日期(时间戳格式)',
  `update_by` int(10) DEFAULT NULL COMMENT '修改人',
  `del_flag` int(5) DEFAULT '0' COMMENT '逻辑删除标记[0正常,1已删除]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=370 DEFAULT CHARSET=utf8 COMMENT='题库表';

/*Table structure for table `doc_question_version` */

DROP TABLE IF EXISTS `doc_question_version`;

CREATE TABLE `doc_question_version` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '题库版本记录id',
  `version` int(100) DEFAULT NULL COMMENT '题库版本号记录',
  `update_time` bigint(20) DEFAULT NULL COMMENT '题库修改时间',
  `update_by` int(50) DEFAULT NULL COMMENT '题库修改人id',
  `update_user_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '题库修改人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `doc_source` */

DROP TABLE IF EXISTS `doc_source`;

CREATE TABLE `doc_source` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '文档名称',
  `type` int(10) DEFAULT NULL COMMENT '0全部1安全生产视频课程2安全生产培训文档3安全生产安全守则4施工工艺视频课程5施工工艺培训文档6施工工艺工艺示例',
  `url` varchar(255) DEFAULT NULL COMMENT '文档地址(全路径,可直接访问)',
  `size` varchar(50) DEFAULT NULL COMMENT '文档大小(kb)',
  `suffix` varchar(50) DEFAULT NULL COMMENT '文档后缀',
  `apply_time` int(50) DEFAULT '0' COMMENT '文档请求次数(阅读量)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建日期(时间戳格式)',
  `create_by` int(10) DEFAULT NULL COMMENT '创建人',
  `update_date` bigint(20) DEFAULT NULL COMMENT '修改日期(时间戳格式)',
  `update_by` int(10) DEFAULT NULL COMMENT '修改人',
  `del_flag` int(5) DEFAULT '0' COMMENT '逻辑删除标记[0正常,1已删除,2黑名单]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8 COMMENT='媒体资源表';

/*Table structure for table `insurance_company` */

DROP TABLE IF EXISTS `insurance_company`;

CREATE TABLE `insurance_company` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '保险公司id',
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '保险公司名称',
  `url_for_query` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '保险公司查询保单号地址',
  `url_index` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '保险公司官网',
  `phone` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '保险公司电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `login_log` */

DROP TABLE IF EXISTS `login_log`;

CREATE TABLE `login_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sys_user_id` int(10) DEFAULT NULL COMMENT '登录帐号id',
  `ref_person_id` int(10) DEFAULT NULL COMMENT '人员id',
  `username` varchar(50) DEFAULT NULL COMMENT '登录帐号',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `login_status` int(5) DEFAULT NULL COMMENT '0登录中 1已经退出 2其他',
  `login_date` bigint(20) DEFAULT NULL COMMENT '最近登录日期',
  `logout_date` bigint(20) DEFAULT NULL COMMENT '最近登出日期',
  `login_source` int(5) DEFAULT NULL COMMENT '0 app  1 pc',
  `login_id` varchar(100) DEFAULT NULL COMMENT 'appClient_id/pcClient_id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='登录记录表';

/*Table structure for table `oa_item` */

DROP TABLE IF EXISTS `oa_item`;

CREATE TABLE `oa_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` int(11) DEFAULT NULL COMMENT '父项目ID',
  `name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `sort` int(10) DEFAULT NULL COMMENT '项目排序',
  `code` varchar(100) DEFAULT NULL COMMENT '项目编号',
  `type` varchar(10) DEFAULT NULL COMMENT '项目类型',
  `grade` varchar(10) DEFAULT NULL COMMENT '项目等级',
  `master` int(10) DEFAULT NULL COMMENT '负责人id,关联oa_person主键',
  `master_name` varchar(50) DEFAULT NULL COMMENT '负责人姓名',
  `company_name` varchar(100) DEFAULT NULL COMMENT '施工单位名称',
  `item_flag` varchar(100) DEFAULT NULL COMMENT '项目标识,唯一',
  `item_cycle` varchar(100) DEFAULT NULL COMMENT '项目周期',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_by` int(10) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(10) DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='项目表';

/*Table structure for table `oa_person` */

DROP TABLE IF EXISTS `oa_person`;

CREATE TABLE `oa_person` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `type` int(10) DEFAULT '5' COMMENT '人员角色类别:1超级管理员 2人员审核管理员(主任) 3项目管理员(移动公司项目经理) 4施工管理员(施工方项目经理) 5施工工人',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_permission` varchar(100) DEFAULT NULL COMMENT '角色权限',
  `gender` varchar(5) DEFAULT NULL COMMENT '性别',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `identity_type` varchar(50) DEFAULT NULL COMMENT '证件类型',
  `identity_num` varchar(50) DEFAULT NULL COMMENT '证件号码',
  `identity_img` varchar(1000) DEFAULT NULL COMMENT '证件图片地址url',
  `insurance_purchases` varchar(255) DEFAULT NULL COMMENT '保险情况',
  `salary_details` varchar(255) DEFAULT NULL COMMENT '薪资情况',
  `address` varchar(100) DEFAULT NULL COMMENT '现住址',
  `status` int(5) DEFAULT '0' COMMENT '审核状态[0未审核 1已审核]',
  `company` varchar(100) DEFAULT NULL COMMENT '所属中标单位',
  `item_id` int(10) DEFAULT NULL COMMENT '所在项目id,关联oa_item主键',
  `item_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `professional_unit` varchar(100) DEFAULT NULL COMMENT '施工单位专业',
  `black_flag` int(5) DEFAULT '0' COMMENT '黑名单状态[0正常 ,1黑名单待审，2黑名单人员]',
  `black_image` varchar(1000) DEFAULT NULL COMMENT '黑名单图片描述',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建日期(时间戳格式)',
  `create_by` int(10) DEFAULT NULL COMMENT '创建人',
  `update_date` bigint(20) DEFAULT NULL COMMENT '修改日期(时间戳格式)',
  `update_by` int(10) DEFAULT NULL COMMENT '修改人',
  `del_flag` int(5) DEFAULT '0' COMMENT '逻辑删除标记[0正常,1已删除,2黑名单]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2116 DEFAULT CHARSET=utf8;

/*Table structure for table `project_report` */

DROP TABLE IF EXISTS `project_report`;

CREATE TABLE `project_report` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `project_name` varchar(300) DEFAULT NULL COMMENT '工程全名',
  `project_simple_name` varchar(200) DEFAULT NULL COMMENT '工程简称',
  `project_pic` text COMMENT '工程报告图片',
  `project_desc` text COMMENT '工程完成描述',
  `project_attach` text COMMENT '工程附件1,工程附件2',
  `manager` text COMMENT '工程负责人1,工程负责人2',
  `company` varchar(200) DEFAULT NULL COMMENT '工程责任公司/项目组名称',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建日期(时间戳格式)',
  `create_by` int(10) DEFAULT NULL COMMENT '创建人',
  `update_date` bigint(20) DEFAULT NULL COMMENT '修改日期(时间戳格式)',
  `update_by` int(10) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `ref_person_exam_history` */

DROP TABLE IF EXISTS `ref_person_exam_history`;

CREATE TABLE `ref_person_exam_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `person_id` int(10) DEFAULT NULL COMMENT '人员id',
  `question_ids` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '题目id(2,3,4,10)这是一套试题的题目id集合',
  `wrong_ids` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '这套试卷做错的题目ids(2,3,10)',
  `full_score` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '100' COMMENT '这套试卷的满分',
  `obtain_score` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '这套试卷的得分',
  `exam_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '这套试卷的考试时间timestamp格式',
  `exam_type` int(10) DEFAULT NULL COMMENT '试题类别[1:平时练习,2:月份考试]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=416 DEFAULT CHARSET=utf8 COMMENT='人员考试历史表';

/*Table structure for table `ref_person_wrong_question` */

DROP TABLE IF EXISTS `ref_person_wrong_question`;

CREATE TABLE `ref_person_wrong_question` (
  `person_id` int(10) DEFAULT NULL COMMENT '人员id',
  `question_id` int(10) DEFAULT NULL COMMENT '问题id',
  `your_answer` varchar(100) DEFAULT NULL COMMENT '你的答案',
  `correct_answer` varchar(100) DEFAULT NULL COMMENT '正确答案'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='错题记录';

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type` char(1) DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `create_by` int(10) DEFAULT NULL COMMENT '创建者',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `exception` text COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`request_uri`),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(100) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `ref_id` int(11) NOT NULL COMMENT '关联oa_person的主键',
  `photo_url` varchar(1000) DEFAULT 'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png' COMMENT '用户头像',
  `create_by` int(10) DEFAULT NULL COMMENT '创建者',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_by` int(10) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_user_login_name` (`username`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=2117 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Table structure for table `v_user` */

DROP TABLE IF EXISTS `v_user`;

/*!50001 DROP VIEW IF EXISTS `v_user` */;
/*!50001 DROP TABLE IF EXISTS `v_user` */;

/*!50001 CREATE TABLE  `v_user`(
 `id` int(11) ,
 `username` varchar(100) ,
 `password` varchar(100) ,
 `ref_id` int(11) ,
 `photo_url` varchar(1000) ,
 `name` varchar(50) ,
 `type` int(10) ,
 `role_name` varchar(100) ,
 `role_permission` varchar(100) ,
 `gender` varchar(5) ,
 `contact` varchar(50) ,
 `identity_num` varchar(50) ,
 `identity_img` varchar(1000) ,
 `insurance_purchases` varchar(255) ,
 `salary_details` varchar(255) ,
 `address` varchar(100) ,
 `status` int(5) ,
 `item_id` int(10) ,
 `item_name` varchar(100) ,
 `professional_unit` varchar(100) ,
 `black_flag` int(5) ,
 `create_user_name` varchar(100) ,
 `create_by` int(10) ,
 `create_date` bigint(20) 
)*/;

/*View structure for view v_user */

/*!50001 DROP TABLE IF EXISTS `v_user` */;
/*!50001 DROP VIEW IF EXISTS `v_user` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v_user` AS (select `s`.`id` AS `id`,`s`.`username` AS `username`,`s`.`password` AS `password`,`s`.`ref_id` AS `ref_id`,`s`.`photo_url` AS `photo_url`,`o`.`name` AS `name`,`o`.`type` AS `type`,`o`.`role_name` AS `role_name`,`o`.`role_permission` AS `role_permission`,`o`.`gender` AS `gender`,`o`.`contact` AS `contact`,`o`.`identity_num` AS `identity_num`,`o`.`identity_img` AS `identity_img`,`o`.`insurance_purchases` AS `insurance_purchases`,`o`.`salary_details` AS `salary_details`,`o`.`address` AS `address`,`o`.`status` AS `status`,`o`.`item_id` AS `item_id`,`o`.`company` AS `item_name`,`o`.`professional_unit` AS `professional_unit`,`o`.`black_flag` AS `black_flag`,`ss`.`name` AS `create_user_name`,`o`.`create_by` AS `create_by`,`o`.`create_date` AS `create_date` from ((`sys_user` `s` left join `oa_person` `o` on((`s`.`ref_id` = `o`.`id`))) left join `sys_user` `ss` on((`o`.`create_by` = `ss`.`id`)))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
