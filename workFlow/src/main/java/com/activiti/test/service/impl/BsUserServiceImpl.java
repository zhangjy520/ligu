package com.activiti.test.service.impl;

import com.activiti.test.entity.BsUser;
import com.activiti.test.mapper.BsUserMapper;
import com.activiti.test.service.IBsUserService;
import com.activiti.test.service.support.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jun
 * @since 2018-05-14
 */
@Service
public class BsUserServiceImpl extends BaseServiceImpl<BsUserMapper, BsUser> implements IBsUserService {
	
	@Autowired
	private BsUserMapper bsUserMapper;

	@Override
	public BsUser getUserByNameAndPassword(String name, String pwd) {
		return bsUserMapper.selectUserByNameAndPassword(name,pwd);
	}
	
}
