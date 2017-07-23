package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ProjectMaterial entity.
 */
public class ProjectMaterialDTO implements Serializable {

    private Long id;

    @Size(min = 0, max = 19)
    private String projId;

    @Size(min = 0, max = 80)
    private String name;

    @Size(min = 0, max = 19)
    private String parentId;

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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

        ProjectMaterialDTO projectMaterialDTO = (ProjectMaterialDTO) o;
        if(projectMaterialDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectMaterialDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectMaterialDTO{" +
            "id=" + getId() +
            ", projId='" + getProjId() + "'" +
            ", name='" + getName() + "'" +
            ", parentId='" + getParentId() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
