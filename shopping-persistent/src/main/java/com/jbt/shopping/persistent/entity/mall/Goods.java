package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Goods implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品编号
     */
    private String goodsNum;

    /**
     * 最大价格
     */
    private BigDecimal maxPrice;

    /**
     * 最小价格
     */
    private BigDecimal minPrice;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 是否上架: 1: 上架 2: 下架
     */
    private Integer grounding;

    /**
     * 是否免邮: 1 免邮 2:不免邮 
     */
    private Integer freePostage;

    /**
     * 邮费
     */
    private BigDecimal postage;

    /**
     * 供货商ID
     */
    private Integer supplierId;

    /**
     * 缩略图
     */
    private String thumbnailPicture;

    /**
     * 主图
     */
    private String masterMap;

    /**
     * 分类ID
     */
    private Integer classifyId;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Date createTime;

    /**
     * goods
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum == null ? null : goodsNum.trim();
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getGrounding() {
        return grounding;
    }

    public void setGrounding(Integer grounding) {
        this.grounding = grounding;
    }

    public Integer getFreePostage() {
        return freePostage;
    }

    public void setFreePostage(Integer freePostage) {
        this.freePostage = freePostage;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getThumbnailPicture() {
        return thumbnailPicture;
    }

    public void setThumbnailPicture(String thumbnailPicture) {
        this.thumbnailPicture = thumbnailPicture == null ? null : thumbnailPicture.trim();
    }

    public String getMasterMap() {
        return masterMap;
    }

    public void setMasterMap(String masterMap) {
        this.masterMap = masterMap == null ? null : masterMap.trim();
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
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
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", maxPrice=").append(maxPrice);
        sb.append(", minPrice=").append(minPrice);
        sb.append(", goodsCount=").append(goodsCount);
        sb.append(", grounding=").append(grounding);
        sb.append(", freePostage=").append(freePostage);
        sb.append(", postage=").append(postage);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", thumbnailPicture=").append(thumbnailPicture);
        sb.append(", masterMap=").append(masterMap);
        sb.append(", classifyId=").append(classifyId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}