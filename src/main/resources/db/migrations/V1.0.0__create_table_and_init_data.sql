-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: smart_board
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `device_ring`
--

DROP TABLE IF EXISTS `device_ring`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device_ring` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) DEFAULT NULL COMMENT '教师名',
  `mac` varchar(100) NOT NULL COMMENT '设备mac地址',
  `ring_num` int(10) DEFAULT NULL COMMENT '手环编号',
  `location` varchar(255) DEFAULT NULL COMMENT '位置【section_grade_class_index】\r\n学段、年级、班级、序号\r\n中间用 "_" 隔开',
  `signal_level` int(10) DEFAULT NULL COMMENT '信号等级',
  `last_update` bigint(20) DEFAULT NULL COMMENT '最后更新时间',
  `student_id` int(11) DEFAULT NULL COMMENT '学生id',
  `student_name` varchar(255) DEFAULT NULL COMMENT '学生姓名',
  `station_mac` varchar(100) DEFAULT NULL COMMENT '基站MAC',
  `station_name` varchar(100) DEFAULT NULL COMMENT '基站名称',
  `status` int(10) NOT NULL DEFAULT '0' COMMENT '设备状态[0未激活, 1激活正常, 2:异常，3丢失，4脱腕]',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='硬件-手环';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_ring`
--

