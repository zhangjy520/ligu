package com.activiti.test.utils;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateACTTable {
	
	private static Logger log = LoggerFactory.getLogger(CreateACTTable.class);
	
	/** 使用代码创建工作流需要的23张表 */
	public static void createTable() {
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		// 连接数据库的配置
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration.setJdbcUrl("jdbc:mysql://47.106.151.82:3306/activiti?useUnicode=true&characterEncoding=utf8&useSSL=false");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("EAE4db17443f");

		/**
		 * public static final String DB_SCHEMA_UPDATE_FALSE = "false";不能自动创建表，需要表存在
		 * public static final String DB_SCHEMA_UPDATE_CREATE_DROP =
		 * "create-drop";先删除表再创建表 public static final String DB_SCHEMA_UPDATE_TRUE =
		 * "true";如果表不存在，自动创建表
		 */
		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		// 工作流的核心对象，ProcessEnginee对象
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println("processEngine:" + processEngine);
	}
	
	public static void main(String[] args) {
		createTable();
	}

}
