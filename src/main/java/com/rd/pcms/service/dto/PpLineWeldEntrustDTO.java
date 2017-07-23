package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PpLineWeldEntrust entity.
 */
public class PpLineWeldEntrustDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String projId;

    @NotNull
    @Size(min = 0, max = 19)
    private String pipelineId;

    @Size(min = 0, max = 19)
    private String weldId;

    @Size(min = 0, max = 20)
    private String flowNum;

    @Size(min = 0, max = 50)
    private String code;

    @Min(value = 0)
    @Max(value = 10)
    private Integer expandCount;

    @Min(value = 0)
    @Max(value = 10)
    private Integer repareCount;

    @Size(min = 0, max = 10)
    private String entrustType;

    private Instant entrustDate;

    @Size(min = 0, max = 500)
    private String remark;

    @NotNull
    private Instant createTime;

    @Min(value = 0)
    @Max(value = 10)
    private Integer delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(String pipelineId) {
        this.pipelineId = pipelineId;
    }

    public String getWeldId() {
        return weldId;
    }

    public void setWeldId(String weldId) {
        this.weldId = weldId;
    }

    public String getFlowNum() {
        return flowNum;
    }

    public void setFlowNum(String flowNum) {
        this.flowNum = flowNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getExpandCount() {
        return expandCount;
    }

    public void setExpandCount(Integer expandCount) {
        this.expandCount = expandCount;
    }

    public Integer getRepareCount() {
        return repareCount;
    }

    public void setRepareCount(Integer repareCount) {
        this.repareCount = repareCount;
    }

    public String getEntrustType() {
        return entrustType;
    }

    public void setEntrustType(String entrustType) {
        this.entrustType = entrustType;
    }

    public Instant getEntrustDate() {
        return entrustDate;
    }

    public void setEntrustDate(Instant entrustDate) {
        this.entrustDate = entrustDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PpLineWeldEntrustDTO ppLineWeldEntrustDTO = (PpLineWeldEntrustDTO) o;
        if(ppLineWeldEntrustDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineWeldEntrustDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineWeldEntrustDTO{" +
            "id=" + getId() +
            ", projId='" + getProjId() + "'" +
            ", pipelineId='" + getPipelineId() + "'" +
            ", weldId='" + getWeldId() + "'" +
            ", flowNum='" + getFlowNum() + "'" +
            ", code='" + getCode() + "'" +
            ", expandCount='" + getExpandCount() + "'" +
            ", repareCount='" + getRepareCount() + "'" +
            ", entrustType='" + getEntrustType() + "'" +
            ", entrustDate='" + getEntrustDate() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
