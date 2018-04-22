package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.ActivityVip;
import com.jbt.shopping.persistent.mappers.mall.ActivityVipMapper;
import com.jbt.shopping.base.service.mall.ActivityVipService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  ActivityVipServiceImpl<br/>
 * Description: ActivityVipServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class ActivityVipServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <ActivityVipMapper, ActivityVip> implements ActivityVipService {

	@Autowired
	private  ActivityVipMapper activityVipMapper;
	
	public ActivityVipMapper getActivityVipMapper(){
		return activityVipMapper;
	}
}
