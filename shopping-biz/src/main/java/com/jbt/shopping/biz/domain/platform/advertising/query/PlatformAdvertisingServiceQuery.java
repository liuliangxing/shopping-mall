package com.jbt.shopping.biz.domain.platform.advertising.query;

import com.jbt.shopping.biz.groups.platform.advertising.*;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

/**
 * 
 * ClassName:  PlatformAdvertisingServiceQuery<br/>
 * Description: PlatformAdvertisingServiceQuery Service <br/>
 * Date: 2018-03-01 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-01        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Data
public class PlatformAdvertisingServiceQuery implements Serializable {

    /**
     *
     */
    @NotNull(groups = {EnabledAdGroup.class, GetAdInfoGroup.class, EditAdInfoGroup.class})
    private Integer id;
    /**
     * 广告位名称
     */
    @NotEmpty(groups = {SaveAdInfoGroup.class})
    private String name;

    /**
     * 广告位类型: 1: 商品 2: 类目 3: 活动
     */
    @Range(min = 1, max = 3, groups = {SaveAdInfoGroup.class})
    private Integer type;

    /**
     * 广告位 位置(1: 首页 其他待定)
     */
    @NotNull(groups = {SaveAdInfoGroup.class, GetAdListGroup.class})
    private Integer position;

    /**
     * 是否启用 1:启用 2: 禁用
     */
    @NotNull(groups = {EnabledAdGroup.class})
    private Integer enabled;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 广告位图片地址
     */
    @NotEmpty(groups = {EnabledAdGroup.class})
    private String img;

    /**
     * 跳转值, 当type 为1那就是商品ID, 为2那就是类目ID,为3那就是活动的ID
     */
    @NotNull(groups = {EnabledAdGroup.class})
    private Integer value;

    /**
     * 排序后的Id Map集合
     */
    @NotNull(groups = {SortAdGroup.class})
    private Map<Integer, Integer> sortIds = new HashMap<>();

}
