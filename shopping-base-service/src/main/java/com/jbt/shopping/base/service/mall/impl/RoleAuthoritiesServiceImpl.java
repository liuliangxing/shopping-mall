package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.RoleAuthorities;
import com.jbt.shopping.persistent.mappers.mall.RoleAuthoritiesMapper;
import com.jbt.shopping.base.service.mall.RoleAuthoritiesService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  RoleAuthoritiesServiceImpl<br/>
 * Description: RoleAuthoritiesServiceImpl Service Impl <br/>
 * Date: 2018-03-21 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-21        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class RoleAuthoritiesServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <RoleAuthoritiesMapper, RoleAuthorities> implements RoleAuthoritiesService {

	@Autowired
	private  RoleAuthoritiesMapper roleAuthoritiesMapper;
	
	public RoleAuthoritiesMapper getRoleAuthoritiesMapper(){
		return roleAuthoritiesMapper;
	}
}
