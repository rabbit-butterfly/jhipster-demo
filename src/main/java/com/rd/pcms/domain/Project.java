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
 * 存放项目的基本信息:开始时间，结束时间，是否停工等
 * @auther:renntrabbit@foxmail.com
 * @date:Tue Jul 25 20:17:28 CST 2017
 * table:project
 */
@ApiModel(description = "存放项目的基本信息:开始时间，结束时间，是否停工等 @auther:renntrabbit@foxmail.com @date:Tue Jul 25 20:17:28 CST 2017 table:project")
@Entity
@Table(name = "project")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 项目公司ID
     */
    @NotNull
    @Min(value = 0)
    @Max(value = 19)
    @ApiModelProperty(value = "项目公司ID", required = true)
    @Column(name = "proj_comp_id", nullable = false)
    private Long projCompId;

    /**
     * 项目公司名称
     */
    @NotNull
    @Size(min = 0, max = 128)
    @ApiModelProperty(value = "项目公司名称", required = true)
    @Column(name = "proj_comp_name", length = 128, nullable = false)
    private String projCompName;

    /**
     * CODE
     */
    @NotNull
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "CODE", required = true)
    @Column(name = "code", length = 20, nullable = false)
    private String code;

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
    @Size(min = 0, max = 32)
    @ApiModelProperty(value = "EN_NAME")
    @Column(name = "en_name", length = 32)
    private String enName;

    /**
     * SUPERVISOR
     */
    @Size(min = 0, max = 100)
    @ApiModelProperty(value = "SUPERVISOR")
    @Column(name = "supervisor", length = 100)
    private String supervisor;

    /**
     * OWNER_CONTRACTOR
     */
    @Size(min = 0, max = 100)
    @ApiModelProperty(value = "OWNER_CONTRACTOR")
    @Column(name = "owner_contractor", length = 100)
    private String ownerContractor;

    /**
     * TOTAL_CONTRACTOR
     */
    @Size(min = 0, max = 100)
    @ApiModelProperty(value = "TOTAL_CONTRACTOR")
    @Column(name = "total_contractor", length = 100)
    private String totalContractor;

    /**
     * START_DATE
     */
    @ApiModelProperty(value = "START_DATE")
    @Column(name = "start_date")
    private Instant startDate;

    /**
     * END_DATE
     */
    @ApiModelProperty(value = "END_DATE")
    @Column(name = "end_date")
    private Instant endDate;

    /**
     * 0：待审核 1：审核通过 2：审核失败 3：终结
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "0：待审核 1：审核通过 2：审核失败 3：终结")
    @Column(name = "status")
    private Integer status;

    /**
     * DEL_FLAG
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "DEL_FLAG")
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * REMARK
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "REMARK")
    @Column(name = "remark", length = 500)
    private String remark;

    /**
     * 扩展字段
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "扩展字段")
    @Column(name = "extend_attr", length = 50)
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

    public Project projCompId(Long projCompId) {
        this.projCompId = projCompId;
        return this;
    }

    public void setProjCompId(Long projCompId) {
        this.projCompId = projCompId;
    }

    public String getProjCompName() {
        return projCompName;
    }

    public Project projCompName(String projCompName) {
        this.projCompName = projCompName;
        return this;
    }

    public void setProjCompName(String projCompName) {
        this.projCompName = projCompName;
    }

    public String getCode() {
        return code;
    }

    public Project code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Project name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public Project enName(String enName) {
        this.enName = enName;
        return this;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public Project supervisor(String supervisor) {
        this.supervisor = supervisor;
        return this;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getOwnerContractor() {
        return ownerContractor;
    }

    public Project ownerContractor(String ownerContractor) {
        this.ownerContractor = ownerContractor;
        return this;
    }

    public void setOwnerContractor(String ownerContractor) {
        this.ownerContractor = ownerContractor;
    }

    public String getTotalContractor() {
        return totalContractor;
    }

    public Project totalContractor(String totalContractor) {
        this.totalContractor = totalContractor;
        return this;
    }

    public void setTotalContractor(String totalContractor) {
        this.totalContractor = totalContractor;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Project startDate(Instant startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Project endDate(Instant endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public Project status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Project delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public Project remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExtendAttr() {
        return extendAttr;
    }

    public Project extendAttr(String extendAttr) {
        this.extendAttr = extendAttr;
        return this;
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
        Project project = (Project) o;
        if (project.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), project.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Project{" +
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
