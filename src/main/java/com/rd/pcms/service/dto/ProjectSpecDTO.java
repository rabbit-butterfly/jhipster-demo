package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ProjectSpec entity.
 */
public class ProjectSpecDTO implements Serializable {

    private Long id;

    @Size(min = 0, max = 19)
    private String projId;

    @Size(min = 0, max = 80)
    private String name;

    @Size(min = 0, max = 10)
    private String size;

    @Size(min = 0, max = 50)
    private String unit;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

        ProjectSpecDTO projectSpecDTO = (ProjectSpecDTO) o;
        if(projectSpecDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectSpecDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectSpecDTO{" +
            "id=" + getId() +
            ", projId='" + getProjId() + "'" +
            ", name='" + getName() + "'" +
            ", size='" + getSize() + "'" +
            ", unit='" + getUnit() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
