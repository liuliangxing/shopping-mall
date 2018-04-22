package com.jbt.shopping.biz.domain.platform.cart.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GetCartListVo implements Serializable{
    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品编号
     */
    private String goodsNum;

    /**
     * 缩略图
     */
    private String thumbnailPicture;

    /**
     * 商品分类价格
     */
    private BigDecimal price;

    /**
     * 活动价格
     */
    private BigDecimal activityPrice;

    /**
     * 活动标签
     */
    private String activityLabel;

}
