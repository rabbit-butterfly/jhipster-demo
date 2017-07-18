package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PpIinspectionTatio entity.
 */
public class PpIinspectionTatioDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String compId;

    @NotNull
    @Size(min = 0, max = 19)
    private String projId;

    @Size(min = 0, max = 50)
    private String inspectionCode;

    @Size(min = 0, max = 19)
    private String rtRate;

    @Size(min = 0, max = 19)
    private String rtRateGd;

    @Size(min = 0, max = 50)
    private String rtStandard;

    @Size(min = 0, max = 50)
    private String rtGrade;

    @Size(min = 0, max = 19)
    private String ptRate;

    @Size(min = 0, max = 50)
    private String ptStandard;

    @Size(min = 0, max = 50)
    private String ptGrade;

    @Size(min = 0, max = 19)
    private String utRate;

    @Size(min = 0, max = 50)
    private String utStandard;

    @Size(min = 0, max = 50)
    private String utGrade;

    @Size(min = 0, max = 19)
    private String mtRate;

    @Size(min = 0, max = 50)
    private String mtStandard;

    @Size(min = 0, max = 50)
    private String mtGrade;

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

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getInspectionCode() {
        return inspectionCode;
    }

    public void setInspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode;
    }

    public String getRtRate() {
        return rtRate;
    }

    public void setRtRate(String rtRate) {
        this.rtRate = rtRate;
    }

    public String getRtRateGd() {
        return rtRateGd;
    }

    public void setRtRateGd(String rtRateGd) {
        this.rtRateGd = rtRateGd;
    }

    public String getRtStandard() {
        return rtStandard;
    }

    public void setRtStandard(String rtStandard) {
        this.rtStandard = rtStandard;
    }

    public String getRtGrade() {
        return rtGrade;
    }

    public void setRtGrade(String rtGrade) {
        this.rtGrade = rtGrade;
    }

    public String getPtRate() {
        return ptRate;
    }

    public void setPtRate(String ptRate) {
        this.ptRate = ptRate;
    }

    public String getPtStandard() {
        return ptStandard;
    }

    public void setPtStandard(String ptStandard) {
        this.ptStandard = ptStandard;
    }

    public String getPtGrade() {
        return ptGrade;
    }

    public void setPtGrade(String ptGrade) {
        this.ptGrade = ptGrade;
    }

    public String getUtRate() {
        return utRate;
    }

    public void setUtRate(String utRate) {
        this.utRate = utRate;
    }

    public String getUtStandard() {
        return utStandard;
    }

    public void setUtStandard(String utStandard) {
        this.utStandard = utStandard;
    }

    public String getUtGrade() {
        return utGrade;
    }

    public void setUtGrade(String utGrade) {
        this.utGrade = utGrade;
    }

    public String getMtRate() {
        return mtRate;
    }

    public void setMtRate(String mtRate) {
        this.mtRate = mtRate;
    }

    public String getMtStandard() {
        return mtStandard;
    }

    public void setMtStandard(String mtStandard) {
        this.mtStandard = mtStandard;
    }

    public String getMtGrade() {
        return mtGrade;
    }

    public void setMtGrade(String mtGrade) {
        this.mtGrade = mtGrade;
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

        PpIinspectionTatioDTO ppIinspectionTatioDTO = (PpIinspectionTatioDTO) o;
        if(ppIinspectionTatioDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppIinspectionTatioDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpIinspectionTatioDTO{" +
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
