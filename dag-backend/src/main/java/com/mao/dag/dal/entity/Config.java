package com.mao.dag.dal.entity;

import java.io.Serializable;

public class Config implements Serializable {
    private Long id;

    private Integer bizCode;

    private Integer configCode;

    private String processor;

    private String configInfo;

    private String parentCode;

    private String childCode;

    private String nodeLoc;

    private Integer valid;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBizCode() {
        return bizCode;
    }

    public void setBizCode(Integer bizCode) {
        this.bizCode = bizCode;
    }

    public Integer getConfigCode() {
        return configCode;
    }

    public void setConfigCode(Integer configCode) {
        this.configCode = configCode;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor == null ? null : processor.trim();
    }

    public String getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(String configInfo) {
        this.configInfo = configInfo == null ? null : configInfo.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getChildCode() {
        return childCode;
    }

    public void setChildCode(String childCode) {
        this.childCode = childCode == null ? null : childCode.trim();
    }

    public String getNodeLoc() {
        return nodeLoc;
    }

    public void setNodeLoc(String nodeLoc) {
        this.nodeLoc = nodeLoc == null ? null : nodeLoc.trim();
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
        sb.append(", bizCode=").append(bizCode);
        sb.append(", configCode=").append(configCode);
        sb.append(", processor=").append(processor);
        sb.append(", configInfo=").append(configInfo);
        sb.append(", parentCode=").append(parentCode);
        sb.append(", childCode=").append(childCode);
        sb.append(", nodeLoc=").append(nodeLoc);
        sb.append(", valid=").append(valid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}