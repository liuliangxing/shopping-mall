package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.ActivityGoods;
import com.jbt.shopping.persistent.mappers.mall.ActivityGoodsMapper;
import com.jbt.shopping.base.service.mall.ActivityGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  ActivityGoodsServiceImpl<br/>
 * Description: ActivityGoodsServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class ActivityGoodsServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <ActivityGoodsMapper, ActivityGoods> implements ActivityGoodsService {

	@Autowired
	private  ActivityGoodsMapper activityGoodsMapper;
	
	public ActivityGoodsMapper getActivityGoodsMapper(){
		return activityGoodsMapper;
	}
}
