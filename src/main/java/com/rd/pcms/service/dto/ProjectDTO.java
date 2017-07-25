package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Project entity.
 */
public class ProjectDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(value = 0)
    @Max(value = 19)
    private Long projCompId;

    @NotNull
    @Size(min = 0, max = 128)
    private String projCompName;

    @NotNull
    @Size(min = 0, max = 20)
    private String code;

    @Size(min = 0, max = 80)
    private String name;

    @Size(min = 0, max = 32)
    private String enName;

    @Size(min = 0, max = 100)
    private String supervisor;

    @Size(min = 0, max = 100)
    private String ownerContractor;

    @Size(min = 0, max = 100)
    private String totalContractor;

    private Instant startDate;

    private Instant endDate;

    @Min(value = 0)
    @Max(value = 10)
    private Integer status;

    @Min(value = 0)
    @Max(value = 10)
    private Integer delFlag;

    @Size(min = 0, max = 500)
    private String remark;

    @Size(min = 0, max = 50)
    private String extendAttr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjCompId() {
        return projCompId;
    }

    public void setProjCompId(Long projCompId) {
        this.projCompId = projCompId;
    }

    public String getProjCompName() {
        return projCompName;
    }

    public void setProjCompName(String projCompName) {
        this.projCompName = projCompName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getOwnerContractor() {
        return ownerContractor;
    }

    public void setOwnerContractor(String ownerContractor) {
        this.ownerContractor = ownerContractor;
    }

    public String getTotalContractor() {
        return totalContractor;
    }

    public void setTotalContractor(String totalContractor) {
        this.totalContractor = totalContractor;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExtendAttr() {
        return extendAttr;
    }

    public void setExtendAttr(String extendAttr) {
        this.extendAttr = extendAttr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProjectDTO projectDTO = (ProjectDTO) o;
        if(projectDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
            "id=" + getId() +
            ", projCompId='" + getProjCompId() + "'" +
            ", projCompName='" + getProjCompName() + "'" +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", enName='" + getEnName() + "'" +
            ", supervisor='" + getSupervisor() + "'" +
            ", ownerContractor='" + getOwnerContractor() + "'" +
            ", totalContractor='" + getTotalContractor() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", status='" + getStatus() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", remark='" + getRemark() + "'" +
            ", extendAttr='" + getExtendAttr() + "'" +
            "}";
    }
}
