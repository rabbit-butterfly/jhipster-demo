package com.rd.pcms.service.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the Project entity.
 */
public class ProjectDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 20)
    private String code;

    @Size(min = 0, max = 80)
    private String name;

    @Size(min = 0, max = 30)
    private String enName;

    @Size(min = 0, max = 100)
    private String supervisor;

    @Size(min = 0, max = 100)
    private String oContractor;

    @Size(min = 0, max = 100)
    private String hContractor;

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

    public String getoContractor() {
        return oContractor;
    }

    public void setoContractor(String oContractor) {
        this.oContractor = oContractor;
    }

    public String gethContractor() {
        return hContractor;
    }

    public void sethContractor(String hContractor) {
        this.hContractor = hContractor;
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
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", enName='" + getEnName() + "'" +
            ", supervisor='" + getSupervisor() + "'" +
            ", oContractor='" + getoContractor() + "'" +
            ", hContractor='" + gethContractor() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", status='" + getStatus() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", remark='" + getRemark() + "'" +
            ", extendAttr='" + getExtendAttr() + "'" +
            "}";
    }
}