LOCK TABLES `device_ring` WRITE;
/*!40000 ALTER TABLE `device_ring` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_ring` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_station`
--

DROP TABLE IF EXISTS `device_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device_station` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `station_mac` varchar(255) NOT NULL COMMENT '设备mac地址',
  `screen_mac` varchar(255) DEFAULT NULL COMMENT '显示器mac',
  `class_name` varchar(255) DEFAULT NULL COMMENT '教室名称',
  `location` varchar(255) DEFAULT NULL COMMENT '位置【section_grade_class_index】\r\n学段、年级、班级、序号\r\n中间用 "_" 隔开',
  `type` int(10) DEFAULT NULL COMMENT '基站类型【0扫描数据，1计算发送数据】',
  `status` int(10) DEFAULT NULL COMMENT '设备状态[0:正常, 1:异常]',
  `last_update` bigint(20) DEFAULT NULL COMMENT '更新时间戳',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='硬件-基站表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_station`
--

LOCK TABLES `device_station` WRITE;
/*!40000 ALTER TABLE `device_station` DISABLE KEYS */;
/*!40000 ALTER TABLE `device_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_class_section`
--

DROP TABLE IF EXISTS `org_class_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_class_section` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `school_id` int(11) DEFAULT NULL COMMENT '机构ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `short_name` varchar(255) DEFAULT NULL COMMENT '简称',
  `limit_age` int(10) DEFAULT NULL COMMENT '入学年龄',
  `section_year` int(10) DEFAULT NULL COMMENT '学制[学校6，初中3，高中3等等]',
  `del_flag` int(10) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='学段-学制表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_class_section`
--

LOCK TABLES `org_class_section` WRITE;
/*!40000 ALTER TABLE `org_class_section` DISABLE KEYS */;
INSERT INTO `org_class_section` VALUES (1,2,'小学','小',6,6,0,NULL,1,1000005555,NULL,NULL),(2,1,'小学','小',6,6,0,NULL,1,111,NULL,NULL),(3,2,'高中','高',15,3,0,NULL,1,1,NULL,NULL),(4,2,'初中','初',12,3,0,NULL,1,1,NULL,NULL),(5,1,'初中','初',12,3,0,NULL,1,1,NULL,NULL),(6,1,'高中','高',15,3,0,NULL,1,1,NULL,NULL);
/*!40000 ALTER TABLE `org_class_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_grade_class`
--

DROP TABLE IF EXISTS `org_grade_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_grade_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `school_id` int(11) DEFAULT NULL COMMENT '机构ID',
  `name` varchar(255) DEFAULT NULL COMMENT '班级名称',
  `short_name` varchar(255) DEFAULT NULL COMMENT '班级简称',
  `xd` int(10) DEFAULT NULL COMMENT '学段[1小学, 2初中, 3高中， 4大学]',
  `nj` int(10) DEFAULT NULL COMMENT '年级[数字表示 如 2]',
  `bh` int(10) DEFAULT NULL COMMENT '班号[班级顺序]',
  `bjlx` int(10) DEFAULT NULL COMMENT '班级类型',
  `master_id` int(11) DEFAULT NULL COMMENT '班主任ID',
  `master_name` varchar(100) DEFAULT NULL COMMENT '班主任名称',
  `del_flag` int(10) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_grade_class`
--

LOCK TABLES `org_grade_class` WRITE;
/*!40000 ALTER TABLE `org_grade_class` DISABLE KEYS */;
INSERT INTO `org_grade_class` VALUES (1,2,'二班','jwc',2,1,2,NULL,NULL,NULL,0,NULL,1,1000005555,NULL,NULL);
/*!40000 ALTER TABLE `org_grade_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_school`
--

DROP TABLE IF EXISTS `org_school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` int(11) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` int(10) NOT NULL COMMENT '排序',
  `area_id` int(11) NOT NULL COMMENT '归属区域',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `type` int(10) NOT NULL COMMENT '机构类型[0 root， 1 教育局， 2 学校]',
  `grade` int(10) NOT NULL COMMENT '机构等级',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `m_id` int(11) DEFAULT NULL COMMENT '管理员id',
  `master` varchar(100) DEFAULT NULL COMMENT '负责人',
  `zip_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `patriarch_rule` int(10) DEFAULT NULL COMMENT '生产家长账号规则[1按照名字全拼]',
  `student_rule` int(10) DEFAULT NULL COMMENT '生产学生账号规则[1按照名字全拼]',
  `teacher_rule` int(10) DEFAULT NULL COMMENT '生产教师账号规则[1按照名字全拼]',
  `short_flag` varchar(100) DEFAULT NULL COMMENT '机构短标识，全局唯一',
  `deploy_url` varchar(255) DEFAULT NULL COMMENT '部署路径-强制跳转的标识',
  `userable` varchar(64) DEFAULT NULL COMMENT '是否启用',
  `primary_persion` varchar(64) DEFAULT NULL COMMENT '主负责人',
  `deputy_persion` varchar(64) DEFAULT NULL COMMENT '副负责人',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(10) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='机构表【教育局、学校】';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_school`
--

LOCK TABLES `org_school` WRITE;
/*!40000 ALTER TABLE `org_school` DISABLE KEYS */;
INSERT INTO `org_school` VALUES (1,0,'海淀一区',10,1,'100000',1,1,'',NULL,'','','','','',NULL,NULL,NULL,NULL,NULL,'1','','',1,20130527080000,2,20160806130606,'',0),(2,0,'海淀二区',10,2,'100004',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,1,20130527080000,2,20130527080000,NULL,0),(3,2,'中关村8中',1,2,'100004',2,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,1,20130527080000,2,20130527080000,NULL,0),(4,1,'中关村1小',30,2,'100003',2,1,'',NULL,'','','','','',NULL,NULL,NULL,NULL,NULL,'1','','',1,20130527080000,1,20160111231027,'',0),(5,1,'中关村1小',40,2,'100004',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1',NULL,NULL,1,20130527080000,2,20160809044637,NULL,0);
/*!40000 ALTER TABLE `org_school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref_role_menu`
--

DROP TABLE IF EXISTS `ref_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `menu_id` int(11) NOT NULL COMMENT '菜单编号',
  `school_id` int(11) NOT NULL COMMENT '学校、机构ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref_role_menu`
--

LOCK TABLES `ref_role_menu` WRITE;
/*!40000 ALTER TABLE `ref_role_menu` DISABLE KEYS */;
INSERT INTO `ref_role_menu` VALUES (1,2,0),(1,1,0),(2,2,0),(2,3,0),(1,4,0);
/*!40000 ALTER TABLE `ref_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref_role_school`
--

DROP TABLE IF EXISTS `ref_role_school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_role_school` (
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `school_id` int(11) NOT NULL COMMENT '机构编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结构-角色映射（机构有哪些角色）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref_role_school`
--

LOCK TABLES `ref_role_school` WRITE;
/*!40000 ALTER TABLE `ref_role_school` DISABLE KEYS */;
INSERT INTO `ref_role_school` VALUES (1,1),(1,2),(1,3),(1,4),(2,2),(2,5);
/*!40000 ALTER TABLE `ref_role_school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref_teacher_class`
--

DROP TABLE IF EXISTS `ref_teacher_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_teacher_class` (
  `teacher_id` int(11) NOT NULL COMMENT '老师ID',
  `class_id` int(11) NOT NULL COMMENT '班级ID',
  PRIMARY KEY (`teacher_id`,`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师-班级';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref_teacher_class`
--

LOCK TABLES `ref_teacher_class` WRITE;
/*!40000 ALTER TABLE `ref_teacher_class` DISABLE KEYS */;
INSERT INTO `ref_teacher_class` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `ref_teacher_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ref_user_role`
--

DROP TABLE IF EXISTS `ref_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `school_id` int(11) NOT NULL COMMENT '机构ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ref_user_role`
--

LOCK TABLES `ref_user_role` WRITE;
/*!40000 ALTER TABLE `ref_user_role` DISABLE KEYS */;
INSERT INTO `ref_user_role` VALUES (1,1,1),(2,2,1),(3,3,1),(6,6,1),(7,6,1),(8,6,1),(9,6,1),(10,6,1),(11,6,1),(12,6,1),(13,6,1);
/*!40000 ALTER TABLE `ref_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scan_log`
--

DROP TABLE IF EXISTS `scan_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scan_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `mac` varchar(255) NOT NULL COMMENT '设备mac地址',
  `ring_num` int(10) DEFAULT NULL COMMENT '手环编号',
  `ring_signal` int(10) DEFAULT NULL COMMENT '手环信号',
  `station_mac` varchar(255) DEFAULT '0' COMMENT '基站mac',
  `location` varchar(255) DEFAULT NULL COMMENT '位置【section_grade_class_index】\r\n学段、年级、班级、序号\r\n中间用 "_" 隔开',
  `name` varchar(255) DEFAULT NULL COMMENT '教室名',
  `student_id` int(11) DEFAULT NULL COMMENT '学生ID',
  `student_name` varchar(100) DEFAULT NULL COMMENT '学生姓名',
  `type` int(10) DEFAULT NULL COMMENT '基站类型【0扫描数据，1计算发送数据】',
  `status` int(10) DEFAULT NULL COMMENT '设备状态[0:正常, 1:异常]',
  `last_update` bigint(20) DEFAULT NULL COMMENT '更新时间戳',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='扫描信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scan_log`
--

LOCK TABLES `scan_log` WRITE;
/*!40000 ALTER TABLE `scan_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `scan_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_app`
--

DROP TABLE IF EXISTS `sys_app`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_app` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) DEFAULT NULL COMMENT '教师名',
  `icon_url` varchar(1000) DEFAULT NULL COMMENT '图标路径',
  `web_url` varchar(1000) DEFAULT NULL COMMENT '网页路径',
  `pic_url` varchar(1000) DEFAULT NULL COMMENT '介绍图片',
  `app_status` int(10) DEFAULT NULL COMMENT '应用状态[0:审核中, 1:已上线, 2:下线, 3:其他异常]',
  `is_default` int(10) DEFAULT '0' COMMENT '是否是默认应用',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='应用表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_app`
--

LOCK TABLES `sys_app` WRITE;
/*!40000 ALTER TABLE `sys_app` DISABLE KEYS */;
INSERT INTO `sys_app` VALUES (1,'a','http://a.com','http://b.com',NULL,0,NULL,1,20160701144536,2,20160808070830,'<p>aaa</p>',0);
/*!40000 ALTER TABLE `sys_app` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_config` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `smtp` varchar(64) DEFAULT NULL COMMENT '邮箱服务器地址',
  `port` varchar(64) DEFAULT NULL COMMENT '邮箱服务器端口',
  `mailname` varchar(64) DEFAULT NULL COMMENT '系统邮箱地址',
  `mailpassword` varchar(64) DEFAULT NULL COMMENT '系统邮箱密码',
  `smsname` varchar(64) DEFAULT NULL COMMENT '短信用户名',
  `smspassword` varchar(64) DEFAULT NULL COMMENT '短信密码',
  `school_id` int(11) DEFAULT '0' COMMENT '结构ID',
  `logo_url` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT 'logo地址',
  `remarks` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT '介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='系统配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES (1,'smtp.qq.com','25','xxx@qq.com','xxx','xxx','xxxx',NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父级编号',
  `create_by` int(10) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(10) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`),
  KEY `sys_dict_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_mdict`
--

DROP TABLE IF EXISTS `sys_mdict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_mdict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_by` int(10) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(10) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`),
  KEY `sys_mdict_parent_id` (`parent_id`),
  KEY `sys_mdict_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='多级字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_mdict`
--

LOCK TABLES `sys_mdict` WRITE;
/*!40000 ALTER TABLE `sys_mdict` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_mdict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,0,'','添加学生',0,'student/add',NULL,NULL,0,'student:add',2,20160808084312,1,20160809021248,'<p>这个菜单能添加学生</p>',0),(2,0,'','教程管理',0,'jc/*',NULL,NULL,0,'jc:manage:*',1,20160809021947,NULL,NULL,'<p>教程管理</p>',0),(3,2,'','数学管理',0,'jc/shuxu',NULL,NULL,0,'jc:shuxu',1,20160809074410,NULL,NULL,'<p>数学管理</p>',0),(4,0,'','天津展会',0,'device/tj-index',NULL,NULL,0,'tjzh:admin',1,20160809074410,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_monitor`
--

DROP TABLE IF EXISTS `sys_monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_monitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cpu` varchar(64) DEFAULT NULL COMMENT 'cpu使用率',
  `jvm` varchar(64) DEFAULT NULL COMMENT 'jvm使用率',
  `ram` varchar(64) DEFAULT NULL COMMENT '内存使用率',
  `toemail` varchar(64) DEFAULT NULL COMMENT '警告通知邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='系统监控';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_monitor`
--

LOCK TABLES `sys_monitor` WRITE;
/*!40000 ALTER TABLE `sys_monitor` DISABLE KEYS */;
INSERT INTO `sys_monitor` VALUES (1,'99','99','99','xxxxxxx@qq.com');
/*!40000 ALTER TABLE `sys_monitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `enname` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `role_identify` varchar(255) DEFAULT NULL COMMENT '角色标识',
  `role_type` int(10) DEFAULT NULL COMMENT '角色类型',
  `useable` varchar(64) DEFAULT NULL COMMENT '是否可用',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT '0' COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`),
  KEY `sys_role_enname` (`enname`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'超级管理员','root','root',0,'1',1,20160808083942,1,20160809022433,'<p>我是校长.</p>',0),(2,'区级管理员','admin','admin',1,'1',1,20160809021736,1,20160809022413,'<p>教务处主任，主管学籍.</p>',0),(3,'老师','teacher','teacher',2,'1',1,20160809021736,NULL,0,NULL,0),(4,'学生','student','student',3,'1',1,20160809021736,NULL,0,NULL,0),(5,'加上','patriarch','patriarch',4,'1',1,20160809021736,NULL,0,NULL,0),(6,'班牌绑定管理员','board_user','board_user',5,'1',1,20160810181036,NULL,0,NULL,0);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `school_id` int(11) DEFAULT NULL COMMENT '机构ID',
  `username` varchar(100) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `ref_id` int(11) NOT NULL COMMENT '用户引用ID',
  `user_type` int(10) NOT NULL COMMENT '用户类型[0:root, 1:教师, 2:学生, 3:家长]',
  `photo_url` varchar(1000) DEFAULT NULL COMMENT '用户头像',
  `login_flag` int(10) DEFAULT NULL COMMENT '是否可登录',
  `login_mark` varchar(64) DEFAULT NULL COMMENT '用于单点登录的随机字符串验证',
  `create_by` int(10) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(10) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_user_login_name` (`username`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,0,'root','1V9pPSvWhG5yBSXo/9JNGw==','超级管理员',1,0,'',1,NULL,0,20130527080000,1,20160615134945,'',0),(2,1,'admin','1V9pPSvWhG5yBSXo/9JNGw==','管理员',1,1,NULL,1,NULL,0,20160805162304,1,20160805162313,'',0),(3,2,'teacher','1V9pPSvWhG5yBSXo/9JNGw==','老师',1,2,'',1,NULL,0,20160805162304,1,20160805162313,'',0),(4,2,'student','1V9pPSvWhG5yBSXo/9JNGw==','学生',1,3,'',1,NULL,0,20160805162304,1,20160805162313,'',0),(5,2,'patriarch','1V9pPSvWhG5yBSXo/9JNGw==','学生家长',1,4,'',1,NULL,0,20160805162304,1,20160805162313,'',0),(6,0,'user1','1V9pPSvWhG5yBSXo/9JNGw==','天津展会',1,5,NULL,1,NULL,0,20160805162304,NULL,NULL,NULL,0),(7,0,'user2','1V9pPSvWhG5yBSXo/9JNGw==','天津展会',1,5,NULL,1,NULL,0,20160805162304,NULL,NULL,NULL,0),(8,0,'user3','1V9pPSvWhG5yBSXo/9JNGw==','天津展会',1,5,NULL,1,NULL,0,20160805162304,NULL,NULL,NULL,0),(9,0,'user4','1V9pPSvWhG5yBSXo/9JNGw==','天津展会',1,5,NULL,1,NULL,0,20160805162304,NULL,NULL,NULL,0),(10,0,'user5','1V9pPSvWhG5yBSXo/9JNGw==','天津展会',1,5,NULL,1,NULL,0,20160805162304,NULL,NULL,NULL,0),(11,0,'user6','1V9pPSvWhG5yBSXo/9JNGw==','天津展会',1,5,NULL,1,NULL,0,20160805162304,NULL,NULL,NULL,0),(12,0,'user7','1V9pPSvWhG5yBSXo/9JNGw==','天津展会',1,5,NULL,1,NULL,0,20160805162304,NULL,NULL,NULL,0),(13,0,'kunming','1V9pPSvWhG5yBSXo/9JNGw==','云南昆明',1,5,NULL,1,NULL,0,20160805162304,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_student`
--

DROP TABLE IF EXISTS `user_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_student` (
  `id` int(11) NOT NULL COMMENT '主键',
  `school_id` int(11) NOT NULL COMMENT '结构ID[所属学校ID]',
  `class_id` int(11) DEFAULT NULL COMMENT '班级ID',
  `student_account` varchar(100) DEFAULT NULL COMMENT '学生登录账号',
  `patriach_account` varchar(100) DEFAULT NULL COMMENT '家长登录账号',
  `xsxm` varchar(64) DEFAULT NULL COMMENT '学生姓名',
  `xmpy` varchar(64) DEFAULT NULL COMMENT '姓名拼音',
  `ywm` varchar(64) DEFAULT NULL COMMENT '学生英文名',
  `ysbj` varchar(10) DEFAULT NULL COMMENT '预设班级',
  `xsxb` int(10) DEFAULT NULL COMMENT '性别',
  `xssg` int(11) DEFAULT NULL COMMENT '身高',
  `xstz` int(11) DEFAULT NULL COMMENT '体重',
  `xjh` varchar(64) DEFAULT NULL COMMENT '学籍号',
  `xh` varchar(64) DEFAULT NULL COMMENT '学号',
  `qgxjh` varchar(64) DEFAULT NULL COMMENT '全国学籍号',
  `jyid` varchar(64) DEFAULT NULL COMMENT '教育ID号',
  `csrq` bigint(20) DEFAULT NULL COMMENT '出生日期',
  `syd` varchar(64) DEFAULT NULL COMMENT '生源地',
  `yxzjlx` varchar(64) DEFAULT NULL COMMENT '有效证件类型',
  `yxzjh` varchar(64) DEFAULT NULL COMMENT '有效证件号',
  `sfbjgb` varchar(1) DEFAULT NULL COMMENT '是否是班级干部',
  `sfjs` varchar(1) DEFAULT NULL COMMENT '是否是军属',
  `sfcj` varchar(1) DEFAULT NULL COMMENT '是否残疾',
  `sfsbt` varchar(1) DEFAULT NULL COMMENT '是否是双胞胎',
  `sbtxh` varchar(64) DEFAULT NULL COMMENT '双胞胎序号',
  `xslb` varchar(1) DEFAULT NULL COMMENT '学生类别',
  `gb` varchar(64) DEFAULT NULL COMMENT '国别',
  `mz` varchar(10) DEFAULT NULL COMMENT '民族',
  `jg` varchar(10) DEFAULT NULL COMMENT '籍贯',
  `zzmm` varchar(1) DEFAULT NULL COMMENT '政治面貌',
  `jdfs` varchar(1) DEFAULT NULL COMMENT '就读方式',
  `xzz` varchar(64) DEFAULT NULL COMMENT '现住址',
  `txdz` varchar(64) DEFAULT NULL COMMENT '通讯地址',
  `hkxz` varchar(64) DEFAULT NULL COMMENT '户口性质',
  `hkszd` varchar(64) DEFAULT NULL COMMENT '户口所在地',
  `hkszdxxdz` varchar(64) DEFAULT NULL COMMENT '户口所在地-详细地址',
  `sfabshkxsdd` varchar(1) DEFAULT NULL COMMENT '是否按本市户口学生对待',
  `sfbsxj` varchar(1) DEFAULT NULL COMMENT '是否本市学籍',
  `zslb` varchar(64) DEFAULT NULL COMMENT '招生类别',
  `xszp` varchar(64) DEFAULT NULL COMMENT '学生照片',
  `dyzh` varchar(64) DEFAULT NULL COMMENT '学生对应用户账户id',
  `jzzh` varchar(64) DEFAULT NULL COMMENT '学生家长账户id',
  `rxnd` varchar(10) DEFAULT NULL COMMENT '入学年度',
  `status` int(10) DEFAULT NULL COMMENT '学生状态[0正常，1离校，2删除，3在籍不在校]',
  `del_flag` int(10) DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `create_by` int(10) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(10) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_student`
--

LOCK TABLES `user_student` WRITE;
/*!40000 ALTER TABLE `user_student` DISABLE KEYS */;
INSERT INTO `user_student` VALUES (1,2,1,'zhangsan',NULL,'张三','zhangsan','szhang',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,1,11,NULL,NULL),(2,2,3,'zhangyi',NULL,'张一','zhangyi','s1zhang',NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,1,1,NULL,NULL),(3,2,1,'liyi',NULL,'李一','liyi','first',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,1,1,NULL,NULL),(4,2,2,'lier',NULL,'李二','lier','second',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,1,1,NULL,NULL),(5,1,2,NULL,NULL,'李三','lisan','third',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,1,1,NULL,NULL);
/*!40000 ALTER TABLE `user_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_teacher`
--

DROP TABLE IF EXISTS `user_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `school_id` int(11) NOT NULL COMMENT '机构ID',
  `department_id` int(11) NOT NULL COMMENT '部门ID',
  `name` varchar(255) DEFAULT NULL COMMENT '教师名',
  `quan_pin` varchar(255) DEFAULT NULL COMMENT '姓名全拼',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `identity` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  `account` varchar(100) DEFAULT NULL COMMENT '教师登录账号',
  `is_manage` int(10) DEFAULT '0' COMMENT '是否是管理员[0不是，1是]',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `title_id` int(11) DEFAULT NULL COMMENT '职务ID-[职务管理]',
  `no` varchar(100) DEFAULT NULL COMMENT '职工编号',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `start_work` bigint(20) DEFAULT NULL COMMENT '参加工作时间',
  `jszw` int(11) DEFAULT NULL COMMENT '教师职务ID',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` bigint(20) NOT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` int(10) DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='教师表：教育局、学校职工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_teacher`
--

LOCK TABLES `user_teacher` WRITE;
/*!40000 ALTER TABLE `user_teacher` DISABLE KEYS */;
INSERT INTO `user_teacher` VALUES (1,1,0,'zhangsan',NULL,1,'6422288978594930294','0',NULL,NULL,NULL,NULL,'55655587','13569868745','a@a.a',20120613115429,NULL,1,1212,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `user_teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-01 15:27:38
