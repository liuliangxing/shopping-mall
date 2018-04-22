package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.GoodsStyle;
import com.jbt.shopping.persistent.mappers.mall.GoodsStyleMapper;
import com.jbt.shopping.base.service.mall.GoodsStyleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  GoodsStyleServiceImpl<br/>
 * Description: GoodsStyleServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class GoodsStyleServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <GoodsStyleMapper, GoodsStyle> implements GoodsStyleService {

	@Autowired
	private  GoodsStyleMapper goodsStyleMapper;
	
	public GoodsStyleMapper getGoodsStyleMapper(){
		return goodsStyleMapper;
	}
}
