package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.AdvertisingPosition;
import com.jbt.shopping.persistent.mappers.mall.AdvertisingPositionMapper;
import com.jbt.shopping.base.service.mall.AdvertisingPositionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  AdvertisingPositionServiceImpl<br/>
 * Description: AdvertisingPositionServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class AdvertisingPositionServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <AdvertisingPositionMapper, AdvertisingPosition> implements AdvertisingPositionService {

	@Autowired
	private  AdvertisingPositionMapper advertisingPositionMapper;
	
	public AdvertisingPositionMapper getAdvertisingPositionMapper(){
		return advertisingPositionMapper;
	}
}
