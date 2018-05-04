package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;
import java.util.Date;

public class Authorities implements Serializable {
    /**
     * 
     */
    private Integer id;

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
     * 权限类型： 1:菜单权限 2:页面权限 3: 操作权限
     */
    private Integer type;

    /**
     * 是否启用：1启用 2禁用
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
     * authorities
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthoritiesName() {
        return authoritiesName;
    }

    public void setAuthoritiesName(String authoritiesName) {
        this.authoritiesName = authoritiesName == null ? null : authoritiesName.trim();
    }

    public String getMenuNotes() {
        return menuNotes;
    }

    public void setMenuNotes(String menuNotes) {
        this.menuNotes = menuNotes == null ? null : menuNotes.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath == null ? null : menuPath.trim();
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName == null ? null : iconName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        sb.append(", authoritiesName=").append(authoritiesName);
        sb.append(", menuNotes=").append(menuNotes);
        sb.append(", parentId=").append(parentId);
        sb.append(", menuPath=").append(menuPath);
        sb.append(", menuLevel=").append(menuLevel);
        sb.append(", menuSort=").append(menuSort);
        sb.append(", iconName=").append(iconName);
        sb.append(", type=").append(type);
        sb.append(", enabled=").append(enabled);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}