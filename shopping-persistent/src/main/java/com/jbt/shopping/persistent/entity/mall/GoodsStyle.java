package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GoodsStyle implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 商品分类名
     */
    private String style;

    /**
     * 商品分类价格
     */
    private BigDecimal price;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 缩略图
     */
    private String thumbnailPicture;

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
     * goods_style
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getThumbnailPicture() {
        return thumbnailPicture;
    }

    public void setThumbnailPicture(String thumbnailPicture) {
        this.thumbnailPicture = thumbnailPicture == null ? null : thumbnailPicture.trim();
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
        sb.append(", style=").append(style);
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", thumbnailPicture=").append(thumbnailPicture);
        sb.append(", enabled=").append(enabled);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}