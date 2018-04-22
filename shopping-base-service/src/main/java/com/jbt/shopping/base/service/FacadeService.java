package com.jbt.shopping.base.service;

import com.jbt.shopping.base.service.mall.UserRoleService;
import com.jbt.shopping.base.service.mall.UserAuthoritiesService;
import com.jbt.shopping.base.service.mall.RoleAuthoritiesService;
import com.jbt.shopping.base.service.mall.RoleService;
import com.jbt.shopping.base.service.mall.AuthoritiesService;
import com.jbt.shopping.base.service.mall.MyCollectionService;
import com.jbt.shopping.base.service.mall.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * ClassName:  FacadeService<br/>
 * Description: FacadeService <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public abstract class FacadeService{
	@Autowired
	private UserRoleService userRoleService;
	public UserRoleService getUserRoleService() {
		return userRoleService;
	}
	@Autowired
	private UserAuthoritiesService userAuthoritiesService;
	public UserAuthoritiesService getUserAuthoritiesService() {
		return userAuthoritiesService;
	}
	@Autowired
	private RoleAuthoritiesService roleAuthoritiesService;
	public RoleAuthoritiesService getRoleAuthoritiesService() {
		return roleAuthoritiesService;
	}
	@Autowired
	private RoleService roleService;
	public RoleService getRoleService() {
		return roleService;
	}
	@Autowired
	private AuthoritiesService authoritiesService;
	public AuthoritiesService getAuthoritiesService() {
		return authoritiesService;
	}
	@Autowired
	private MyCollectionService myCollectionService;
	public MyCollectionService getMyCollectionService() {
		return myCollectionService;
	}
	@Autowired
	private CartService cartService;
	public CartService getCartService() {
		return cartService;
	}
	@Autowired
	private WechatUserService wechatUserService;
	public WechatUserService getWechatUserService() {
		return wechatUserService;
	}
	@Autowired
	private VipService vipService;
	public VipService getVipService() {
		return vipService;
	}
	@Autowired
	private PlatformUserService platformUserService;
	public PlatformUserService getPlatformUserService() {
		return platformUserService;
	}
	@Autowired
	private GoodsStyleService goodsStyleService;
	public GoodsStyleService getGoodsStyleService() {
		return goodsStyleService;
	}
	@Autowired
	private GoodsParamService goodsParamService;
	public GoodsParamService getGoodsParamService() {
		return goodsParamService;
	}
	@Autowired
	private GoodsClassifyService goodsClassifyService;
	public GoodsClassifyService getGoodsClassifyService() {
		return goodsClassifyService;
	}
	@Autowired
	private GoodsService goodsService;
	public GoodsService getGoodsService() {
		return goodsService;
	}
	@Autowired
	private ConsumeLogService consumeLogService;
	public ConsumeLogService getConsumeLogService() {
		return consumeLogService;
	}
	@Autowired
	private ClassifyDetailsService classifyDetailsService;
	public ClassifyDetailsService getClassifyDetailsService() {
		return classifyDetailsService;
	}
	@Autowired
	private ActivityVipService activityVipService;
	public ActivityVipService getActivityVipService() {
		return activityVipService;
	}
	@Autowired
	private ActivityGoodsService activityGoodsService;
	public ActivityGoodsService getActivityGoodsService() {
		return activityGoodsService;
	}
	@Autowired
	private ActivityService activityService;
	public ActivityService getActivityService() {
		return activityService;
	}
	@Autowired
	private SupplierService supplierService;
	public SupplierService getSupplierService() {
		return supplierService;
	}
	@Autowired
	private AdvertisingPositionService advertisingPositionService;
	public AdvertisingPositionService getAdvertisingPositionService() {
		return advertisingPositionService;
	}
	

}
