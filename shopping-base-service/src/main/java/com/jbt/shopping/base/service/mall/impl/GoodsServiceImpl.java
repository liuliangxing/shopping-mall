package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.Goods;
import com.jbt.shopping.persistent.mappers.mall.GoodsMapper;
import com.jbt.shopping.base.service.mall.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  GoodsServiceImpl<br/>
 * Description: GoodsServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class GoodsServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <GoodsMapper, Goods> implements GoodsService {

	@Autowired
	private  GoodsMapper goodsMapper;
	
	public GoodsMapper getGoodsMapper(){
		return goodsMapper;
	}
}
