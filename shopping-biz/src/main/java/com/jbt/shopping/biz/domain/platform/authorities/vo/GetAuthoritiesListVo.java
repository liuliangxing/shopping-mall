package com.jbt.shopping.biz.domain.platform.authorities.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class GetAuthoritiesListVo implements Serializable{
    /**
     *
     */
    private Integer id;

    /**
     * 显示label
     */
    private String label;

    /**
     * 权限名称
     */
    private String authoritiesName;

    /**
     * 菜单文本
     */
    private String menuNotes;

    /**
     * 父级菜单ID，顶级 为 -1
     */
    private Integer parentId;

    /**
     * 菜单路径
     */
    private String menuPath;

    /**
     * 菜单级别
     */
    private Integer menuLevel;

    /**
     * 菜单层级
     */
    private Integer menuSort;

    /**
     * 图片路径
     */
    private String iconName;

    /**
     * 权限类型： 1:菜单权限 2:操作权限
     */
    private Integer type;

    /**
     * 是否启用：1启用 2禁用
     */
    private Integer enabled;

    /**
     *
     */
    private Date createTime;
    /**
     * 子集合
     */
    private List<GetAuthoritiesListVo> children = new ArrayList<>();

    /**
     * 是否禁用（前台展示）
     */
    private boolean disabled;
}
