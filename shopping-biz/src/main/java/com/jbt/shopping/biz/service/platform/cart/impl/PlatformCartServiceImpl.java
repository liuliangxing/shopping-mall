package com.jbt.shopping.biz.service.platform.cart.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.jbt.shopping.biz.domain.platform.cart.query.PlatformCartServiceQuery;
import com.jbt.shopping.biz.domain.platform.cart.vo.GetCartListVo;
import com.jbt.shopping.biz.service.platform.cart.PlatformCartService;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.common.constants.Constants;
import com.jbt.shopping.persistent.entity.mall.Cart;
import com.jbt.shopping.persistent.entity.mall.Goods;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * ClassName:  PlatformCartServiceImpl<br/>
 * Description: PlatformCartServiceImpl Service Impl <br/>
 * Date: 2018-03-11 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-11        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformCartServiceImpl extends FacadeService implements PlatformCartService {

    public List<GetCartListVo> getCartList (PlatformCartServiceQuery query) throws Exception{

        Cart cart = new Cart();
        cart.setUserId(query.getUserId());

        List<Cart> carts = CodeUtil.handlerDBCodeOptional(this.getCartService()::selectList, new EntityWrapper<>(cart)).get();
        if (carts == null || carts.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> goodsIds = carts.stream().map(Cart::getGoodsId).collect(Collectors.toList());
        Wrapper<Goods> entityWrapper = new EntityWrapper<>();
        entityWrapper.in("id", goodsIds);
        entityWrapper.eq("enabled", Constants.GLOBAL_ENABLE_NORMAL);
        List<Goods> goodsList = CodeUtil.handlerDBCodeOptional(this.getGoodsService()::selectList, entityWrapper).get();
        return null;
        //        if () {
//
//        }
    }
}
