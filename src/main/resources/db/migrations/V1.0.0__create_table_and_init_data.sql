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
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COMMENT='题库表';

/*Data for the table `doc_question` */

insert  into `doc_question`(`id`,`type`,`name`,`content`,`level`,`score`,`a`,`b`,`c`,`d`,`e`,`f`,`g`,`o`,`answer_correct`,`answer_explain`,`remark`,`create_date`,`create_by`,`update_date`,`update_by`,`del_flag`) values (45,3,'爷爷','s',2,2,'A','B','C','D','E','F','G','其他答案','A,C','因为C',NULL,1527474080460,9999,1527574495860,9999,0),(46,2,'奶奶','D',1,2,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474080567,9999,NULL,NULL,0),(47,1,'爸爸','C',3,4,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474080696,9999,NULL,NULL,0),(48,3,'妈妈','D',1,10,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474080804,9999,NULL,NULL,0),(49,2,'爷爷','BV',2,3,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474080928,9999,NULL,NULL,0),(50,1,'奶奶','爸爸再爱我一次',1,2,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474081035,9999,NULL,NULL,0),(51,3,'爸爸','妈妈再爱我两次',3,2,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474081163,9999,NULL,NULL,0),(52,2,'妈妈','s',1,4,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474081270,9999,NULL,NULL,0),(53,1,'爷爷','D',2,10,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474081397,9999,NULL,NULL,0),(54,3,'奶奶','C',1,3,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474081505,9999,NULL,NULL,0),(55,2,'爸爸','D',3,2,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474081631,9999,NULL,NULL,0),(56,1,'妈妈','BV',1,2,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474081740,9999,NULL,NULL,0),(57,3,'爷爷','爸爸再爱我一次',2,4,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474081864,9999,NULL,NULL,0),(58,2,'奶奶','妈妈再爱我两次',1,10,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474081969,9999,NULL,NULL,0),(59,1,'爸爸','s',3,3,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474082095,9999,NULL,NULL,0),(60,3,'妈妈','D',1,2,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474082202,9999,NULL,NULL,0),(61,2,'爷爷','C',2,2,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474082328,9999,NULL,NULL,0),(62,1,'奶奶','D',1,4,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474082432,9999,NULL,NULL,0),(63,3,'爸爸','BV',3,10,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474082557,9999,NULL,NULL,0),(64,2,'妈妈','爸爸再爱我一次',1,3,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474082662,9999,NULL,NULL,0),(65,1,'爷爷','妈妈再爱我两次',2,2,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474082785,9999,NULL,NULL,0),(66,3,'奶奶','s',1,2,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474082889,9999,NULL,NULL,0),(67,2,'爸爸','D',3,4,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474083017,9999,NULL,NULL,0),(68,1,'妈妈','C',1,3,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474083133,9999,NULL,NULL,0),(69,1,'你帅不帅','请问，你帅不帅',1,3,'帅','帅','帅','帅',NULL,NULL,NULL,NULL,'A,B,C,D','你别无选择',NULL,1527574721308,9999,NULL,NULL,0),(70,1,'今天天气怎么样','天气怎么样哇',2,12,'很好','一般','差','不好','极差',NULL,NULL,NULL,'A','就是1dsadsa',NULL,1527818550194,9999,1527818567796,9999,0),(71,1,'今天天气怎么样2','天气怎么样哇2',2,12,'很好','一般','差','不好','极差',NULL,NULL,NULL,'A','就是1',NULL,1527818550306,9999,NULL,NULL,0);

/*Table structure for table `doc_source` */

DROP TABLE IF EXISTS `doc_source`;

CREATE TABLE `doc_source` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '文档名称',
  `type` int(10) DEFAULT NULL COMMENT '文档类别：1文档类 2视频类 3音频类 4图片类',
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
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8 COMMENT='媒体资源表';

/*Data for the table `doc_source` */

