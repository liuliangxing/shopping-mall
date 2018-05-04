package com.jbt.shopping.biz.domain.platform.role.query;

import com.destinyboy.jbt.utils.page.PageQuery;
import com.jbt.shopping.biz.groups.platform.role.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ClassName:  PlatformRoleServiceQuery<br/>
 * Description: PlatformRoleServiceQuery Service <br/>
 * Date: 2018-03-29 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-29        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Data
public class PlatformRoleServiceQuery extends PageQuery implements Serializable {

    @NotNull(groups = {GetAuthoritiesListGroup.class, DisableRoleGroup.class, EditRoleGroup.class})
    private Integer id;

    /**
     * 角色名称
     */
    @NotEmpty(groups = {AddRoleGroup.class})
    private String roleName;

    /**
     * 角色描述
     */
    @NotEmpty(groups = {AddRoleGroup.class})
    private String roleDesc;

    /**
     * 是否启用： 1、启用 2、禁用
     */
    @NotNull(groups = {DisableRoleGroup.class})
    private Integer enabled;


    /**
     * 角色权限
     */
    @NotEmpty(groups = {AddRoleGroup.class})
    private List<Integer> authoritiesIds = new ArrayList<>();

    /**
     * 用户Id
     */
    @NotNull(groups = {EditUserRoleGroup.class, GetRoleByUserIdGroup.class})
    private Integer userId;

    /**
     * 角色列表
     */
    private List<Integer> roleIds = new ArrayList<>();
}
