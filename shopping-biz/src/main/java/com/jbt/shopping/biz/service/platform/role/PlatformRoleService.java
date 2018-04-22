package com.jbt.shopping.biz.service.platform.role;

import com.jbt.shopping.biz.domain.platform.role.query.PlatformRoleServiceQuery;
import com.jbt.shopping.persistent.entity.mall.Role;

import java.util.List;

/**
 * 
 * ClassName:  PlatformRoleService<br/>
 * Description: PlatformRoleService Service <br/>
 * Date: 2018-03-29 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-29        Destiny       1.0              INIT-CREATE<br/>
 *
 */
public interface PlatformRoleService{

    /**
     * 查询所有角色
     * @param query
     */
    public List<Role> getRoleList(PlatformRoleServiceQuery query) throws Exception;

    /**
     * 插入角色
     * @param query
     */
    public void addRole(PlatformRoleServiceQuery query) throws Exception;

    /**
     * 编辑角色
     * @param query
     */
    public void editRole(PlatformRoleServiceQuery query) throws Exception;

    /**
     * 根据UserId 获取角色
     * @param query
     * @return
     */
    public List<Integer> getRoleByUserId(PlatformRoleServiceQuery query)throws Exception;
}