insert  into `doc_source`(`id`,`name`,`type`,`url`,`size`,`suffix`,`apply_time`,`remark`,`create_date`,`create_by`,`update_date`,`update_by`,`del_flag`) values (160,'dsadas',1,'http://localhost:8085/source/attach/1527497761534.pdf',NULL,'dsadsa',0,'dsadas',1527497768042,9999,NULL,NULL,0),(164,'建设施工视频',3,'http://localhost:8085/source/attach/1527498527782.mp4',NULL,'.mp4',0,'建设施工视频',1527498535381,9999,1527574434712,9999,0),(165,'txt',1,'http://localhost:8085/source/attach/1527571808164.txt',NULL,'.txt',0,'txt试一试',1527571823638,9999,NULL,NULL,0),(166,'文档资源',1,'http://localhost:8085/source/attach/1527574407485.docx',NULL,'.docx',0,'',1527574418728,9999,NULL,NULL,0),(168,'视频测试测试',3,'http://localhost:8085/source/attach/1527574615134.mp4',NULL,'.mp4',0,'建设施工视频',1527574618357,9999,NULL,NULL,0),(171,'aaaaaaa',3,'http://localhost:8085/source/attach/1527818425550.mp4',NULL,'.mp4',0,'aaa',1527818430988,9999,NULL,NULL,0);

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

/*Data for the table `oa_item` */

insert  into `oa_item`(`id`,`parent_id`,`name`,`sort`,`code`,`type`,`grade`,`master`,`master_name`,`company_name`,`item_flag`,`item_cycle`,`create_date`,`update_by`,`update_date`,`del_flag`,`remarks`,`create_by`) values (7,7,'项目名称sss',1,'项目编号：',NULL,NULL,1,'项目负责人姓名','施工单位名称','项目标识','项目周期',1527821857006,9999,1527821890223,0,NULL,9999),(8,7,'ces',3,'2',NULL,NULL,2,'2','2','2','2',1527843165548,NULL,NULL,0,NULL,9999);

/*Table structure for table `oa_person` */

DROP TABLE IF EXISTS `oa_person`;

CREATE TABLE `oa_person` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `type` int(10) DEFAULT '5' COMMENT '人员角色类别:1超级管理员 2人员审核管理员(主任) 3项目管理员(移动公司项目经理) 4施工管理员(施工方项目经理) 5施工工人',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_permisson` varchar(100) DEFAULT NULL COMMENT '角色权限',
  `gender` varchar(5) DEFAULT NULL COMMENT '性别',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `identity_num` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `insurance_purchases` varchar(100) DEFAULT NULL COMMENT '保险情况',
  `salary_details` varchar(100) DEFAULT NULL COMMENT '薪资情况',
  `address` varchar(100) DEFAULT NULL COMMENT '现住址',
  `status` int(5) DEFAULT '0' COMMENT '审核状态[0未审核 1已审核]',
  `item_id` int(10) DEFAULT NULL COMMENT '所在项目id,关联oa_item主键',
  `item_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `professional_unit` varchar(100) DEFAULT NULL COMMENT '施工单位专业',
  `black_flag` int(5) DEFAULT '0' COMMENT '黑名单状态[0正常 1黑名单人员]',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建日期(时间戳格式)',
  `create_by` int(10) DEFAULT NULL COMMENT '创建人',
  `update_date` bigint(20) DEFAULT NULL COMMENT '修改日期(时间戳格式)',
  `update_by` int(10) DEFAULT NULL COMMENT '修改人',
  `del_flag` int(5) DEFAULT '0' COMMENT '逻辑删除标记[0正常,1已删除,2黑名单]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `oa_person` */

insert  into `oa_person`(`id`,`name`,`type`,`role_name`,`role_permisson`,`gender`,`contact`,`identity_num`,`insurance_purchases`,`salary_details`,`address`,`status`,`item_id`,`item_name`,`professional_unit`,`black_flag`,`remark`,`create_date`,`create_by`,`update_date`,`update_by`,`del_flag`) values (1,'root',1,'root','per:all:*','男',NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,0),(2,'张三',5,'worker','per:common:*','男','110','420','泰康已交','1000已发','湖北武汉',0,NULL,NULL,'计算机科学',0,NULL,1528249604213,9999,1528255088756,9999,0),(3,'李四',5,'worker','per:common:*','女','112','432','保险123','123','湖北武汉',0,NULL,NULL,'计算机',0,NULL,1528250544020,9999,1528255091467,9999,0),(4,'王五',5,'worker','per:common:*','女','113','444','保险234','234','湖北襄阳',0,NULL,NULL,'电信',0,NULL,1528250544127,9999,1528255093386,9999,0);

/*Table structure for table `ref_role_menu` */

DROP TABLE IF EXISTS `ref_role_menu`;

