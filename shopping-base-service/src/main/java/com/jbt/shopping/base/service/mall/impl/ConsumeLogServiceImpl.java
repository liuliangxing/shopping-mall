package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.ConsumeLog;
import com.jbt.shopping.persistent.mappers.mall.ConsumeLogMapper;
import com.jbt.shopping.base.service.mall.ConsumeLogService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  ConsumeLogServiceImpl<br/>
 * Description: ConsumeLogServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class ConsumeLogServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <ConsumeLogMapper, ConsumeLog> implements ConsumeLogService {

	@Autowired
	private  ConsumeLogMapper consumeLogMapper;
	
	public ConsumeLogMapper getConsumeLogMapper(){
		return consumeLogMapper;
	}
}
