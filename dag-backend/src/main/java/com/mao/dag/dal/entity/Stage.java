package com.mao.dag.dal.entity;

import java.io.Serializable;

public class Stage implements Serializable {
    private Long id;

    private Long jobId;

    private String bizCode;

    private Integer configCode;

    private String stageNo;

    private Long planTime;

    private Integer pause;

    private Integer valid;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode == null ? null : bizCode.trim();
    }

    public Integer getConfigCode() {
        return configCode;
    }

    public void setConfigCode(Integer configCode) {
        this.configCode = configCode;
    }

    public String getStageNo() {
        return stageNo;
    }

    public void setStageNo(String stageNo) {
        this.stageNo = stageNo == null ? null : stageNo.trim();
    }

    public Long getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Long planTime) {
        this.planTime = planTime;
    }

    public Integer getPause() {
        return pause;
    }

    public void setPause(Integer pause) {
        this.pause = pause;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobId=").append(jobId);
        sb.append(", bizCode=").append(bizCode);
        sb.append(", configCode=").append(configCode);
        sb.append(", stageNo=").append(stageNo);
        sb.append(", planTime=").append(planTime);
        sb.append(", pause=").append(pause);
        sb.append(", valid=").append(valid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}