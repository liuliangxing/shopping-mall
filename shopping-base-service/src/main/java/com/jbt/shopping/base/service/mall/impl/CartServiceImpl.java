package com.jbt.shopping.base.service.mall.impl;

import com.jbt.shopping.persistent.entity.mall.Cart;
import com.jbt.shopping.persistent.mappers.mall.CartMapper;
import com.jbt.shopping.base.service.mall.CartService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * ClassName:  CartServiceImpl<br/>
 * Description: CartServiceImpl Service Impl <br/>
 * Date: 2018-03-11 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-11        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class CartServiceImpl extends  com.destinyboy.jbt.config.redis.RedisServiceImpl <CartMapper, Cart> implements CartService {

	@Autowired
	private  CartMapper cartMapper;
	
	public CartMapper getCartMapper(){
		return cartMapper;
	}
}
