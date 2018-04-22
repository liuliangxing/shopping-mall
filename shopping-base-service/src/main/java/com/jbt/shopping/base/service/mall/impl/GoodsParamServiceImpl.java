package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.GoodsParam;
import com.jbt.shopping.persistent.mappers.mall.GoodsParamMapper;
import com.jbt.shopping.base.service.mall.GoodsParamService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  GoodsParamServiceImpl<br/>
 * Description: GoodsParamServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class GoodsParamServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <GoodsParamMapper, GoodsParam> implements GoodsParamService {

	@Autowired
	private  GoodsParamMapper goodsParamMapper;
	
	public GoodsParamMapper getGoodsParamMapper(){
		return goodsParamMapper;
	}
}
