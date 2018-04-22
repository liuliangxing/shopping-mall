package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.WechatUser;
import com.jbt.shopping.persistent.mappers.mall.WechatUserMapper;
import com.jbt.shopping.base.service.mall.WechatUserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  WechatUserServiceImpl<br/>
 * Description: WechatUserServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class WechatUserServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <WechatUserMapper, WechatUser> implements WechatUserService {

	@Autowired
	private  WechatUserMapper wechatUserMapper;
	
	public WechatUserMapper getWechatUserMapper(){
		return wechatUserMapper;
	}
}
