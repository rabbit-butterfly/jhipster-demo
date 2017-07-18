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
 * 抽检比例设置表
 * @auther:renntrabbit@foxmail.com
 * @date:Tue Jul 18 17:06:29 CST 2017
 * table:pp_inspection_ratio
 */
@ApiModel(description = "抽检比例设置表 @auther:renntrabbit@foxmail.com @date:Tue Jul 18 17:06:29 CST 2017 table:pp_inspection_ratio")
@Entity
@Table(name = "pp_inspection_ratio")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PpIinspectionTatio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    @Column(name = "comp_id", length = 19, nullable = false)
    private String compId;

    /**
     * COMP_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "COMP_ID", required = true)
    @Column(name = "proj_id", length = 19, nullable = false)
    private String projId;

    /**
     * PROJ_ID
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "PROJ_ID")
    @Column(name = "inspection_code", length = 50)
    private String inspectionCode;

    /**
     * I III IV
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "I III IV")
    @Column(name = "rt_rate", length = 19)
    private String rtRate;

    /**
     * RT_RATE
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "RT_RATE")
    @Column(name = "rt_rate_gd", length = 19)
    private String rtRateGd;

    /**
     * RT_RATE_GD
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "RT_RATE_GD")
    @Column(name = "rt_standard", length = 50)
    private String rtStandard;

    /**
     * RT_STANDARD
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "RT_STANDARD")
    @Column(name = "rt_grade", length = 50)
    private String rtGrade;

    /**
     * @ I III IV
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "@ I III IV")
    @Column(name = "pt_rate", length = 19)
    private String ptRate;

    /**
     * PT_RATE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "PT_RATE")
    @Column(name = "pt_standard", length = 50)
    private String ptStandard;

    /**
     * PT_STANDARD
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "PT_STANDARD")
    @Column(name = "pt_grade", length = 50)
    private String ptGrade;

    /**
     * PT_GRADE
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PT_GRADE")
    @Column(name = "ut_rate", length = 19)
    private String utRate;

    /**
     * UT_RATE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "UT_RATE")
    @Column(name = "ut_standard", length = 50)
    private String utStandard;

    /**
     * UT_STANDARD
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "UT_STANDARD")
    @Column(name = "ut_grade", length = 50)
    private String utGrade;

    /**
     * UT_GRADE
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "UT_GRADE")
    @Column(name = "mt_rate", length = 19)
    private String mtRate;

    /**
     * MT_RATE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "MT_RATE")
    @Column(name = "mt_standard", length = 50)
    private String mtStandard;

    /**
     * MT_STANDARD
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "MT_STANDARD")
    @Column(name = "mt_grade", length = 50)
    private String mtGrade;

    /**
     * MT_GRADE
     */
    @NotNull
    @ApiModelProperty(value = "MT_GRADE", required = true)
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

    public String getCompId() {
        return compId;
    }

    public PpIinspectionTatio compId(String compId) {
        this.compId = compId;
        return this;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getProjId() {
        return projId;
    }

    public PpIinspectionTatio projId(String projId) {
        this.projId = projId;
        return this;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getInspectionCode() {
        return inspectionCode;
    }

    public PpIinspectionTatio inspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode;
        return this;
    }

    public void setInspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode;
    }

    public String getRtRate() {
        return rtRate;
    }

    public PpIinspectionTatio rtRate(String rtRate) {
        this.rtRate = rtRate;
        return this;
    }

    public void setRtRate(String rtRate) {
        this.rtRate = rtRate;
    }

    public String getRtRateGd() {
        return rtRateGd;
    }

    public PpIinspectionTatio rtRateGd(String rtRateGd) {
        this.rtRateGd = rtRateGd;
        return this;
    }

    public void setRtRateGd(String rtRateGd) {
        this.rtRateGd = rtRateGd;
    }

    public String getRtStandard() {
        return rtStandard;
    }

    public PpIinspectionTatio rtStandard(String rtStandard) {
        this.rtStandard = rtStandard;
        return this;
    }

    public void setRtStandard(String rtStandard) {
        this.rtStandard = rtStandard;
    }

    public String getRtGrade() {
        return rtGrade;
    }

    public PpIinspectionTatio rtGrade(String rtGrade) {
        this.rtGrade = rtGrade;
        return this;
    }

    public void setRtGrade(String rtGrade) {
        this.rtGrade = rtGrade;
    }

    public String getPtRate() {
        return ptRate;
    }

    public PpIinspectionTatio ptRate(String ptRate) {
        this.ptRate = ptRate;
        return this;
    }

    public void setPtRate(String ptRate) {
        this.ptRate = ptRate;
    }

    public String getPtStandard() {
        return ptStandard;
    }

    public PpIinspectionTatio ptStandard(String ptStandard) {
        this.ptStandard = ptStandard;
        return this;
    }

    public void setPtStandard(String ptStandard) {
        this.ptStandard = ptStandard;
    }

    public String getPtGrade() {
        return ptGrade;
    }

    public PpIinspectionTatio ptGrade(String ptGrade) {
        this.ptGrade = ptGrade;
        return this;
    }

    public void setPtGrade(String ptGrade) {
        this.ptGrade = ptGrade;
    }

    public String getUtRate() {
        return utRate;
    }

    public PpIinspectionTatio utRate(String utRate) {
        this.utRate = utRate;
        return this;
    }

    public void setUtRate(String utRate) {
        this.utRate = utRate;
    }

    public String getUtStandard() {
        return utStandard;
    }

    public PpIinspectionTatio utStandard(String utStandard) {
        this.utStandard = utStandard;
        return this;
    }

    public void setUtStandard(String utStandard) {
        this.utStandard = utStandard;
    }

    public String getUtGrade() {
        return utGrade;
    }

    public PpIinspectionTatio utGrade(String utGrade) {
        this.utGrade = utGrade;
        return this;
    }

    public void setUtGrade(String utGrade) {
        this.utGrade = utGrade;
    }

    public String getMtRate() {
        return mtRate;
    }

    public PpIinspectionTatio mtRate(String mtRate) {
        this.mtRate = mtRate;
        return this;
    }

    public void setMtRate(String mtRate) {
        this.mtRate = mtRate;
    }

    public String getMtStandard() {
        return mtStandard;
    }

    public PpIinspectionTatio mtStandard(String mtStandard) {
        this.mtStandard = mtStandard;
        return this;
    }

    public void setMtStandard(String mtStandard) {
        this.mtStandard = mtStandard;
    }

    public String getMtGrade() {
        return mtGrade;
    }

    public PpIinspectionTatio mtGrade(String mtGrade) {
        this.mtGrade = mtGrade;
        return this;
    }

    public void setMtGrade(String mtGrade) {
        this.mtGrade = mtGrade;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PpIinspectionTatio createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PpIinspectionTatio delFlag(Integer delFlag) {
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
        PpIinspectionTatio ppIinspectionTatio = (PpIinspectionTatio) o;
        if (ppIinspectionTatio.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppIinspectionTatio.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpIinspectionTatio{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", projId='" + getProjId() + "'" +
            ", inspectionCode='" + getInspectionCode() + "'" +
            ", rtRate='" + getRtRate() + "'" +
            ", rtRateGd='" + getRtRateGd() + "'" +
            ", rtStandard='" + getRtStandard() + "'" +
            ", rtGrade='" + getRtGrade() + "'" +
            ", ptRate='" + getPtRate() + "'" +
            ", ptStandard='" + getPtStandard() + "'" +
            ", ptGrade='" + getPtGrade() + "'" +
            ", utRate='" + getUtRate() + "'" +
            ", utStandard='" + getUtStandard() + "'" +
            ", utGrade='" + getUtGrade() + "'" +
            ", mtRate='" + getMtRate() + "'" +
            ", mtStandard='" + getMtStandard() + "'" +
            ", mtGrade='" + getMtGrade() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
