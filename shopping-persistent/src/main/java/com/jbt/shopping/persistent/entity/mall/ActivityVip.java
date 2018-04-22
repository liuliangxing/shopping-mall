package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;

public class ActivityVip implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 活动VIP
     */
    private Integer vipId;

    /**
     * 活动ID
     */
    private Integer activityId;

    /**
     * activity_vip
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [");
        sb.append("ClassName = ").append(getClass().getSimpleName());
        sb.append(", id=").append(id);
        sb.append(", vipId=").append(vipId);
        sb.append(", activityId=").append(activityId);
        sb.append("]");
        return sb.toString();
    }
}