package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;

public class RoleAuthorities implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 权限Id
     */
    private Integer authoritiesId;

    /**
     * role_authorities
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAuthoritiesId() {
        return authoritiesId;
    }

    public void setAuthoritiesId(Integer authoritiesId) {
        this.authoritiesId = authoritiesId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [");
        sb.append("ClassName = ").append(getClass().getSimpleName());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", authoritiesId=").append(authoritiesId);
        sb.append("]");
        return sb.toString();
    }
}