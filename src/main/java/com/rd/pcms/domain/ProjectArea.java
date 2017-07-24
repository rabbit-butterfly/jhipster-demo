package com.rd.pcms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 分包项目：项目的子表
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:project_area
 */
@ApiModel(description = "分包项目：项目的子表 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:project_area")
@Entity
@Table(name = "project_area")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProjectArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * COMP_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "COMP_ID", required = true)
    @Column(name = "comp_id", length = 19, nullable = false)
    private String compId;

    /**
     * PROJ_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PROJ_ID", required = true)
    @Column(name = "proj_id", length = 19, nullable = false)
    private String projId;

    /**
     * NAME
     */
    @Size(min = 0, max = 80)
    @ApiModelProperty(value = "NAME")
    @Column(name = "name", length = 80)
    private String name;

    /**
     * EN_NAME
     */
    @Size(min = 0, max = 100)
    @ApiModelProperty(value = "EN_NAME")
    @Column(name = "en_name", length = 100)
    private String enName;

    /**
     * UNIT_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "UNIT_CODE")
    @Column(name = "unit_code", length = 50)
    private String unitCode;

    /**
     * SUB_CONSTRACTOR
     */
    @Size(min = 0, max = 80)
    @ApiModelProperty(value = "SUB_CONSTRACTOR")
    @Column(name = "sub_constractor", length = 80)
    private String subConstractor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompId() {
        return compId;
    }

    public ProjectArea compId(String compId) {
        this.compId = compId;
        return this;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getProjId() {
        return projId;
    }

    public ProjectArea projId(String projId) {
        this.projId = projId;
        return this;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getName() {
        return name;
    }

    public ProjectArea name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public ProjectArea enName(String enName) {
        this.enName = enName;
        return this;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public ProjectArea unitCode(String unitCode) {
        this.unitCode = unitCode;
        return this;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getSubConstractor() {
        return subConstractor;
    }

    public ProjectArea subConstractor(String subConstractor) {
        this.subConstractor = subConstractor;
        return this;
    }

    public void setSubConstractor(String subConstractor) {
        this.subConstractor = subConstractor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectArea projectArea = (ProjectArea) o;
        if (projectArea.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectArea.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectArea{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", projId='" + getProjId() + "'" +
            ", name='" + getName() + "'" +
            ", enName='" + getEnName() + "'" +
            ", unitCode='" + getUnitCode() + "'" +
            ", subConstractor='" + getSubConstractor() + "'" +
            "}";
    }
}
