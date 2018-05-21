package com.activiti.junit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class ACTTest extends BaseJunit4Test {

	private static Logger log = LoggerFactory.getLogger(ACTTest.class);

	/**
	 * 在Activiti中最核心的类，其他的类都是由他而来。
	 */
	@Autowired
	private ProcessEngine processEngine;

	/**
	 * 管理流程定义
	 */
	@Autowired
	private RepositoryService repositoryService;

	/**
	 * 执行管理，包括启动、推进、删除流程实例等操作，是activiti的流程执行服务类。可以从这个服务类中获取很多关于流程执行相关的信息。
	 */
	@Autowired
	private RuntimeService runtimeService;

	/**
	 * 历史管理(执行完的数据的管理)，是activiti的查询历史信息的类。在一个流程执行完成后，这个对象为我们提供查询历史信息。
	 */
	@Autowired
	private HistoryService historyService;

	/**
	 * 组织机构管理
	 */
	@Autowired
	private IdentityService identityService;

	/**
	 * 任务管理，是activiti的任务服务类。可以从这个类中获取任务的信息。
	 */
	@Autowired
	private TaskService taskService;

	/**
	 * 一个可选服务，任务表单管理
	 */
	@Autowired
	private FormService formService;

	/**
	 * 
	 */
	@Autowired
	private ManagementService managementService;

	@Test//调用这个空方法启动spring容器，初始化工作流相关配置
	@Transactional // 标明此方法需使用事务
	@Rollback(true) // 标明使用完此方法后事务不回滚,true时为回滚
	public void init() {

		log.info("junit success!注入工作流引擎processEngine:{}", processEngine == null?"activiti初始化失败":"activiti启动成功");
	}

	/**
	 * 发布流程定义
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void createProcessDefinition1() {
		Deployment deployment = processEngine.getRepositoryService()// 与流程定义和部署对象相关的Service
				.createDeployment()// 创建一个部署对象
				.name("部署第一个自定义流程模型")// 添加部署名称
				.addClasspathResource("activiti/MyProcess.bpmn")// 从classpath的资源中加载，一次只能加载一个文件
				.addClasspathResource("activiti/MyProcess.png").deploy();// 完成部署
		
		
		System.out.println("部署ID：" + deployment.getId());
		System.out.println("部署名称:" + deployment.getName());
	}

	/**
	 * 查询流程定义
	 */
	@Test
	@Transactional
	@Rollback(true)
	public void findProcessDefinition() {
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()// 创建一个流程定义查询
				/* 指定查询条件,where条件 */
				// .deploymentId(deploymentId)//使用部署对象ID查询
				// .processDefinitionId(processDefinitionId)//使用流程定义ID查询
				// .processDefinitionKey(processDefinitionKey)//使用流程定义的KEY查询
				// .processDefinitionNameLike(processDefinitionNameLike)//使用流程定义的名称模糊查询

				/* 排序 */
				.orderByProcessDefinitionVersion().asc()// 按照版本的升序排列
				// .orderByProcessDefinitionName().desc()//按照流程定义的名称降序排列
				.list();// 返回一个集合列表，封装流程定义
		// .singleResult();//返回唯一结果集
		// .count();//返回结果集数量
		// .listPage(firstResult, maxResults)//分页查询

		if (!list.isEmpty()) {
			for (ProcessDefinition processDefinition : list) {
				System.out.println("流程定义ID:" + processDefinition.getId());// 流程定义的key+版本+随机生成数
				System.out.println("流程定义名称:" + processDefinition.getName());// 对应HelloWorld.bpmn文件中的name属性值
				System.out.println("流程定义的key:" + processDefinition.getKey());// 对应HelloWorld.bpmn文件中的id属性值
				System.out.println("流程定义的版本:" + processDefinition.getVersion());// 当流程定义的key值相同的情况下，版本升级，默认从1开始
				System.out.println("资源名称bpmn文件:" + processDefinition.getResourceName());
				System.out.println("资源名称png文件:" + processDefinition.getDiagramResourceName());
				System.out.println("部署对象ID:" + processDefinition.getDeploymentId());
				System.out.println("################################");
			}
		}

	}
	
	/**
	 * 删除流程定义
	 */
	@Test
	@Transactional
	@Rollback(true)
	public void deleteProcessDefinition() {
		// 得到repositoryService
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 根据流程定义id查询部署id
		String processDefinitionId = "purchasingflow:8:1204";
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		// 流程定义所属部署id
		String deploymentId = processDefinition.getDeploymentId();
		// 1.根据流程部署id删除这一次部署的所有流程定义
		// 建议一次部署只部署一个流程，根据流程部署id删除一个流程的定义
		// 约束：如果该流程定义没有启动流程实例可以删除，如果该流程定义以及启动流程实例，不允许删除，如果删除就抛出异常
		repositoryService.deleteDeployment(deploymentId);

		// 2.级联删除：不管该流程定义是否启动流程实例（是否使用），通过级联删除将该流程定义及相关的信息全部删除
		// 一般情况下不适用级联删除，一般情况下对流程定义执行暂停操作
		// 特殊情况下需要删除流程定义及相关的信息，就要使用级联删除，删除的功能给超级管理员使用
		// repositoryService.deleteDeployment(deploymentId,true);
	}

	/**
	 * 启动流程实例
	 */
	@Test
	@Transactional
	@Rollback(false)
	public void startProcess() {
		/**启动流程实例的同时，设置流程变量，使用流程变量用来指定任务的办理人，对应MyProcess.pbmn文件中#{user1}*/  
        Map<String, Object> variables = new HashMap<String, Object>();  
        variables.put("user1", "10001");  //设置流程变量，这里user1对应事先流程定义中的处理人变量user1，可以额外定义自己需要的流程变量
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess",variables);
		log.info("user1进入myProcess流程，流程实例id：processInstance.id：{}", processInstance.getId());
	}
	
	/** 
	 * 1.3 为指定的流程实例设置流程变量 
	 */  
	@Test  
	@Transactional
	@Rollback(true)
	public void execution_setVar() {  
	    String executionId = "601";  
	    Map<String, Object> variables = new HashMap<>();  
	    variables.put("value", "流程变量");  
	    // 在流程实例的办理过程中设置流程变量 ，可以同时设置多个
	    runtimeService.setVariables(executionId, variables);  
	    //设置单个流程变量
	    // runtimeService.setVariable(executionId, variableName, value);  
	  
	    // 在流程实例提交时设置流程变量  
	    // runtimeService.signal(executionId, variables);  
	}
	
	/** 
	 * 2.1 获取流程变量(使用RuntimeService) 
	 */  
	@Test  
	@Transactional
	@Rollback(true)
	public void runtimeServ_getVar() {  
	    System.out.println("=======指定单个属性获取变量=========");  
	    String executionId = "601";  
	    String variableName = "请假原因";  
	    String value = (String) runtimeService.getVariableLocal(executionId, variableName);  
	    System.out.println(variableName+"="+value);  
	      
	    System.out.println("=======指定多个属性获取变量=========");  
	    Collection<String> variableNames = new ArrayList<>();  
	    variableNames.add("请假天数");  
	    variableNames.add("请假日期");  
	    Map<String, Object> variables = runtimeService.getVariables(executionId, variableNames );  
	    for (String key : variables.keySet()) {  
	        System.out.println(key+"="+variables.get(key));  
	    }  
	      
	    System.out.println("=======指定全部属性获取变量=========");  
	    Map<String, Object> variables2 = runtimeService.getVariables(executionId);  
	    for (String key : variables2.keySet()) {  
	        System.out.println(key+"="+variables2.get(key));  
	    }  
	}  

	
	
	/**
	 * 查询当前人的个人任务
	 * */  
    @Test  
    @Transactional
	@Rollback(true)
    public void findMyPersonalTask(){  
        String assignee = "10004";  
        String candidateUser = "10003";  
        List<Task> list = taskService.createTaskQuery()
        				//.taskCandidateUser(candidateUser)//创建任务查询对象  
                        //查询条件（where部分
        				.taskAssignee(assignee)//指定个人任务查询，指定办理人  
                        //排序
                        .orderByTaskCreateTime().asc()//使用创建时间的升序排列  
                        //返回结果集
                        .list();//返回列表  
        if(!list.isEmpty()){  
            for(Task task:list){  
                System.out.println("任务ID:"+task.getId());  
                System.out.println("任务名称:"+task.getName());  
                System.out.println("任务的创建时间:"+task.getCreateTime());  
                System.out.println("任务的办理人:"+task.getAssignee());  
                System.out.println("流程实例ID："+task.getProcessInstanceId());
                System.out.println("执行对象ID:"+task.getExecutionId());  
                System.out.println("流程定义ID:"+task.getProcessDefinitionId());
                System.out.println("########################################################");  
            }  
        }  
    } 
    
    /**
     * 完成我的任务
     * */  
    @Test  
    @Transactional
	@Rollback(false)
    public void completeMyPersonalTaskSuquest(){  
    	try {
	    	//任务ID  
	        String taskId = "27505";  
	          
	        //完成任务的同时，设置流程变量，使用流程变量用来指定完成任务后，下一个连线
	        Map<String, Object> variables = new HashMap<String, Object>();  
	        //variables.put("outcome", IsAgree);  
	        String users = "10002,10003";
	        variables.put("user2", users);  //完成时同时指定下一节点的处理人id,这里可以同时指定多个人
        	taskService.complete(taskId,variables); 
        	System.out.println("完成任务：任务ID："+taskId);  
		} catch (Exception e) {
			log.info(e.getMessage());
		}
    }  
    
    /**
     * 认领并完成任务
     * */  
    @Test  
    @Transactional
	@Rollback(false)
    public void completeCandidateUserTaskSuquest(){  
    	try {
	    	//任务ID  
	        String taskId = "30003";  
	          
	        taskService.claim(taskId ,"10002"); //认领任务，让用户成为任务的执行者  
        	taskService.complete(taskId); 
        	System.out.println("完成任务：任务ID："+taskId);  
		} catch (Exception e) {
			log.info(e.getMessage());
		}
    } 
}
