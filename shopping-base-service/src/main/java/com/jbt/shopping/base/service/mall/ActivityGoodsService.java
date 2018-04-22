package com.jbt.shopping.base.service.mall;

import com.jbt.shopping.persistent.entity.mall.ActivityGoods;
import com.baomidou.mybatisplus.service.IService;
import com.jbt.shopping.persistent.mappers.mall.ActivityGoodsMapper;
/**
 * 
 * ClassName:  ActivityGoodsService<br/>
 * Description: ActivityGoodsService Service <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface ActivityGoodsService extends IService<ActivityGoods> {
	
	public ActivityGoodsMapper getActivityGoodsMapper();
}
