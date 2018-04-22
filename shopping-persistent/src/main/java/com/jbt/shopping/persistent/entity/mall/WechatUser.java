package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;

public class WechatUser implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * wechat_user
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [");
        sb.append("ClassName = ").append(getClass().getSimpleName());
        sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}