package com.activiti.junit.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyTaskListener implements TaskListener {  
	  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override  
    public void notify(DelegateTask delegateTask) {  
        // 根据业务从数据库中查询 相关人员  
        // .....业务查询代码  
          
        // 然后把获取到的用户通过下面方法，设置给当前触发事件的任务  
        delegateTask.setAssignee("10004");  
          
    }  
  
}  