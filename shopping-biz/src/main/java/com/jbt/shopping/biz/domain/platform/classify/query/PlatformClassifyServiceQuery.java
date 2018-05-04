package com.jbt.shopping.biz.domain.platform.classify.query;

import com.jbt.shopping.biz.groups.platform.classify.*;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * ClassName:  PlatformClassifyServiceQuery<br/>
 * Description: PlatformClassifyServiceQuery Service <br/>
 * Date: 2018-03-02 <br/>
 * <hr/>
 * Modification History: <br/>
 * DATE           AUTHOR          VERSION          DISCRIPTION 				 <br/>
 * ------------------------------------------------------------------------- <br/>
 * 2018-03-02        Destiny       1.0              INIT-CREATE<br/>
 *
 */
@Data
public class PlatformClassifyServiceQuery implements Serializable {
    /**
     *
     */
    @NotNull(groups = {EditGoodsClassifyGroup.class, DeleteGoodsClassifyGroup.class, GetChildListGroup.class})
    private Integer id;

    /**
     * 分类名称
     */
    @NotEmpty(groups = {SaveGoodsClassifyGroup.class})
    private String classifyName;

    /**
     * 序号
     */
    @NotNull(groups = {SaveGoodsClassifyGroup.class})
    private Integer seq;

    /**
     * 父ID: 0 为顶级
     */
    @NotNull(groups = {SaveGoodsClassifyGroup.class})
    private Integer pid;

    /**
     * 类别图标
     */
    private String classifyPng;

    /**
     * 排序Map
     */
    @NotNull(groups = {SortGoodsClassifyGroup.class})
    private Map<Integer, Integer> sortMap = new HashMap<>();


}
