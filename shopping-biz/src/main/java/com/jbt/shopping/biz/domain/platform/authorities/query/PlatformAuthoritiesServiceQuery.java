package com.jbt.shopping.biz.domain.platform.authorities.query;

import com.jbt.shopping.biz.groups.platform.authorities.*;
import com.jbt.shopping.persistent.entity.mall.UserAuthorities;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ClassName:  PlatformAuthoritiesServiceQuery<br/>
 * Description: PlatformAuthoritiesServiceQuery Service <br/>
 * Date: 2018-03-22 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-22        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Data
public class PlatformAuthoritiesServiceQuery implements Serializable {
    /**
     * 唯一标志
     */
    @NotEmpty(groups = {GetAuthoritiesListGroup.class})
    private String token;

    /**
     * 用户ID
     */
    @NotNull(groups = {GetAuthoritiesListByUserIdGroup.class, GrantAuthoritiesByUserIdGroup.class, GetAuthoritiesAllByRoleGroup.class})
    private Integer userId;

    @NotNull(groups = {DelAuthoritiesGroup.class, EditAuthoritiesGroup.class})
    private Integer id;
    /**
     * 权限名称
     */
    @NotEmpty(groups = {AddAuthoritiesGroup.class})
    private String authoritiesName;

    /**
     * 菜单文本
     */
    @NotEmpty(groups = {AddAuthoritiesGroup.class})
    private String menuNotes;

    /**
     * 图片路径
     */
    private Integer iconName;

    /**
     * 是否启用：1启用 2禁用
     */
    private Integer enabled;

    /**
     * 父级菜单ID，顶级 为 -1
     */
    @NotNull(groups = {AddAuthoritiesGroup.class})
    private Integer parentId;

    /**
     * 菜单路径
     */
//    @NotEmpty(groups = {AddAuthoritiesGroup.class})
    private String menuPath;

    /**
     * 菜单级别
     */
    private Integer menuLevel;

    /**
     * 菜单层级
     */
    private Integer menuSort;

    /**
     * 权限类型： 1:菜单权限 2:页面权限 3:操作权限
     */
    @NotNull(groups = {AddAuthoritiesGroup.class, GetAuthoritiesByTypeGroup.class})
    private Integer type;

    /**
     * 权限 列表ID
     */
    @NotEmpty(groups = {GrantAuthoritiesByUserIdGroup.class})
    private List<UserAuthorities> authoritiesList = new ArrayList<>();
}
