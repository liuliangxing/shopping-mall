package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;
import java.util.Date;

public class AdvertisingPosition implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 广告位名称
     */
    private String name;

    /**
     * 广告位类型: 1: 商品 2: 类目 3: 活动
     */
    private Integer type;

    /**
     * 跳转值, 当type 为1那就是商品ID, 为2那就是类目ID,为3那就是活动的ID
     */
    private Integer value;

    /**
     * 顺序
     */
    private Integer sort;

    /**
     * 广告位图片
     */
    private String img;

    /**
     * 广告位 位置(1: 首页 其他待定)
     */
    private Integer position;

    /**
     * 是否启用 1:启用 2: 禁用
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
     * Advertising_position
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", value=").append(value);
        sb.append(", sort=").append(sort);
        sb.append(", img=").append(img);
        sb.append(", position=").append(position);
        sb.append(", enabled=").append(enabled);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}