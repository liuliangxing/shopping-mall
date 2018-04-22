package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.Vip;
import com.jbt.shopping.persistent.mappers.mall.VipMapper;
import com.jbt.shopping.base.service.mall.VipService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  VipServiceImpl<br/>
 * Description: VipServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class VipServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <VipMapper, Vip> implements VipService {

	@Autowired
	private  VipMapper vipMapper;
	
	public VipMapper getVipMapper(){
		return vipMapper;
	}
}
