/*
SQLyog  v12.2.6 (64 bit)
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
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='题库表';

/*Data for the table `doc_question` */

insert  into `doc_question`(`id`,`type`,`name`,`content`,`level`,`score`,`a`,`b`,`c`,`d`,`e`,`f`,`g`,`o`,`answer_correct`,`answer_explain`,`remark`,`create_date`,`create_by`,`update_date`,`update_by`,`del_flag`) values 
(47,1,'爸爸','C对对度地',3,4,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474080696,9999,1529830824779,1,0),
(49,2,'爷爷','BV',2,3,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474080928,9999,NULL,NULL,0),
(52,2,'妈妈','s',1,4,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474081270,9999,NULL,NULL,0),
(53,1,'爷爷','D',2,10,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474081397,9999,NULL,NULL,0),
(54,3,'奶奶','C',1,3,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474081505,9999,NULL,NULL,0),
(55,2,'爸爸','D',3,2,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474081631,9999,NULL,NULL,0),
(56,1,'妈妈','BV',1,2,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474081740,9999,NULL,NULL,0),
(57,3,'爷爷','爸爸再爱我一次',2,4,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474081864,9999,NULL,NULL,0),
(58,2,'奶奶','妈妈再爱我两次',1,10,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474081969,9999,NULL,NULL,0),
(59,1,'爸爸','s',3,3,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474082095,9999,NULL,NULL,0),
(60,3,'妈妈','D',1,2,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474082202,9999,NULL,NULL,0),
(61,2,'爷爷','C',2,2,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474082328,9999,NULL,NULL,0),
(62,1,'奶奶','D',1,4,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474082432,9999,NULL,NULL,0),
(63,3,'爸爸','BV',3,10,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474082557,9999,NULL,NULL,0),
(64,2,'妈妈','爸爸再爱我一次',1,3,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474082662,9999,NULL,NULL,0),
(65,1,'爷爷','妈妈再爱我两次',2,2,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474082785,9999,NULL,NULL,0),
(66,3,'奶奶','s',1,2,'A','B','C','D','E','F','G','其他答案','C','因为C',NULL,1527474082889,9999,NULL,NULL,0),
(67,2,'爸爸','D',3,4,'A','B','C','D','E','F','G','其他答案','A','因为是A',NULL,1527474083017,9999,NULL,NULL,0),
(68,1,'妈妈','C',1,3,'A','B','C','D','E','F','G','其他答案','B','因为B',NULL,1527474083133,9999,NULL,NULL,0),
(69,1,'你帅不帅','请问，你帅不帅',1,3,'帅','帅','帅','帅',NULL,NULL,NULL,NULL,'A,B,C,D','你别无选择',NULL,1527574721308,9999,NULL,NULL,0),
(70,1,'今天天气怎么样','天气怎么样哇',2,12,'很好','一般','差','不好','极差',NULL,NULL,NULL,'A','就是1dsadsa',NULL,1527818550194,9999,1527818567796,9999,0),
(71,1,'今天天气怎么样2','天气怎么样哇2',2,12,'很好','一般','差','不好','极差',NULL,NULL,NULL,'A','就是1',NULL,1527818550306,9999,NULL,NULL,0),
(82,1,'最新题目测试','哈哈哈哈',1,0,'A','B','C','D',NULL,NULL,NULL,NULL,'A','SSS',NULL,1528726093594,1,NULL,NULL,0),
(83,1,'2222','3',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1530442120379,1,NULL,NULL,0);

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

/*Data for the table `doc_question_version` */

insert  into `doc_question_version`(`id`,`version`,`update_time`,`update_by`,`update_user_name`) values 
(1,3,1530442120402,1,'root');

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
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8 COMMENT='媒体资源表';

/*Data for the table `doc_source` */

insert  into `doc_source`(`id`,`name`,`type`,`url`,`size`,`suffix`,`apply_time`,`remark`,`create_date`,`create_by`,`update_date`,`update_by`,`del_flag`) values 
(172,'测试视频',3,'http://47.94.98.20:8085/source/attach/1528732046351.mp4',NULL,'.mp4',36,'测试视频',1528732055815,1,NULL,NULL,0),
(173,'测试文档资源',1,'http://47.94.98.20:8085/source/attach/1528732895162.doc',NULL,'.doc',51,'',1528732897173,1,NULL,NULL,0),
(174,'测试文档3',1,'http://47.94.98.20:8085/source/attach/1528733084515.doc',NULL,'.doc',51,'',1528733085983,1,NULL,NULL,0),
(175,'PDF',1,'http://47.94.98.20:8085/source/attach/1528733300907.pdf',NULL,'.pdf',50,'',1528733302368,1,NULL,NULL,0),
(176,'2',1,'http://47.94.98.20:8085/source/attach/1529314477715.jpg',NULL,'.jpg',45,'',1529314490824,1,NULL,NULL,0);

/*Table structure for table `insurance_company` */

DROP TABLE IF EXISTS `insurance_company`;

CREATE TABLE `insurance_company` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '保险公司id',
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '保险公司名称',
  `url_for_query` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '保险公司查询保单号地址',
  `url_index` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '保险公司官网',
  `phone` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '保险公司电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `insurance_company` */

insert  into `insurance_company`(`id`,`name`,`url_for_query`,`url_index`,`phone`) values 
(2,'泰康人寿44','泰康人寿保单查询页面44','泰康人寿保单查询页面主页44','123454444');

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

