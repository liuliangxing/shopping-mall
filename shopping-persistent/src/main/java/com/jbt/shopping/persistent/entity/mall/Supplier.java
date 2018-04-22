package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;
import java.util.Date;

public class Supplier implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 供货商名称
     */
    private String supplierName;

    /**
     * 供货商联系人
     */
    private String supplierContacts;

    /**
     * 供货商备用联系人
     */
    private String supplierSpare;

    /**
     * 是否启用: 1:启用 2: 禁用
     */
    private Integer enabled;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * supplier
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getSupplierContacts() {
        return supplierContacts;
    }

    public void setSupplierContacts(String supplierContacts) {
        this.supplierContacts = supplierContacts == null ? null : supplierContacts.trim();
    }

    public String getSupplierSpare() {
        return supplierSpare;
    }

    public void setSupplierSpare(String supplierSpare) {
        this.supplierSpare = supplierSpare == null ? null : supplierSpare.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [");
        sb.append("ClassName = ").append(getClass().getSimpleName());
        sb.append(", id=").append(id);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", supplierContacts=").append(supplierContacts);
        sb.append(", supplierSpare=").append(supplierSpare);
        sb.append(", enabled=").append(enabled);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}