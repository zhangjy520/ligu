package com.activiti.test.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	private static Logger log = LoggerFactory.getLogger(TaskController.class);

	@RequestMapping("/list")
	public String list() {
		return "task-list";
	}
}
