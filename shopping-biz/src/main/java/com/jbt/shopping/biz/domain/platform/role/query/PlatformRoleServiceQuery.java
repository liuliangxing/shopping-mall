package com.jbt.shopping.biz.domain.platform.role.query;

import com.destinyboy.jbt.utils.page.PageQuery;
import com.jbt.shopping.biz.groups.platform.role.AddRoleGroup;
import com.jbt.shopping.persistent.entity.mall.RoleAuthorities;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

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

    private Integer id;

    /**
     * 角色名称
     */
    @NotEmpty(groups = {AddRoleGroup.class})
    private String roleName;

    /**
     * 是否启用： 1、启用 2、禁用
     */
    private Integer enabled;

    /**
     * 角色权限
     */
    @NotEmpty(groups = {AddRoleGroup.class})
    private List<Integer> authoritiesIds = new ArrayList<>();

    /**
     * 用户Id
     */
    private Integer userId;
}
