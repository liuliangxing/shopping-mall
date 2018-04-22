package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.UserAuthorities;
import com.jbt.shopping.persistent.mappers.mall.UserAuthoritiesMapper;
import com.jbt.shopping.base.service.mall.UserAuthoritiesService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  UserAuthoritiesServiceImpl<br/>
 * Description: UserAuthoritiesServiceImpl Service Impl <br/>
 * Date: 2018-03-21 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-21        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class UserAuthoritiesServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <UserAuthoritiesMapper, UserAuthorities> implements UserAuthoritiesService {

	@Autowired
	private  UserAuthoritiesMapper userAuthoritiesMapper;
	
	public UserAuthoritiesMapper getUserAuthoritiesMapper(){
		return userAuthoritiesMapper;
	}
}
