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
 * 项目分包商基本信息表
 * @auther:renntrabbit@foxmail.com
 * @date:Tue Jul 18 17:06:29 CST 2017
 * table:project_sub_constractor
 */
@ApiModel(description = "项目分包商基本信息表 @auther:renntrabbit@foxmail.com @date:Tue Jul 18 17:06:29 CST 2017 table:project_sub_constractor")
@Entity
@Table(name = "project_sub_constractor")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProjectSubConstractor implements Serializable {

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
    @Size(min = 0, max = 80)
    @ApiModelProperty(value = "PROJ_ID", required = true)
    @Column(name = "name", length = 80, nullable = false)
    private String name;

    /**
     * NAME
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "NAME")
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

    public ProjectSubConstractor projId(String projId) {
        this.projId = projId;
        return this;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getName() {
        return name;
    }

    public ProjectSubConstractor name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public ProjectSubConstractor remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public ProjectSubConstractor createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public ProjectSubConstractor delFlag(Integer delFlag) {
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
        ProjectSubConstractor projectSubConstractor = (ProjectSubConstractor) o;
        if (projectSubConstractor.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectSubConstractor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectSubConstractor{" +
            "id=" + getId() +
            ", projId='" + getProjId() + "'" +
            ", name='" + getName() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
