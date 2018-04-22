package com.jbt.shopping.biz.service.platform.role.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.destinyboy.jbt.utils.code.CodeUtil;
import com.jbt.shopping.biz.domain.platform.role.query.PlatformRoleServiceQuery;
import com.jbt.shopping.biz.service.platform.role.PlatformRoleService;
import com.jbt.shopping.base.service.FacadeService;
import com.jbt.shopping.persistent.entity.mall.Role;
import com.jbt.shopping.persistent.entity.mall.RoleAuthorities;
import com.jbt.shopping.persistent.entity.mall.UserRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * ClassName:  PlatformRoleServiceImpl<br/>
 * Description: PlatformRoleServiceImpl Service Impl <br/>
 * Date: 2018-03-29 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-29        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Service
public class PlatformRoleServiceImpl extends FacadeService implements PlatformRoleService {

    private final static String USER_ID = "user_id";
    private final static String ROLE_NAME = "role_name";
    private final static String ENABLED = "enabled";

    /**
     * 查询所有角色
     * @param query
     */
    public List<Role> getRoleList(PlatformRoleServiceQuery query) throws Exception{
        EntityWrapper<Role> roleEntityWrapper = new EntityWrapper<>();
        roleEntityWrapper.like(query.getRoleName() != null, ROLE_NAME, query.getRoleName());
        roleEntityWrapper.eq(query.getEnabled() != null, ENABLED, query.getEnabled());
        Page<Role> page = new Page(query.getPageIndex(),query.getPageSize());
        return CodeUtil.handlerDBCodeOptional(this.getRoleService()::selectPage, page, roleEntityWrapper).get().getRecords();
    }

    /**
     * 插入角色
     * @param query
     */
    public void addRole(PlatformRoleServiceQuery query) throws Exception{
        Role role = new Role();
        role.setRoleName(query.getRoleName());
        CodeUtil.handlerDBCodeOptional(this.getRoleService()::insert, role);

        List<Integer> authoritiesIds = query.getAuthoritiesIds();
        List<RoleAuthorities> roleAuthoritiesList = new ArrayList<>();
        for (Integer id: authoritiesIds) {
            RoleAuthorities roleAuthorities = new RoleAuthorities();
            roleAuthorities.setRoleId(role.getId());
            roleAuthorities.setAuthoritiesId(id);
            roleAuthoritiesList.add(roleAuthorities);
        }
//        CodeUt
    }

    /**
     * 编辑角色
     * @param query
     */
    public void editRole(PlatformRoleServiceQuery query) throws Exception{
        Role role = new Role();
        role.setId(query.getId());
        role.setRoleName(query.getRoleName());
        role.setEnabled(query.getEnabled());
        CodeUtil.handlerDBCodeOptional(this.getRoleService()::updateById, role);
    }


    /**
     * 根据UserId 获取角色
     * @param query
     * @return
     */
    public List<Integer> getRoleByUserId(PlatformRoleServiceQuery query)throws Exception {
        // 获取用户角色Id 集合
        List<Integer> roleIds = CodeUtil.handlerDBCodeOptional(this.getUserRoleService()::selectList, //
                new EntityWrapper<UserRole>().eq(USER_ID, query.getUserId()))//
                .map(userRoles -> userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()))//
                .get();
        return roleIds;
    }

}
