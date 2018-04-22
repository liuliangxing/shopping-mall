package com.jbt.shopping.base.service.mall;

import com.jbt.shopping.persistent.entity.mall.RoleAuthorities;
import com.baomidou.mybatisplus.service.IService;
import com.jbt.shopping.persistent.mappers.mall.RoleAuthoritiesMapper;
/**
 * 
 * ClassName:  RoleAuthoritiesService<br/>
 * Description: RoleAuthoritiesService Service <br/>
 * Date: 2018-03-21 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-21        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface RoleAuthoritiesService extends IService<RoleAuthorities> {
	
	public RoleAuthoritiesMapper getRoleAuthoritiesMapper();
}