insert  into `oa_item`(`id`,`parent_id`,`name`,`sort`,`code`,`type`,`grade`,`master`,`master_name`,`company_name`,`item_flag`,`item_cycle`,`create_date`,`update_by`,`update_date`,`del_flag`,`remarks`,`create_by`) values 
(7,7,'项目名称sss',1,'项目编号：',NULL,NULL,1,'项目负责人姓名','施工单位名称','项目标识','项目周期',1527821857006,9999,1527821890223,0,NULL,9999),
(8,7,'ces',3,'2',NULL,NULL,2,'2','2','2','2',1527843165548,NULL,NULL,0,NULL,9999);

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
  `identity_num` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `insurance_purchases` varchar(255) DEFAULT NULL COMMENT '保险情况',
  `salary_details` varchar(255) DEFAULT NULL COMMENT '薪资情况',
  `address` varchar(100) DEFAULT NULL COMMENT '现住址',
  `status` int(5) DEFAULT '0' COMMENT '审核状态[0未审核 1已审核]',
  `company` varchar(100) DEFAULT NULL COMMENT '承包公司',
  `item_id` int(10) DEFAULT NULL COMMENT '所在项目id,关联oa_item主键',
  `item_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `professional_unit` varchar(100) DEFAULT NULL COMMENT '施工单位专业',
  `black_flag` int(5) DEFAULT '0' COMMENT '黑名单状态[0正常 ,1黑名单待审，2黑名单人员]',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建日期(时间戳格式)',
  `create_by` int(10) DEFAULT NULL COMMENT '创建人',
  `update_date` bigint(20) DEFAULT NULL COMMENT '修改日期(时间戳格式)',
  `update_by` int(10) DEFAULT NULL COMMENT '修改人',
  `del_flag` int(5) DEFAULT '0' COMMENT '逻辑删除标记[0正常,1已删除,2黑名单]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `oa_person` */

insert  into `oa_person`(`id`,`name`,`type`,`role_name`,`role_permission`,`gender`,`contact`,`identity_num`,`insurance_purchases`,`salary_details`,`address`,`status`,`company`,`item_id`,`item_name`,`professional_unit`,`black_flag`,`remark`,`create_date`,`create_by`,`update_date`,`update_by`,`del_flag`) values 
(3,'root',1,'root','per:all:*','男',NULL,NULL,NULL,NULL,NULL,0,'gongsai',NULL,NULL,NULL,0,NULL,NULL,1,NULL,NULL,0),
(22,'dsss',5,'worker','per:common:*','男','','w','{\"company\":\"\",\"order_num\":\"\"}','','',1,'gongsai',NULL,NULL,'',0,NULL,1529311393362,1,1529822227222,1,0),
(23,'ds',2,'checker','per:check:*','男','联系方式','ww','保险情况','心智情况','住址',1,'gongsai',NULL,NULL,'施工单位',0,NULL,1529311642393,1,1529311789363,1,0),
(24,'adas',2,'checker','per:check:*','男','dsa','','','','dsa',1,'gongsai',NULL,NULL,'',0,NULL,1529311952415,1,NULL,NULL,0),
(25,'ceswsss',5,'worker','per:common:*','男','1234567','111','中国保险','六月薪资已发','湖北武汉',0,'gongsai',NULL,NULL,'施工单位专业',0,NULL,1529314827119,1,1529816928278,1,0),
(26,'å¼ ä¸',5,'worker','per:common:*','男','15666666','420',NULL,NULL,NULL,0,'gongsai',NULL,NULL,NULL,2,NULL,1529325316097,27,1529325425209,27,0),
(27,'张三',5,NULL,NULL,NULL,NULL,'123',NULL,NULL,NULL,0,'s',NULL,NULL,NULL,0,'',1529817028800,1,1529817372981,1,0),
(28,'张建宇',5,'worker','per:common:*','男','1388','421','{\"company\":\"泰康人寿\",\"order_num\":\"111\"}','1','北京',0,'d',NULL,NULL,'1',0,NULL,1529817890999,1,NULL,NULL,0),
(29,'2',5,'worker','per:common:*','男','','2','{\"company\":\"\",\"order_num\":\"\"}','','',0,'e',NULL,NULL,'',0,NULL,1529821341746,1,NULL,NULL,0),
(30,'s',5,'worker','per:common:*','男','','','{\"company\":\"\",\"order_num\":\"\"}','','',0,NULL,NULL,NULL,'',0,NULL,1529821363547,1,NULL,NULL,0),
(31,'ddd',5,'worker','per:common:*','男','','','{\"company\":\"\",\"order_num\":\"\"}','','',0,NULL,NULL,NULL,'',0,NULL,1529821418508,1,NULL,NULL,0),
(32,'大大',2,'checker','per:check:*','男','','','{\"company\":\"\",\"order_num\":\"\"}','','',1,NULL,NULL,NULL,'',0,NULL,1529821428860,1,NULL,NULL,0),
(33,'55866',5,NULL,NULL,NULL,NULL,'56998555','6666985',NULL,NULL,0,'gongsai',NULL,NULL,'??????',0,NULL,1530282928110,1,1530282935226,1,0),
(34,'139876',5,NULL,NULL,NULL,NULL,'123456','197636',NULL,NULL,0,'gongsai',NULL,NULL,'????',0,NULL,1530354579869,1,NULL,NULL,0),
(35,'??',5,NULL,NULL,NULL,NULL,'666666','9999999',NULL,NULL,0,'gongsai',NULL,NULL,'????',0,NULL,1530364772720,1,NULL,NULL,0),
(36,'??',5,NULL,NULL,NULL,NULL,'123321','999999',NULL,NULL,0,'gongsai',NULL,NULL,'??????',0,NULL,1530365290409,1,NULL,NULL,0),
(37,'2',5,NULL,NULL,NULL,NULL,'3','{\"company\":\"6\",\"order_num\":\"5\",\"order_time\":\"7\"}',NULL,NULL,0,'8',NULL,NULL,'4',0,NULL,1530380463515,1,1530380471310,1,0);

/*Table structure for table `ref_person_exam_history` */

DROP TABLE IF EXISTS `ref_person_exam_history`;

CREATE TABLE `ref_person_exam_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `person_id` int(10) DEFAULT NULL COMMENT '人员id',
  `question_ids` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '题目id(2,3,4,10)这是一套试题的题目id集合',
  `wrong_ids` text CHARACTER SET utf8 COLLATE utf8_unicode_ci COMMENT '这套试卷做错的题目ids(2,3,10)',
  `full_score` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '100' COMMENT '这套试卷的满分',
  `obtain_score` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '这套试卷的得分',
  `exam_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '这套试卷的考试时间timestamp格式',
  `exam_type` int(10) DEFAULT NULL COMMENT '试题类别[1:平时练习,2:月份考试]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8 COMMENT='人员考试历史表';

/*Data for the table `ref_person_exam_history` */

insert  into `ref_person_exam_history`(`id`,`person_id`,`question_ids`,`wrong_ids`,`full_score`,`obtain_score`,`exam_time`,`exam_type`) values 
(1,3,'45,46,47,49,50,52,53,54,56,57,',NULL,'100',NULL,'1529492802120',1),
(2,3,'68,59,67,55,',NULL,'100',NULL,'1529831075690',1),
(3,3,'82,67,59,71,',NULL,'100',NULL,'1529831202948',1),
(4,3,'61,56,',NULL,'100',NULL,'1529833441247',1),
(5,3,'53,82,',NULL,'100',NULL,'1529833455400',1),
(6,3,'47,65,',NULL,'100',NULL,'1529833472206',1),
(7,3,'65,71,64,56,49,68,61,59,58,57,47,54,60,67,52,70,63,69,53,62,66,82,55,',NULL,'100',NULL,'1529835431874',2),
(8,3,'61,47,53,60,64,56,49,59,55,52,67,65,57,66,82,58,54,68,69,71,70,62,63,',NULL,'100',NULL,'1529835498528',2),
(9,3,'47,53,70,60,59,65,58,66,55,54,63,64,71,56,49,82,62,67,68,69,52,57,61,',NULL,'100',NULL,'1529835590917',2),
(10,3,'64,57,68,56,63,69,53,71,67,49,52,54,47,65,66,59,62,58,60,70,55,82,61,',NULL,'100',NULL,'1529835688921',2),
(11,3,'52,66,63,64,55,82,65,68,56,54,60,59,62,58,53,67,49,71,57,61,70,47,69,',NULL,'100',NULL,'1529835742570',2),
(12,3,'54,69,58,65,68,60,71,61,56,55,53,63,49,82,47,57,64,70,59,67,52,66,62,',NULL,'100',NULL,'1529835799295',2),
(13,3,'47,64,52,59,53,63,68,58,54,82,62,49,60,71,55,67,65,70,56,66,57,69,61,',NULL,'100',NULL,'1529836797549',2),
(14,3,'47,59,66,70,82,55,53,57,65,67,63,61,64,56,62,60,58,54,52,68,71,69,49,',NULL,'100',NULL,'1529836883713',2),
(15,3,'61,52,70,54,60,55,63,71,64,82,68,49,67,57,66,69,62,47,56,53,58,65,59,',NULL,'100',NULL,'1529836955593',2),
(16,3,'71,63,54,70,49,61,55,58,68,66,57,60,64,56,65,53,69,52,59,67,62,47,82,',NULL,'100',NULL,'1529837067334',2),
(17,3,'55,56,54,59,69,64,57,52,68,65,61,47,67,49,60,71,82,62,58,53,66,63,70,',NULL,'100',NULL,'1529837136117',2),
(18,3,'69,59,54,63,67,58,70,49,62,64,57,56,53,82,47,55,60,65,68,66,52,71,61,',NULL,'100',NULL,'1529837222517',2),
(19,3,'68,70,64,57,54,56,53,69,67,49,66,59,71,52,60,65,47,62,63,82,55,58,61,',NULL,'100',NULL,'1529837451669',2),
(20,3,'82,64,66,68,52,53,65,55,47,49,59,54,67,69,57,71,60,61,70,56,62,58,63,',NULL,'100',NULL,'1529837516726',2),
(21,3,'49,64,65,63,61,69,56,54,66,58,47,57,70,60,62,67,68,71,82,53,55,59,52,',NULL,'100',NULL,'1529837833901',2),
(22,3,'65,70,52,56,63,54,66,62,61,47,67,57,64,60,53,55,68,71,82,69,59,58,49,',NULL,'100',NULL,'1529837909528',2),
(23,3,'54,65,49,47,82,69,58,64,70,59,62,61,56,66,63,55,71,68,53,60,57,67,52,',NULL,'100',NULL,'1529845870708',2),
(24,3,'53,65,60,57,52,59,54,68,67,49,66,62,64,70,56,63,82,58,55,69,61,47,71,',NULL,'100',NULL,'1529846740902',2),
(25,3,'66,63,62,53,71,69,58,52,54,61,82,56,57,70,47,49,60,59,55,65,67,68,64,',NULL,'100',NULL,'1529846796367',2),
(26,3,'52,65,82,53,67,47,71,68,55,56,58,70,60,61,57,69,66,62,54,63,64,59,49,',NULL,'100',NULL,'1529846976204',2),
(27,3,'56,70,82,58,64,61,63,68,57,49,54,62,60,47,66,67,69,71,59,53,52,55,65,',NULL,'100',NULL,'1529847494985',2),
(28,3,'49,64,67,47,66,57,60,55,65,69,68,62,53,52,56,59,58,54,70,82,71,63,61,',NULL,'100',NULL,'1529847520664',2),
(29,3,'60,64,63,82,61,65,59,52,71,49,62,57,67,58,47,53,68,55,70,66,54,56,69,',NULL,'100',NULL,'1529851029689',2),
(30,3,'63,61,49,58,64,57,69,66,56,82,70,59,55,47,60,62,65,68,52,67,53,71,54,',NULL,'100',NULL,'1529851823903',2),
(31,3,'',NULL,'100',NULL,'1529851871108',0),
(32,3,'55,54,67,60,70,57,59,68,82,65,66,61,63,53,49,64,56,71,52,69,62,47,58,',NULL,'100',NULL,'1529851918738',2),
(33,3,'',NULL,'100',NULL,'1529851923165',0),
(34,3,'60,47,58,56,55,57,70,52,53,59,65,62,82,49,66,63,67,68,54,64,71,61,69,',NULL,'100',NULL,'1529852005533',2),
(35,3,'',NULL,'100',NULL,'1529852031786',0),
(36,3,'54,55,58,56,66,71,82,65,59,70,63,64,69,60,62,53,57,49,52,68,61,67,47,',NULL,'100',NULL,'1529852133074',2),
(37,3,'',NULL,'100',NULL,'1529852173709',0),
(38,3,'52,66,82,62,47,68,58,65,55,54,61,64,69,59,56,67,49,57,60,63,71,70,53,',NULL,'100',NULL,'1529852270894',2),
(39,3,'69,63,47,49,68,54,71,67,53,55,64,65,52,62,82,58,57,61,66,56,60,59,70,',NULL,'100',NULL,'1529926415046',2),
(40,3,'47,58,52,63,55,64,65,57,67,56,70,60,68,69,66,61,82,54,59,62,53,49,71,',NULL,'100',NULL,'1529932213502',2),
(41,3,'62,54,60,82,67,65,71,64,47,58,66,53,69,55,52,59,70,63,68,56,49,61,57,',NULL,'100',NULL,'1529932482357',2),
(42,3,'61,49,64,69,62,52,65,57,58,47,56,54,70,55,82,60,63,59,53,66,67,71,68,',NULL,'100',NULL,'1529933037791',2),
(43,3,'49,59,64,63,62,60,70,65,57,82,52,61,47,55,66,54,69,58,67,71,56,68,53,',NULL,'100',NULL,'1529933136593',2),
(44,3,'55,68,71,62,57,58,52,64,59,61,66,69,65,82,56,49,53,63,67,70,60,54,47,',NULL,'100',NULL,'1529933193216',2),
(45,3,'53,64,61,56,63,68,82,57,62,66,70,71,69,65,52,60,55,67,49,59,47,58,54,',NULL,'100',NULL,'1529933329579',2),
(46,3,'56,65,82,55,59,69,68,63,67,47,70,71,66,64,52,60,58,53,49,57,61,54,62,',NULL,'100',NULL,'1529933391819',2),
(47,3,'60,52,67,70,56,59,65,53,58,63,62,68,57,64,71,47,82,61,66,55,54,49,69,',NULL,'100',NULL,'1529933427613',2),
(48,3,'58,60,55,70,49,59,71,56,65,66,69,82,53,52,57,63,54,47,61,62,67,64,68,',NULL,'100',NULL,'1529933542004',2),
(49,3,'62,54,82,65,63,47,71,56,70,61,66,68,57,55,67,49,53,59,52,64,69,58,60,',NULL,'100',NULL,'1529933627649',2),
(50,3,'65,52,71,66,63,64,56,57,61,59,62,68,67,60,54,82,53,49,55,69,58,47,70,',NULL,'100',NULL,'1529933729946',2),
(51,3,'68,64,67,62,55,47,53,71,63,61,59,57,58,70,49,69,54,65,60,56,52,82,66,',NULL,'100',NULL,'1529933766739',2),
(52,3,'47,57,61,60,59,62,58,66,69,68,82,54,64,55,52,71,49,70,56,63,53,67,65,',NULL,'100',NULL,'1529935494638',2),
(53,3,'58,68,71,52,53,69,55,56,67,70,63,59,64,82,49,47,65,66,61,57,54,60,62,',NULL,'100',NULL,'1529935812648',2),
(54,3,'62,49,63,59,55,70,66,67,64,52,69,57,68,47,61,65,54,82,53,60,56,71,58,',NULL,'100',NULL,'1529936097861',2),
(55,3,'60,49,54,64,65,57,47,58,53,66,55,68,63,52,70,67,69,82,62,61,59,71,56,',NULL,'100',NULL,'1529936210190',2),
(56,3,'53,59,52,71,58,82,47,69,55,57,56,49,70,60,54,66,63,64,65,68,62,61,67,',NULL,'100',NULL,'1529936887197',2),
(57,3,'56,64,82,49,70,57,62,61,58,60,67,47,71,65,66,69,59,63,52,53,54,68,55,',NULL,'100',NULL,'1529937184028',2),
(58,3,'69,71,68,53,54,58,64,60,55,59,66,82,49,65,52,70,61,47,57,56,63,67,62,',NULL,'100',NULL,'1529937244757',2),
(59,3,'70,63,82,59,68,47,49,54,66,55,65,62,69,56,67,52,71,60,57,61,58,64,53,',NULL,'100',NULL,'1529937325292',2),
(60,3,'63,65,59,54,47,67,49,68,56,57,53,60,52,66,70,62,55,64,71,58,61,82,69,',NULL,'100',NULL,'1529937494028',2),
(61,3,'70,67,52,49,63,69,64,59,82,56,62,47,55,71,57,68,54,60,65,61,58,66,53,',NULL,'100',NULL,'1529937632269',2),
(62,3,'69,53,54,58,65,55,60,64,66,61,57,70,49,63,47,62,71,67,52,56,68,82,59,',NULL,'100',NULL,'1529937703165',2),
(63,3,'68,58,65,67,64,63,55,47,61,53,59,71,62,69,56,70,82,60,66,57,52,54,49,',NULL,'100',NULL,'1529939807569',2),
(64,3,'58,52,71,66,82,56,69,53,47,57,63,60,65,67,49,64,55,61,62,59,70,54,68,',NULL,'100',NULL,'1529939809755',2),
(65,3,'49,57,55,82,47,52,70,64,67,59,58,53,60,61,63,66,62,65,68,71,56,69,54,',NULL,'100',NULL,'1529942411541',2),
(66,3,'59,64,53,68,60,47,65,54,69,70,55,82,58,71,52,63,67,56,57,49,66,62,61,',NULL,'100',NULL,'1529942422616',2),
(67,3,'52,71,55,68,53,70,66,62,57,61,63,54,67,60,65,59,69,56,58,64,47,82,49,',NULL,'100',NULL,'1529942527194',2),
(68,3,'53,54,61,71,82,55,70,68,60,49,67,47,52,63,59,66,58,56,62,65,64,57,69,',NULL,'100',NULL,'1530017042349',2),
(69,3,'52,61,66,59,67,68,60,55,63,71,82,62,56,70,54,64,49,58,65,69,57,47,53,',NULL,'100',NULL,'1530017102772',2),
(70,3,'67,63,53,62,70,57,56,55,65,58,54,82,68,61,71,52,47,59,64,49,69,66,60,',NULL,'100',NULL,'1530017206175',2),
(71,3,'71,62,52,57,67,60,53,54,59,82,49,56,64,66,63,70,61,69,55,65,58,68,47,',NULL,'100',NULL,'1530017586155',2),
(72,3,'68,67,63,71,62,57,58,61,65,53,47,59,70,52,60,54,66,82,55,64,49,69,56,',NULL,'100',NULL,'1530017847228',2),
(73,3,'71,57,62,69,68,66,70,52,58,63,60,64,56,47,61,82,54,53,59,67,49,65,55,',NULL,'100',NULL,'1530018431066',2),
(74,3,'53,59,58,57,60,68,66,55,52,69,71,65,70,63,67,61,54,62,49,47,82,56,64,',NULL,'100',NULL,'1530018524095',2),
(75,3,'63,70,53,66,60,52,54,59,64,71,57,55,58,68,56,47,65,49,61,82,69,62,67,',NULL,'100',NULL,'1530018573372',2),
(76,3,'61,52,56,49,60,54,63,65,55,82,69,57,66,67,47,62,58,53,71,59,68,64,70,',NULL,'100',NULL,'1530019210773',2),
(77,3,'',NULL,'100',NULL,'1530019225575',0),
(78,3,'',NULL,'100',NULL,'1530019231524',0),
(79,3,'52,67,65,57,53,71,63,61,55,54,47,60,58,70,66,82,56,68,64,59,69,62,49,',NULL,'100',NULL,'1530019262984',2),
(80,3,'69,55,49,61,47,63,60,57,71,64,59,67,65,58,70,56,52,82,53,66,68,54,62,',NULL,'100',NULL,'1530035814231',2),
(81,3,'69,60,62,57,52,55,82,54,67,56,63,68,61,49,64,47,70,53,66,58,71,65,59,',NULL,'100',NULL,'1530036137012',2),
(82,3,'59,52,68,56,54,71,61,70,66,65,63,47,62,64,53,82,67,49,60,57,69,55,58,',NULL,'100',NULL,'1530036263758',2),
(83,3,'55,71,56,53,82,58,61,66,69,52,65,57,68,59,70,49,67,47,54,62,64,63,60,',NULL,'100',NULL,'1530036586749',2),
(84,3,'57,58,66,60,67,70,47,59,52,49,69,55,63,53,68,62,56,71,65,61,54,64,82,',NULL,'100',NULL,'1530036672377',2),
(85,3,'52,69,60,64,58,66,56,65,71,57,62,63,54,53,61,49,82,59,70,67,55,68,47,',NULL,'100',NULL,'1530036747492',2),
(86,3,'62,71,47,64,59,57,67,53,65,60,61,52,56,58,70,63,69,82,49,66,55,68,54,',NULL,'100',NULL,'1530037202158',2),
(87,3,'69,63,70,52,59,66,64,82,71,62,60,56,47,54,68,58,53,67,57,55,49,61,65,',NULL,'100',NULL,'1530037232269',2),
(88,3,'70,67,69,64,59,82,54,55,65,57,47,71,63,53,60,62,68,61,66,52,49,56,58,',NULL,'100',NULL,'1530037324327',2),
(89,3,'71,56,82,54,47,52,62,68,55,61,67,49,53,58,59,60,70,57,66,65,63,64,69,',NULL,'100',NULL,'1530037367552',2),
(90,3,'49,55,53,69,61,59,64,62,54,68,71,82,60,70,56,67,65,47,63,58,52,57,66,',NULL,'100',NULL,'1530037425471',2),
(91,3,'47,59,53,64,49,61,66,68,54,62,70,58,57,71,82,63,67,52,65,56,55,60,69,',NULL,'100',NULL,'1530037476971',2),
(92,3,'56,69,59,63,68,49,62,64,82,55,60,61,57,71,47,65,66,54,52,53,67,70,58,',NULL,'100',NULL,'1530037503319',2),
(93,3,'62,65,47,57,71,69,56,49,58,82,67,55,68,61,52,63,59,70,53,54,64,60,66,',NULL,'100',NULL,'1530037766743',2),
(94,3,'69,71,55,47,60,49,54,56,63,57,66,61,62,82,52,65,68,59,70,53,67,58,64,',NULL,'100',NULL,'1530038464261',2),
(95,3,'63,64,71,68,47,67,66,69,82,65,53,60,52,56,54,59,55,62,70,49,61,58,57,',NULL,'100',NULL,'1530038589078',2),
(96,3,'65,70,71,66,68,52,59,57,54,82,47,49,56,53,64,61,69,67,62,63,58,60,55,',NULL,'100',NULL,'1530038622000',2),
(97,3,'49,60,59,71,56,55,54,57,65,70,47,69,66,82,67,68,58,62,52,63,53,64,61,',NULL,'100',NULL,'1530038893295',2),
(98,3,'57,65,53,52,54,69,66,68,71,67,70,58,64,61,63,49,59,47,82,60,55,56,62,',NULL,'100',NULL,'1530038970735',2),
(99,3,'64,57,69,67,49,53,55,61,58,59,52,66,56,70,82,65,62,60,68,71,47,63,54,',NULL,'100',NULL,'1530039032770',2),
(100,3,'66,64,53,82,71,63,60,67,58,62,47,56,69,68,52,65,55,54,61,59,70,57,49,',NULL,'100',NULL,'1530039174712',2),
(101,3,'47,57,67,63,66,55,58,56,61,69,68,62,52,59,65,64,54,53,82,49,70,71,60,',NULL,'100',NULL,'1530039244433',2),
(102,3,'65,58,56,52,61,66,55,69,59,70,53,68,62,82,54,64,63,60,67,57,47,49,71,',NULL,'100',NULL,'1530039388877',2),
(103,3,'60,82,49,57,69,59,68,66,64,58,65,62,61,55,47,53,71,54,56,52,63,67,70,',NULL,'100',NULL,'1530039863558',2),
(104,3,'57,62,60,54,52,68,64,82,71,65,47,69,63,56,70,67,59,55,61,66,53,58,49,',NULL,'100',NULL,'1530039950170',2),
(105,3,'71,70,63,54,67,62,47,49,65,61,53,55,66,58,52,69,',NULL,'100',NULL,'1530067246849',1),
(106,3,'71,65,56,62,82,54,57,58,69,64,66,61,47,53,63,70,68,60,59,67,55,52,49,',NULL,'100',NULL,'1530104236306',2),
(107,3,'47,53,69,52,55,60,49,56,68,70,62,66,82,67,61,63,58,64,65,71,54,59,57,',NULL,'100',NULL,'1530105314759',2),
(108,3,'60,67,53,49,64,61,65,59,70,56,63,66,71,57,82,69,55,68,62,58,54,52,47,',NULL,'100',NULL,'1530105321424',2),
(109,3,'55,56,71,63,57,47,60,53,67,58,54,65,59,82,69,66,64,62,61,68,49,70,52,',NULL,'100',NULL,'1530105345210',2),
(110,3,'58,61,63,55,59,65,67,62,57,70,52,54,56,49,68,69,64,60,66,71,53,47,82,',NULL,'100',NULL,'1530105345621',2),
(111,3,'47,82,59,58,57,55,60,68,65,62,56,69,52,61,63,66,54,64,53,67,70,49,71,',NULL,'100',NULL,'1530105358889',2),
(112,3,'54,63,66,49,64,71,53,69,47,59,62,82,70,67,68,57,65,52,61,56,55,60,58,',NULL,'100',NULL,'1530105359091',2),
(113,3,'47,71,61,58,70,66,67,63,65,69,56,49,68,55,53,57,52,59,54,62,82,60,64,',NULL,'100',NULL,'1530105379134',2),
(114,3,'66,62,54,52,70,71,57,47,60,56,61,82,67,53,69,68,64,59,49,65,58,55,63,',NULL,'100',NULL,'1530105381601',2),
(115,3,'',NULL,'100',NULL,'1530105395766',0),
(116,3,'56,57,69,68,67,61,82,70,58,66,54,53,64,71,60,59,52,47,55,63,62,65,49,',NULL,'100',NULL,'1530105404338',2),
(117,3,'',NULL,'100',NULL,'1530105408858',0),
(118,3,'58,82,64,54,60,71,65,67,49,70,66,47,56,62,52,53,68,69,61,57,63,59,55,',NULL,'100',NULL,'1530105418181',2),
(119,3,'',NULL,'100',NULL,'1530105455261',0),
(120,3,'',NULL,'100',NULL,'1530105463230',0),
(121,3,'',NULL,'100',NULL,'1530105463274',0),
(122,3,'',NULL,'100',NULL,'1530105468318',0),
(123,3,'',NULL,'100',NULL,'1530105522760',0),
(124,3,'',NULL,'100',NULL,'1530105523601',0),
(125,3,'62,52,71,54,53,66,57,68,69,63,67,59,55,56,61,60,58,82,64,70,65,47,49,',NULL,'100',NULL,'1530105651699',2),
(126,3,'',NULL,'100',NULL,'1530105675632',0),
(127,3,'',NULL,'100',NULL,'1530105735411',0),
(128,3,'57,64,58,52,56,61,66,82,49,55,60,63,53,54,47,67,59,71,68,69,70,62,',NULL,'100',NULL,'1530105833147',1),
(129,3,'60,63,61,66,53,68,52,59,54,82,70,71,57,56,65,67,58,69,64,47,55,62,49,',NULL,'100',NULL,'1530105869775',1),
(130,3,'',NULL,'100',NULL,'1530105879912',0),
(131,3,'',NULL,'100',NULL,'1530105940400',0),
(132,3,'49,66,82,67,68,58,52,64,70,54,62,69,55,65,71,60,61,57,63,47,56,53,59,',NULL,'100',NULL,'1530106995352',2),
(133,3,'',NULL,'100',NULL,'1530107031003',0),
(134,3,'',NULL,'100',NULL,'1530107035008',0),
(135,3,'',NULL,'100',NULL,'1530107036994',0),
(136,3,'',NULL,'100',NULL,'1530107040459',0),
(137,3,'64,58,82,52,67,49,66,55,47,69,71,61,63,54,57,59,65,70,68,53,62,60,56,',NULL,'100',NULL,'1530107046214',2),
(138,3,'55,58,62,54,71,64,69,70,65,61,60,82,49,67,52,59,56,47,66,53,57,68,63,',NULL,'100',NULL,'1530107416732',2),
(139,3,'',NULL,'100',NULL,'1530109672988',0),
(140,3,'',NULL,'100',NULL,'1530109678023',0),
(141,3,'67,56,70,82,58,60,57,68,55,53,62,61,71,65,64,69,47,63,49,54,66,59,52,',NULL,'100',NULL,'1530111284381',1),
(142,3,'66,68,56,58,71,65,63,62,55,70,61,49,64,47,67,54,59,57,53,52,60,69,82,',NULL,'100',NULL,'1530111289775',1),
(143,3,'49,64,71,55,53,70,52,60,54,59,68,61,67,63,62,57,47,69,66,65,56,58,82,',NULL,'100',NULL,'1530111377959',1),
(144,3,'58,49,52,55,53,71,59,47,66,65,60,57,56,68,61,54,82,63,67,70,64,69,62,',NULL,'100',NULL,'1530112713378',1),
(145,3,'82,53,57,66,58,65,55,68,67,60,52,69,47,56,70,54,64,71,49,61,59,63,62,',NULL,'100',NULL,'1530112729653',1),
(146,3,'62,56,49,65,61,47,69,63,57,53,66,71,67,68,60,82,59,52,54,64,70,55,58,',NULL,'100',NULL,'1530112832279',1),
(147,3,'55,60,64,69,82,57,47,66,58,54,59,68,62,56,70,63,67,49,53,65,52,71,61,',NULL,'100',NULL,'1530112923322',1),
(148,3,'82,71,54,58,64,55,53,70,59,66,56,65,67,49,52,69,68,63,57,60,47,62,61,',NULL,'100',NULL,'1530113622240',1),
(149,3,'82,63,67,54,58,61,55,53,69,71,64,62,65,70,56,52,49,59,57,47,66,60,68,',NULL,'100',NULL,'1530113745267',1),
(150,3,'63,56,49,60,65,67,47,53,54,70,59,64,61,68,66,58,52,71,55,62,82,57,69,',NULL,'100',NULL,'1530114112510',1),
(151,3,'58,64,67,52,66,55,71,53,82,65,70,47,60,69,62,56,59,63,54,57,49,61,68,',NULL,'100',NULL,'1530115225887',2),
(152,3,'68,54,67,66,65,82,49,52,62,56,55,59,53,71,70,64,61,60,58,47,63,57,69,',NULL,'100',NULL,'1530115660691',1),
(153,3,'69,56,52,49,58,47,53,59,70,63,62,68,66,60,54,61,67,71,55,65,64,57,82,',NULL,'100',NULL,'1530115692460',1),
(154,3,'60,62,70,55,52,64,53,59,66,69,56,63,65,61,82,47,68,58,67,57,49,54,71,',NULL,'100',NULL,'1530116007397',1),
(155,3,'70,55,58,64,67,53,65,68,57,52,56,49,66,82,60,71,62,69,47,59,63,54,61,',NULL,'100',NULL,'1530116055629',2),
(156,3,'63,70,67,58,71,68,55,57,65,66,64,82,54,62,47,59,49,69,53,52,56,61,60,',NULL,'100',NULL,'1530116350793',2),
(157,3,'59,82,57,69,60,68,66,53,52,67,47,49,70,61,58,62,65,71,63,54,64,55,56,',NULL,'100',NULL,'1530116416548',2),
(158,3,'71,53,64,68,70,60,47,62,66,69,82,52,63,61,54,58,67,49,59,57,65,56,55,',NULL,'100',NULL,'1530116487788',1),
(159,3,'55,68,66,61,54,52,65,63,62,70,58,69,53,57,82,64,56,60,49,71,59,47,67,',NULL,'100',NULL,'1530116539302',1),
(160,3,'56,54,59,65,47,82,66,53,71,62,55,61,58,63,49,69,60,64,52,68,70,67,57,',NULL,'100',NULL,'1530193475338',2),
(161,3,'61,58,62,71,54,47,67,68,53,56,59,63,70,64,66,69,65,57,52,82,49,60,55,',NULL,'100',NULL,'1530280988891',2);

/*Table structure for table `ref_person_wrong_question` */

DROP TABLE IF EXISTS `ref_person_wrong_question`;

CREATE TABLE `ref_person_wrong_question` (
  `person_id` int(10) DEFAULT NULL COMMENT '人员id',
  `question_id` int(10) DEFAULT NULL COMMENT '问题id',
  `your_answer` varchar(100) DEFAULT NULL COMMENT '你的答案',
  `correct_answer` varchar(100) DEFAULT NULL COMMENT '正确答案'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='错题记录';

/*Data for the table `ref_person_wrong_question` */

insert  into `ref_person_wrong_question`(`person_id`,`question_id`,`your_answer`,`correct_answer`) values 
(1,1,'C','D'),
(3,22,'A','D'),
(3,1,'A','D'),
(3,47,'A','D');

/*Table structure for table `ref_role_menu` */

DROP TABLE IF EXISTS `ref_role_menu`;

CREATE TABLE `ref_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `menu_id` int(11) NOT NULL COMMENT '菜单编号',
  `school_id` int(11) NOT NULL COMMENT '学校、机构ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

