package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.PlatformUser;
import com.jbt.shopping.persistent.mappers.mall.PlatformUserMapper;
import com.jbt.shopping.base.service.mall.PlatformUserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  PlatformUserServiceImpl<br/>
 * Description: PlatformUserServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformUserServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <PlatformUserMapper, PlatformUser> implements PlatformUserService {

	@Autowired
	private  PlatformUserMapper platformUserMapper;
	
	public PlatformUserMapper getPlatformUserMapper(){
		return platformUserMapper;
	}
}
