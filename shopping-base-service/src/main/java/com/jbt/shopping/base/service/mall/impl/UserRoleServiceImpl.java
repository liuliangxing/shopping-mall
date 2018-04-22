package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.UserRole;
import com.jbt.shopping.persistent.mappers.mall.UserRoleMapper;
import com.jbt.shopping.base.service.mall.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  UserRoleServiceImpl<br/>
 * Description: UserRoleServiceImpl Service Impl <br/>
 * Date: 2018-03-21 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-21        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class UserRoleServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <UserRoleMapper, UserRole> implements UserRoleService {

	@Autowired
	private  UserRoleMapper userRoleMapper;
	
	public UserRoleMapper getUserRoleMapper(){
		return userRoleMapper;
	}
}
