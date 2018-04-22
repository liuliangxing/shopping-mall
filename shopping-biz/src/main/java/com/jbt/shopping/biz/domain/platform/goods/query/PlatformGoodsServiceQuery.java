package com.jbt.shopping.biz.domain.platform.goods.query;

import com.jbt.shopping.persistent.entity.mall.GoodsClassify;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * ClassName:  PlatformGoodsServiceQuery<br/>
 * Description: PlatformGoodsServiceQuery Service <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Data
public class PlatformGoodsServiceQuery implements Serializable {

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
     * 最小商品数量
     */
    private Integer minCount;

    /**
     * 最大商品数据
     */
    private Integer maxCount;

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
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 当前节点及子节点
     */
    private List<GoodsClassify> goodsClassifyList = new ArrayList<>();

}
