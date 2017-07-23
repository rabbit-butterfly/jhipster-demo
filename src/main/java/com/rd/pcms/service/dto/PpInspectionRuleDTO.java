package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PpInspectionRule entity.
 */
public class PpInspectionRuleDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String compId;

    @NotNull
    @Size(min = 0, max = 19)
    private String projId;

    @Size(min = 0, max = 50)
    private String material;

    @Size(min = 0, max = 50)
    private String ppClass;

    @Size(min = 0, max = 50)
    private String jacketedPipe;

    @Size(min = 0, max = 50)
    private String inspectionCode;

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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPpClass() {
        return ppClass;
    }

    public void setPpClass(String ppClass) {
        this.ppClass = ppClass;
    }

    public String getJacketedPipe() {
        return jacketedPipe;
    }

    public void setJacketedPipe(String jacketedPipe) {
        this.jacketedPipe = jacketedPipe;
    }

    public String getInspectionCode() {
        return inspectionCode;
    }

    public void setInspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode;
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

        PpInspectionRuleDTO ppInspectionRuleDTO = (PpInspectionRuleDTO) o;
        if(ppInspectionRuleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppInspectionRuleDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpInspectionRuleDTO{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", projId='" + getProjId() + "'" +
            ", material='" + getMaterial() + "'" +
            ", ppClass='" + getPpClass() + "'" +
            ", jacketedPipe='" + getJacketedPipe() + "'" +
            ", inspectionCode='" + getInspectionCode() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
