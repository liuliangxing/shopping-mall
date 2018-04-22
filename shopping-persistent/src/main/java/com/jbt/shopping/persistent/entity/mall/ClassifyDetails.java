package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;
import java.util.Date;

public class ClassifyDetails implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 分类ID
     */
    private Integer classifyId;

    /**
     * 描述名称
     */
    private String detailsName;

    /**
     * 是否启用: 1启用 2: 禁用
     */
    private Integer enabled;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Date createTime;

    /**
     * classify_details
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getDetailsName() {
        return detailsName;
    }

    public void setDetailsName(String detailsName) {
        this.detailsName = detailsName == null ? null : detailsName.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [");
        sb.append("ClassName = ").append(getClass().getSimpleName());
        sb.append(", id=").append(id);
        sb.append(", classifyId=").append(classifyId);
        sb.append(", detailsName=").append(detailsName);
        sb.append(", enabled=").append(enabled);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}