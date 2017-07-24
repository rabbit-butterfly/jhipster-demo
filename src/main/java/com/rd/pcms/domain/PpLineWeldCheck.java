package com.rd.pcms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * 焊接记录质量检查记录
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:pp_line_weld_check
 */
@ApiModel(description = "焊接记录质量检查记录 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:pp_line_weld_check")
@Entity
@Table(name = "pp_line_weld_check")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PpLineWeldCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * PROJ_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PROJ_ID", required = true)
    @Column(name = "proj_id", length = 19, nullable = false)
    private String projId;

    /**
     * PIPE_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PIPE_ID", required = true)
    @Column(name = "pipe_id", length = 19, nullable = false)
    private String pipeId;

    /**
     * JOINT_ID
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "JOINT_ID")
    @Column(name = "joint_id", length = 19)
    private String jointId;

    /**
     * @rt
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "@rt")
    @Column(name = "rtfilm_total")
    private Integer rtfilmTotal;

    /**
     * @rt
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "@rt")
    @Column(name = "rtfilm_pass_total")
    private Integer rtfilmPassTotal;

    /**
     * @rt
     */
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "@rt")
    @Column(name = "report_code", length = 16)
    private String reportCode;

    /**
     * @rt
     */
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "@rt")
    @Column(name = "check_date", length = 16)
    private String checkDate;

    /**
     * CHECK_RESULT
     */
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "CHECK_RESULT")
    @Column(name = "check_result", length = 16)
    private String checkResult;

    /**
     * REWORK_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "REWORK_CODE")
    @Column(name = "rework_code", length = 50)
    private String reworkCode;

    /**
     * REWORK_WELDER
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "REWORK_WELDER")
    @Column(name = "rework_welder", length = 50)
    private String reworkWelder;

    /**
     * REWORK_DATE
     */
    @ApiModelProperty(value = "REWORK_DATE")
    @Column(name = "rework_date")
    private Instant reworkDate;

    /**
     * REWORK_RESULT
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "REWORK_RESULT")
    @Column(name = "rework_result", length = 50)
    private String reworkResult;

    /**
     * REPAIR_REPORT
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "REPAIR_REPORT")
    @Column(name = "repair_report", length = 50)
    private String repairReport;

    /**
     * REMARK
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "REMARK")
    @Column(name = "remark", length = 500)
    private String remark;

    /**
     * CREATE_TIME
     */
    @NotNull
    @ApiModelProperty(value = "CREATE_TIME", required = true)
    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    /**
     * DEL_FLAG
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "DEL_FLAG")
    @Column(name = "del_flag")
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

    public PpLineWeldCheck projId(String projId) {
        this.projId = projId;
        return this;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getPipeId() {
        return pipeId;
    }

    public PpLineWeldCheck pipeId(String pipeId) {
        this.pipeId = pipeId;
        return this;
    }

    public void setPipeId(String pipeId) {
        this.pipeId = pipeId;
    }

    public String getJointId() {
        return jointId;
    }

    public PpLineWeldCheck jointId(String jointId) {
        this.jointId = jointId;
        return this;
    }

    public void setJointId(String jointId) {
        this.jointId = jointId;
    }

    public Integer getRtfilmTotal() {
        return rtfilmTotal;
    }

    public PpLineWeldCheck rtfilmTotal(Integer rtfilmTotal) {
        this.rtfilmTotal = rtfilmTotal;
        return this;
    }

    public void setRtfilmTotal(Integer rtfilmTotal) {
        this.rtfilmTotal = rtfilmTotal;
    }

    public Integer getRtfilmPassTotal() {
        return rtfilmPassTotal;
    }

    public PpLineWeldCheck rtfilmPassTotal(Integer rtfilmPassTotal) {
        this.rtfilmPassTotal = rtfilmPassTotal;
        return this;
    }

    public void setRtfilmPassTotal(Integer rtfilmPassTotal) {
        this.rtfilmPassTotal = rtfilmPassTotal;
    }

    public String getReportCode() {
        return reportCode;
    }

    public PpLineWeldCheck reportCode(String reportCode) {
        this.reportCode = reportCode;
        return this;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public PpLineWeldCheck checkDate(String checkDate) {
        this.checkDate = checkDate;
        return this;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public PpLineWeldCheck checkResult(String checkResult) {
        this.checkResult = checkResult;
        return this;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getReworkCode() {
        return reworkCode;
    }

    public PpLineWeldCheck reworkCode(String reworkCode) {
        this.reworkCode = reworkCode;
        return this;
    }

    public void setReworkCode(String reworkCode) {
        this.reworkCode = reworkCode;
    }

    public String getReworkWelder() {
        return reworkWelder;
    }

    public PpLineWeldCheck reworkWelder(String reworkWelder) {
        this.reworkWelder = reworkWelder;
        return this;
    }

    public void setReworkWelder(String reworkWelder) {
        this.reworkWelder = reworkWelder;
    }

    public Instant getReworkDate() {
        return reworkDate;
    }

    public PpLineWeldCheck reworkDate(Instant reworkDate) {
        this.reworkDate = reworkDate;
        return this;
    }

    public void setReworkDate(Instant reworkDate) {
        this.reworkDate = reworkDate;
    }

    public String getReworkResult() {
        return reworkResult;
    }

    public PpLineWeldCheck reworkResult(String reworkResult) {
        this.reworkResult = reworkResult;
        return this;
    }

    public void setReworkResult(String reworkResult) {
        this.reworkResult = reworkResult;
    }

    public String getRepairReport() {
        return repairReport;
    }

    public PpLineWeldCheck repairReport(String repairReport) {
        this.repairReport = repairReport;
        return this;
    }

    public void setRepairReport(String repairReport) {
        this.repairReport = repairReport;
    }

    public String getRemark() {
        return remark;
    }

    public PpLineWeldCheck remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PpLineWeldCheck createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PpLineWeldCheck delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
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
        PpLineWeldCheck ppLineWeldCheck = (PpLineWeldCheck) o;
        if (ppLineWeldCheck.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineWeldCheck.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineWeldCheck{" +
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
