package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ActivityGoods implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 活动ID
     */
    private Integer activityId;

    /**
     * 活动类型: 1. 折扣 2.降价 3.无优惠
     */
    private Integer type;

    /**
     * 活动值: type为1时 折扣值 type为2时降价值 type 为3时 0.00
     */
    private BigDecimal discount;

    /**
     * 是否有赠品: 1.有 2. 无
     */
    private Integer giftable;

    /**
     * 赠品内容
     */
    private String giftValue;

    /**
     * 序号: 1为首推图片
     */
    private Integer seq;

    /**
     * 是否启用: 1.启用 2.禁用
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
     * activity_goods
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getGiftable() {
        return giftable;
    }

    public void setGiftable(Integer giftable) {
        this.giftable = giftable;
    }

    public String getGiftValue() {
        return giftValue;
    }

    public void setGiftValue(String giftValue) {
        this.giftValue = giftValue == null ? null : giftValue.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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
        sb.append(", goodsId=").append(goodsId);
        sb.append(", activityId=").append(activityId);
        sb.append(", type=").append(type);
        sb.append(", discount=").append(discount);
        sb.append(", giftable=").append(giftable);
        sb.append(", giftValue=").append(giftValue);
        sb.append(", seq=").append(seq);
        sb.append(", enabled=").append(enabled);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}