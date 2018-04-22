package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;
import java.util.Date;

public class GoodsClassify implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String classifyName;

    /**
     * 序号
     */
    private Integer seq;

    /**
     * 父ID: 0 为顶级
     */
    private Integer pid;

    /**
     * 类别图标
     */
    private String classifyPng;

    /**
     * 是否启用： 1、启用 2、禁用
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
     * goods_classify
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getClassifyPng() {
        return classifyPng;
    }

    public void setClassifyPng(String classifyPng) {
        this.classifyPng = classifyPng == null ? null : classifyPng.trim();
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
        sb.append(", classifyName=").append(classifyName);
        sb.append(", seq=").append(seq);
        sb.append(", pid=").append(pid);
        sb.append(", classifyPng=").append(classifyPng);
        sb.append(", enabled=").append(enabled);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}