/*Data for the table `ref_role_menu` */

insert  into `ref_role_menu`(`role_id`,`menu_id`,`school_id`) values 
(1,2,0),
(1,1,0),
(2,2,0),
(2,3,0),
(1,4,0);

/*Table structure for table `ref_user_role` */

DROP TABLE IF EXISTS `ref_user_role`;

CREATE TABLE `ref_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `school_id` int(11) NOT NULL COMMENT '机构ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

/*Data for the table `ref_user_role` */

insert  into `ref_user_role`(`user_id`,`role_id`,`school_id`) values 
(1,1,1),
(2,2,1),
(3,3,1),
(6,6,1),
(7,6,1),
(8,6,1),
(9,6,1),
(10,6,1),
(11,6,1),
(12,6,1),
(13,6,1);

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

insert  into `sys_menu`(`id`,`parent_id`,`parent_ids`,`name`,`sort`,`href`,`target`,`icon`,`is_show`,`permission`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`) values 
(1,0,'','添加学生',0,'student/add',NULL,NULL,0,'student:add',2,20160808084312,1,20160809021248,'<p>这个菜单能添加学生</p>',0),
(2,0,'','教程管理',0,'jc/*',NULL,NULL,0,'jc:manage:*',1,20160809021947,NULL,NULL,'<p>教程管理</p>',0),
(3,2,'','数学管理',0,'jc/shuxu',NULL,NULL,0,'jc:shuxu',1,20160809074410,NULL,NULL,'<p>数学管理</p>',0),
(4,0,'','天津展会',0,'device/tj-index',NULL,NULL,0,'tjzh:admin',1,20160809074410,NULL,NULL,NULL,0);

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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`name`,`ref_id`,`photo_url`,`create_by`,`create_date`,`update_by`,`update_date`,`remarks`,`del_flag`) values 
(1,'root','OE43szSeXws9orNa6ooYsQ==','超级管理员',3,'',0,20130527080000,1,20160615134945,'',0),
(26,'adas','OE43szSeXws9orNa6ooYsQ==','adas',24,NULL,1,1529311952589,NULL,NULL,NULL,0),
(27,'111','OE43szSeXws9orNa6ooYsQ==','ceswsss',25,'http://localhost:8085/source/attach/1529318353223.jpg',1,1529314827321,27,1529318371160,NULL,0),
(28,'420','OE43szSeXws9orNa6ooYsQ==','å¼ ä¸',26,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',27,1529325316284,NULL,NULL,NULL,0),
(29,'123','OE43szSeXws9orNa6ooYsQ==','张三',27,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1529817029005,NULL,NULL,NULL,0),
(30,'421','OE43szSeXws9orNa6ooYsQ==','张建宇',28,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1529817891256,NULL,NULL,NULL,0),
(31,'2','OE43szSeXws9orNa6ooYsQ==','2',29,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1529821341915,NULL,NULL,NULL,0),
(32,'','OE43szSeXws9orNa6ooYsQ==','s',30,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1529821363695,NULL,NULL,NULL,0),
(33,'','OE43szSeXws9orNa6ooYsQ==','ddd',31,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1529821418758,NULL,NULL,NULL,0),
(34,'','OE43szSeXws9orNa6ooYsQ==','大大',32,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1529821429007,NULL,NULL,NULL,0),
(35,'56998555','OE43szSeXws9orNa6ooYsQ==','55866',33,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1530282928132,NULL,NULL,NULL,0),
(36,'123456','OE43szSeXws9orNa6ooYsQ==','139876',34,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1530354579887,NULL,NULL,NULL,0),
(37,'666666','OE43szSeXws9orNa6ooYsQ==','??',35,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1530364772739,NULL,NULL,NULL,0),
(38,'123321','OE43szSeXws9orNa6ooYsQ==','??',36,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1530365290420,NULL,NULL,NULL,0),
(39,'3','OE43szSeXws9orNa6ooYsQ==','2',37,'http://47.94.98.20:8085/source/attach/headPic/head_defalut.png',1,1530380463713,NULL,NULL,NULL,0);

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

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `v_user` AS (select `s`.`id` AS `id`,`s`.`username` AS `username`,`s`.`password` AS `password`,`s`.`ref_id` AS `ref_id`,`s`.`photo_url` AS `photo_url`,`o`.`name` AS `name`,`o`.`type` AS `type`,`o`.`role_name` AS `role_name`,`o`.`role_permission` AS `role_permission`,`o`.`gender` AS `gender`,`o`.`contact` AS `contact`,`o`.`identity_num` AS `identity_num`,`o`.`insurance_purchases` AS `insurance_purchases`,`o`.`salary_details` AS `salary_details`,`o`.`address` AS `address`,`o`.`status` AS `status`,`o`.`item_id` AS `item_id`,`o`.`company` AS `item_name`,`o`.`professional_unit` AS `professional_unit`,`o`.`black_flag` AS `black_flag`,`ss`.`name` AS `create_user_name`,`o`.`create_by` AS `create_by`,`o`.`create_date` AS `create_date` from ((`sys_user` `s` left join `oa_person` `o` on((`s`.`ref_id` = `o`.`id`))) left join `sys_user` `ss` on((`o`.`create_by` = `ss`.`id`)))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
