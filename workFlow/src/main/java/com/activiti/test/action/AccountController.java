package com.activiti.test.action;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.plugins.Page;

@Controller
@RequestMapping("/account")
public class AccountController {

	private static Logger log = LoggerFactory.getLogger(AccountController.class);
	
	/**
	 * 任务管理，是activiti的任务服务类。可以从这个类中获取任务的信息。
	 */
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/list")
	public String list() {
		return "account";
	}
	
	@RequestMapping("/myTask")
	public String myTask(Model model,int page,int size) {
		String assignee = "";
		TaskQuery taskQuery = taskService.createTaskQuery()
				//.taskCandidateUser(candidateUser)//创建任务查询对象  
                //查询条件（where部分
				.taskAssignee(assignee)//指定个人任务查询，指定办理人  
                //排序
                .orderByTaskCreateTime().asc();//使用创建时间的升序排列  
                //返回结果集
                //.listPage(page, size);
		List<Task> list = taskQuery.listPage(page, size);
		int countTotal = Integer.parseInt(String.valueOf(taskQuery.count())); 
		Page<Task> res = new Page<>(page,size);
		res.setRecords(list);
		res.setTotal(countTotal);
		model.addAttribute("tasks", res);
		return "myTask";
	}
}
