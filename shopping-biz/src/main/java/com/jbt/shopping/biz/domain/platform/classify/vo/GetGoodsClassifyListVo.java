package com.jbt.shopping.biz.domain.platform.classify.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class GetGoodsClassifyListVo implements Serializable{
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
     * 类别图标
     */
    private String classifyPng;

    /**
     * 子类别
     */
    private List<GetGoodsClassifyListVo> childClassifyList = new ArrayList<>();
}
