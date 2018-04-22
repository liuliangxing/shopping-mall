package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.Role;
import com.jbt.shopping.persistent.mappers.mall.RoleMapper;
import com.jbt.shopping.base.service.mall.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  RoleServiceImpl<br/>
 * Description: RoleServiceImpl Service Impl <br/>
 * Date: 2018-03-21 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-21        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class RoleServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <RoleMapper, Role> implements RoleService {

	@Autowired
	private  RoleMapper roleMapper;
	
	public RoleMapper getRoleMapper(){
		return roleMapper;
	}
}
