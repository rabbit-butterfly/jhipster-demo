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
 * 管线-焊接委托记录表
 * @auther:renntrabbit@foxmail.com
 * @date:Tue Jul 18 17:06:29 CST 2017
 * table:pp_line_weld_entrust
 */
@ApiModel(description = "管线-焊接委托记录表 @auther:renntrabbit@foxmail.com @date:Tue Jul 18 17:06:29 CST 2017 table:pp_line_weld_entrust")
@Entity
@Table(name = "pp_line_weld_entrust")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PpLineWeldEntrust implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    @Column(name = "proj_id", length = 19, nullable = false)
    private String projId;

    /**
     * PROJ_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PROJ_ID", required = true)
    @Column(name = "pipeline_id", length = 19, nullable = false)
    private String pipelineId;

    /**
     * PIPELINE_ID
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PIPELINE_ID")
    @Column(name = "weld_id", length = 19)
    private String weldId;

    /**
     * WELD_ID
     */
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "WELD_ID")
    @Column(name = "flow_num", length = 20)
    private String flowNum;

    /**
     * FLOW_NUM
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "FLOW_NUM")
    @Column(name = "code", length = 50)
    private String code;

    /**
     * @分项号-委托类型-流水号
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "@分项号-委托类型-流水号")
    @Column(name = "expand_count")
    private Integer expandCount;

    /**
     * EXPAND_COUNT
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "EXPAND_COUNT")
    @Column(name = "repare_count")
    private Integer repareCount;

    /**
     * REPARE_COUNT
     */
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "REPARE_COUNT")
    @Column(name = "entrust_type", length = 10)
    private String entrustType;

    /**
     * @RT PT UT MT PMI
     */
    @ApiModelProperty(value = "@RT PT UT MT PMI")
    @Column(name = "entrust_date")
    private Instant entrustDate;

    /**
     * ENTRUST_DATE
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "ENTRUST_DATE")
    @Column(name = "remark", length = 500)
    private String remark;

    /**
     * REMARK
     */
    @NotNull
    @ApiModelProperty(value = "REMARK", required = true)
    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    /**
     * CREATE_TIME
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "CREATE_TIME")
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

    public PpLineWeldEntrust projId(String projId) {
        this.projId = projId;
        return this;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getPipelineId() {
        return pipelineId;
    }

    public PpLineWeldEntrust pipelineId(String pipelineId) {
        this.pipelineId = pipelineId;
        return this;
    }

    public void setPipelineId(String pipelineId) {
        this.pipelineId = pipelineId;
    }

    public String getWeldId() {
        return weldId;
    }

    public PpLineWeldEntrust weldId(String weldId) {
        this.weldId = weldId;
        return this;
    }

    public void setWeldId(String weldId) {
        this.weldId = weldId;
    }

    public String getFlowNum() {
        return flowNum;
    }

    public PpLineWeldEntrust flowNum(String flowNum) {
        this.flowNum = flowNum;
        return this;
    }

    public void setFlowNum(String flowNum) {
        this.flowNum = flowNum;
    }

    public String getCode() {
        return code;
    }

    public PpLineWeldEntrust code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getExpandCount() {
        return expandCount;
    }

    public PpLineWeldEntrust expandCount(Integer expandCount) {
        this.expandCount = expandCount;
        return this;
    }

    public void setExpandCount(Integer expandCount) {
        this.expandCount = expandCount;
    }

    public Integer getRepareCount() {
        return repareCount;
    }

    public PpLineWeldEntrust repareCount(Integer repareCount) {
        this.repareCount = repareCount;
        return this;
    }

    public void setRepareCount(Integer repareCount) {
        this.repareCount = repareCount;
    }

    public String getEntrustType() {
        return entrustType;
    }

    public PpLineWeldEntrust entrustType(String entrustType) {
        this.entrustType = entrustType;
        return this;
    }

    public void setEntrustType(String entrustType) {
        this.entrustType = entrustType;
    }

    public Instant getEntrustDate() {
        return entrustDate;
    }

    public PpLineWeldEntrust entrustDate(Instant entrustDate) {
        this.entrustDate = entrustDate;
        return this;
    }

    public void setEntrustDate(Instant entrustDate) {
        this.entrustDate = entrustDate;
    }

    public String getRemark() {
        return remark;
    }

    public PpLineWeldEntrust remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PpLineWeldEntrust createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PpLineWeldEntrust delFlag(Integer delFlag) {
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
        PpLineWeldEntrust ppLineWeldEntrust = (PpLineWeldEntrust) o;
        if (ppLineWeldEntrust.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineWeldEntrust.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineWeldEntrust{" +
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
