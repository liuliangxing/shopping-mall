package com.jbt.shopping.biz.service.platform.goods.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.jbt.shopping.biz.domain.platform.goods.query.PlatformGoodsServiceQuery;
import com.jbt.shopping.biz.service.platform.goods.PlatformGoodsService;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.persistent.entity.mall.Goods;
import com.jbt.shopping.persistent.entity.mall.GoodsClassify;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * ClassName:  PlatformGoodsServiceImpl<br/>
 * Description: PlatformGoodsServiceImpl Service Impl <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformGoodsServiceImpl extends FacadeService implements PlatformGoodsService {

    /**
     * 获取商品列表
     * @param query
     * @return
     */
    public List<Goods> getGoodsList (PlatformGoodsServiceQuery query) throws Exception{
        Wrapper<Goods> entityWrapper = new EntityWrapper<>();
        entityWrapper.like(query.getGoodsName() != null,"goods_name", query.getGoodsName());
        entityWrapper.eq(query.getGrounding() != null,"grounding", query.getGrounding());
        entityWrapper.and(query.getMinCount() != null,"goods_count >= {0}", query.getMinCount());
        entityWrapper.and(query.getMaxCount() != null, "goods_count <= {0}", query.getMaxCount());
        entityWrapper.and(query.getMinPrice() != null , "min_price >= {0}", query.getMinPrice());
        entityWrapper.and(query.getMaxPrice() != null , "min_price <= {0}", query.getMaxPrice());
        entityWrapper.and(query.getStartTime() != null, "create_time >= {0}", query.getStartTime());
        entityWrapper.and(query.getEndTime() != null, "create_time <= {0}", query.getEndTime());
        entityWrapper.eq(query.getSupplierId() != null, "supplier_id", query.getSupplierId());
        if (query.getGoodsClassifyList() != null && !query.getGoodsClassifyList().isEmpty()) {
            List<Integer> goodsClassifyIds = query.getGoodsClassifyList().stream().map(GoodsClassify::getId).collect(Collectors.toList());
            entityWrapper.in("classify_id", goodsClassifyIds);
        }
        List<Goods> goods = CodeUtil.handlerDBCodeOptional(this.getGoodsService()::selectList, entityWrapper).get();
        return goods;
    }

    public void getGoodsInfo (PlatformGoodsServiceQuery query) {

    }
}