CREATE TABLE `ref_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `menu_id` int(11) NOT NULL COMMENT '菜单编号',
  `school_id` int(11) NOT NULL COMMENT '学校、机构ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

/*Data for the table `ref_role_menu` */

insert  into `ref_role_menu`(`role_id`,`menu_id`,`school_id`) values (1,2,0),(1,1,0),(2,2,0),(2,3,0),(1,4,0);

/*Table structure for table `ref_user_role` */

DROP TABLE IF EXISTS `ref_user_role`;

CREATE TABLE `ref_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `school_id` int(11) NOT NULL COMMENT '机构ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

/*Data for the table `ref_user_role` */

insert  into `ref_user_role`(`user_id`,`role_id`,`school_id`) values (1,1,1),(2,2,1),(3,3,1),(6,6,1),(7,6,1),(8,6,1),(9,6,1),(10,6,1),(11,6,1),(12,6,1),(13,6,1);

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

/*Data for the table `sys_log` */

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级编号',
  `parent_ids` varchar(400) NOT NULL DEFAULT '' COMMENT '所有父级编号',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `sort` int(10) NOT NULL DEFAULT '0' COMMENT '排序',
  `href` varchar(1000) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(400) DEFAULT NULL COMMENT '图标',
  `is_show` int(10) NOT NULL DEFAULT '0' COMMENT '是否在菜单中显示',
  `permission` varchar(400) DEFAULT NULL COMMENT '权限标识',
  `create_by` int(10) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`),
  KEY `sys_menu_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`parent_id`,`parent_ids`,`name`,`sort`,`href`,`target`,`icon`,`is_show`,`permission`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`) values (1,0,'','添加学生',0,'student/add',NULL,NULL,0,'student:add',2,20160808084312,1,20160809021248,'<p>这个菜单能添加学生</p>',0),(2,0,'','教程管理',0,'jc/*',NULL,NULL,0,'jc:manage:*',1,20160809021947,NULL,NULL,'<p>教程管理</p>',0),(3,2,'','数学管理',0,'jc/shuxu',NULL,NULL,0,'jc:shuxu',1,20160809074410,NULL,NULL,'<p>数学管理</p>',0),(4,0,'','天津展会',0,'device/tj-index',NULL,NULL,0,'tjzh:admin',1,20160809074410,NULL,NULL,NULL,0);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(100) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `ref_id` int(11) NOT NULL COMMENT '关联oa_person的主键',
  `photo_url` varchar(1000) DEFAULT NULL COMMENT '用户头像',
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`name`,`ref_id`,`photo_url`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`) values (1,'root','OE43szSeXws9orNa6ooYsQ==','超级管理员',1,'',0,20130527080000,1,20160615134945,'',0);

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
 `role_permisson` varchar(100) ,
 `gender` varchar(5) ,
 `contact` varchar(50) ,
 `identity_num` varchar(50) ,
 `insurance_purchases` varchar(100) ,
 `salary_details` varchar(100) ,
 `address` varchar(100) ,
 `status` int(5) ,
 `item_id` int(10) ,
 `item_name` varchar(100) ,
 `professional_unit` varchar(100) ,
 `black_flag` int(5) 
)*/;

/*View structure for view v_user */

/*!50001 DROP TABLE IF EXISTS `v_user` */;
/*!50001 DROP VIEW IF EXISTS `v_user` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v_user` AS (select `s`.`id` AS `id`,`s`.`username` AS `username`,`s`.`password` AS `password`,`s`.`ref_id` AS `ref_id`,`s`.`photo_url` AS `photo_url`,`o`.`name` AS `name`,`o`.`type` AS `type`,`o`.`role_name` AS `role_name`,`o`.`role_permisson` AS `role_permisson`,`o`.`gender` AS `gender`,`o`.`contact` AS `contact`,`o`.`identity_num` AS `identity_num`,`o`.`insurance_purchases` AS `insurance_purchases`,`o`.`salary_details` AS `salary_details`,`o`.`address` AS `address`,`o`.`status` AS `status`,`o`.`item_id` AS `item_id`,`o`.`item_name` AS `item_name`,`o`.`professional_unit` AS `professional_unit`,`o`.`black_flag` AS `black_flag` from (`sys_user` `s` left join `oa_person` `o` on((`s`.`ref_id` = `o`.`id`)))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
