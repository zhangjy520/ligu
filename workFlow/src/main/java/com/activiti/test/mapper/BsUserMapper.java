package com.activiti.test.mapper;

import org.apache.ibatis.annotations.Param;

import com.activiti.test.entity.BsUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author jun
 * @since 2018-05-14
 */
public interface BsUserMapper extends BaseMapper<BsUser> {

	BsUser selectUserByNameAndPassword(@Param("name")String name, @Param("pwd")String pwd);

}