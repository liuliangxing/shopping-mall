package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.Activity;
import com.jbt.shopping.persistent.mappers.mall.ActivityMapper;
import com.jbt.shopping.base.service.mall.ActivityService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  ActivityServiceImpl<br/>
 * Description: ActivityServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class ActivityServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <ActivityMapper, Activity> implements ActivityService {

	@Autowired
	private  ActivityMapper activityMapper;
	
	public ActivityMapper getActivityMapper(){
		return activityMapper;
	}
}
