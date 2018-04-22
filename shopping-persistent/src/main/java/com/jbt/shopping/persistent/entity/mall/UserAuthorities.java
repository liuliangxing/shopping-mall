package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;

public class UserAuthorities implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 运营用户ID
     */
    private Integer userId;

    /**
     * 权限Id
     */
    private Integer authoritiesId;

    /**
     * user_authorities
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        sb.append(", userId=").append(userId);
        sb.append(", authoritiesId=").append(authoritiesId);
        sb.append("]");
        return sb.toString();
    }
}