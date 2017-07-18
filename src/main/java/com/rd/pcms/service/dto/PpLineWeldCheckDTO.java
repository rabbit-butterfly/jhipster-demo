package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PpLineWeldCheck entity.
 */
public class PpLineWeldCheckDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String projId;

    @NotNull
    @Size(min = 0, max = 19)
    private String pipeId;

    @Size(min = 0, max = 19)
    private String jointId;

    @Min(value = 0)
    @Max(value = 10)
    private Integer rtfilmTotal;

    @Min(value = 0)
    @Max(value = 10)
    private Integer rtfilmPassTotal;

    @Size(min = 0, max = 16)
    private String reportCode;

    @Size(min = 0, max = 16)
    private String checkDate;

    @Size(min = 0, max = 16)
    private String checkResult;

    @Size(min = 0, max = 50)
    private String reworkCode;

    @Size(min = 0, max = 50)
    private String reworkWelder;

    private Instant reworkDate;

    @Size(min = 0, max = 50)
    private String reworkResult;

    @Size(min = 0, max = 50)
    private String repairReport;

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

    public String getPipeId() {
        return pipeId;
    }

    public void setPipeId(String pipeId) {
        this.pipeId = pipeId;
    }

    public String getJointId() {
        return jointId;
    }

    public void setJointId(String jointId) {
        this.jointId = jointId;
    }

    public Integer getRtfilmTotal() {
        return rtfilmTotal;
    }

    public void setRtfilmTotal(Integer rtfilmTotal) {
        this.rtfilmTotal = rtfilmTotal;
    }

    public Integer getRtfilmPassTotal() {
        return rtfilmPassTotal;
    }

    public void setRtfilmPassTotal(Integer rtfilmPassTotal) {
        this.rtfilmPassTotal = rtfilmPassTotal;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getReworkCode() {
        return reworkCode;
    }

    public void setReworkCode(String reworkCode) {
        this.reworkCode = reworkCode;
    }

    public String getReworkWelder() {
        return reworkWelder;
    }

    public void setReworkWelder(String reworkWelder) {
        this.reworkWelder = reworkWelder;
    }

    public Instant getReworkDate() {
        return reworkDate;
    }

    public void setReworkDate(Instant reworkDate) {
        this.reworkDate = reworkDate;
    }

    public String getReworkResult() {
        return reworkResult;
    }

    public void setReworkResult(String reworkResult) {
        this.reworkResult = reworkResult;
    }

    public String getRepairReport() {
        return repairReport;
    }

    public void setRepairReport(String repairReport) {
        this.repairReport = repairReport;
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

        PpLineWeldCheckDTO ppLineWeldCheckDTO = (PpLineWeldCheckDTO) o;
        if(ppLineWeldCheckDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineWeldCheckDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineWeldCheckDTO{" +
            "id=" + getId() +
            ", projId='" + getProjId() + "'" +
            ", pipeId='" + getPipeId() + "'" +
            ", jointId='" + getJointId() + "'" +
            ", rtfilmTotal='" + getRtfilmTotal() + "'" +
            ", rtfilmPassTotal='" + getRtfilmPassTotal() + "'" +
            ", reportCode='" + getReportCode() + "'" +
            ", checkDate='" + getCheckDate() + "'" +
            ", checkResult='" + getCheckResult() + "'" +
            ", reworkCode='" + getReworkCode() + "'" +
            ", reworkWelder='" + getReworkWelder() + "'" +
            ", reworkDate='" + getReworkDate() + "'" +
            ", reworkResult='" + getReworkResult() + "'" +
            ", repairReport='" + getRepairReport() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
