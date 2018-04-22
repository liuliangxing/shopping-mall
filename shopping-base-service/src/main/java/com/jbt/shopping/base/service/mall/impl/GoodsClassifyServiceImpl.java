package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.GoodsClassify;
import com.jbt.shopping.persistent.mappers.mall.GoodsClassifyMapper;
import com.jbt.shopping.base.service.mall.GoodsClassifyService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  GoodsClassifyServiceImpl<br/>
 * Description: GoodsClassifyServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class GoodsClassifyServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <GoodsClassifyMapper, GoodsClassify> implements GoodsClassifyService {

	@Autowired
	private  GoodsClassifyMapper goodsClassifyMapper;
	
	public GoodsClassifyMapper getGoodsClassifyMapper(){
		return goodsClassifyMapper;
	}
}
