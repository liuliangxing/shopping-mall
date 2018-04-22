package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;
import java.util.Date;

public class Vip implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 开始数量
     */
    private Integer startCount;

    /**
     * 结束数量
     */
    private Integer endCount;

    /**
     * 会员名称
     */
    private Integer vipName;

    /**
     * vip 等级
     */
    private Integer vipGrade;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Date createTime;

    /**
     * 是否启用: 1:启用 2: 禁用
     */
    private Integer enabled;

    /**
     * vip
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartCount() {
        return startCount;
    }

    public void setStartCount(Integer startCount) {
        this.startCount = startCount;
    }

    public Integer getEndCount() {
        return endCount;
    }

    public void setEndCount(Integer endCount) {
        this.endCount = endCount;
    }

    public Integer getVipName() {
        return vipName;
    }

    public void setVipName(Integer vipName) {
        this.vipName = vipName;
    }

    public Integer getVipGrade() {
        return vipGrade;
    }

    public void setVipGrade(Integer vipGrade) {
        this.vipGrade = vipGrade;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [");
        sb.append("ClassName = ").append(getClass().getSimpleName());
        sb.append(", id=").append(id);
        sb.append(", startCount=").append(startCount);
        sb.append(", endCount=").append(endCount);
        sb.append(", vipName=").append(vipName);
        sb.append(", vipGrade=").append(vipGrade);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", enabled=").append(enabled);
        sb.append("]");
        return sb.toString();
    }
}