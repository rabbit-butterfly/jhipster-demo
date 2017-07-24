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
 * 项目物资类别表
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:project_material
 */
@ApiModel(description = "项目物资类别表 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:project_material")
@Entity
@Table(name = "project_material")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProjectMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * PROJ_ID
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PROJ_ID")
    @Column(name = "proj_id", length = 19)
    private String projId;

    /**
     * NAME
     */
    @Size(min = 0, max = 80)
    @ApiModelProperty(value = "NAME")
    @Column(name = "name", length = 80)
    private String name;

    /**
     * PARENT_ID
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PARENT_ID")
    @Column(name = "parent_id", length = 19)
    private String parentId;

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

    public ProjectMaterial projId(String projId) {
        this.projId = projId;
        return this;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getName() {
        return name;
    }

    public ProjectMaterial name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public ProjectMaterial parentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public ProjectMaterial remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public ProjectMaterial createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public ProjectMaterial delFlag(Integer delFlag) {
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
        ProjectMaterial projectMaterial = (ProjectMaterial) o;
        if (projectMaterial.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectMaterial.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectMaterial{" +
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
