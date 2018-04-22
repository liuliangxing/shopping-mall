package com.jbt.shopping.persistent.entity.mall;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 序号
     */
    private Integer seq;

    /**
     * 活动标签
     */
    private String activityLabel;

    /**
     * 活动状态: 1.未开始 2.进行中 3.已结束
     */
    private Integer activityStatus;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Date createTime;

    /**
     * activity
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getActivityLabel() {
        return activityLabel;
    }

    public void setActivityLabel(String activityLabel) {
        this.activityLabel = activityLabel == null ? null : activityLabel.trim();
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        sb.append(", activityName=").append(activityName);
        sb.append(", seq=").append(seq);
        sb.append(", activityLabel=").append(activityLabel);
        sb.append(", activityStatus=").append(activityStatus);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}