package com.rd.pcms.service.dto;


import com.rd.pcms.domain.Company;

import java.time.Instant;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Project entity.
 */
public class ProjectDTO implements Serializable {

    private Long id;

    @Min(value = 0)
    @Max(value = 19)
    private Long compId;

    @Size(min = 0, max = 128)
    private String compName;

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

    private Company company;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", compName='" + getCompName() + "'" +
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
