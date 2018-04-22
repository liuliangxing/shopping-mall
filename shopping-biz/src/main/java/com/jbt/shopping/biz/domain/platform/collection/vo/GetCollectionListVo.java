package com.jbt.shopping.biz.domain.platform.collection.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GetCollectionListVo implements Serializable{
    /**
     * 收藏Id
     */
    private Integer id;
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
     * 最大价格
     */
    private BigDecimal maxPrice;

    /**
     * 最小价格
     */
    private BigDecimal minPrice;

    /**
     * 缩略图
     */
    private String thumbnailPicture;

}
