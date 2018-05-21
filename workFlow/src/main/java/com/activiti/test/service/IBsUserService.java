package com.activiti.test.service;

import com.activiti.test.entity.BsUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jun
 * @since 2018-05-14
 */
public interface IBsUserService extends IService<BsUser> {

	BsUser getUserByNameAndPassword(String name, String pwd);
	
}
