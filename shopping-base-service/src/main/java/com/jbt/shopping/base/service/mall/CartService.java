package com.jbt.shopping.base.service.mall;

import com.jbt.shopping.persistent.entity.mall.Cart;
import com.baomidou.mybatisplus.service.IService;
import com.jbt.shopping.persistent.mappers.mall.CartMapper;
/**
 * 
 * ClassName:  CartService<br/>
 * Description: CartService Service <br/>
 * Date: 2018-03-11 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-11        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface CartService extends IService<Cart> {
	
	public CartMapper getCartMapper();
}
