package com.jbt.shopping.base.service.mall;

import com.jbt.shopping.persistent.entity.mall.UserRole;
import com.baomidou.mybatisplus.service.IService;
import com.jbt.shopping.persistent.mappers.mall.UserRoleMapper;
/**
 * 
 * ClassName:  UserRoleService<br/>
 * Description: UserRoleService Service <br/>
 * Date: 2018-03-21 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-21        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface UserRoleService extends IService<UserRole> {
	
	public UserRoleMapper getUserRoleMapper();
}
