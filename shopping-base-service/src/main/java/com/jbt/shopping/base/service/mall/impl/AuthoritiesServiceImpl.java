package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.Authorities;
import com.jbt.shopping.persistent.mappers.mall.AuthoritiesMapper;
import com.jbt.shopping.base.service.mall.AuthoritiesService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  AuthoritiesServiceImpl<br/>
 * Description: AuthoritiesServiceImpl Service Impl <br/>
 * Date: 2018-03-21 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-21        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class AuthoritiesServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <AuthoritiesMapper, Authorities> implements AuthoritiesService {

	@Autowired
	private  AuthoritiesMapper authoritiesMapper;
	
	public AuthoritiesMapper getAuthoritiesMapper(){
		return authoritiesMapper;
	}
}
