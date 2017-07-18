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
 * @date:Tue Jul 18 17:06:29 CST 2017
 * table:project
 */
@ApiModel(description = "存放项目的基本信息:开始时间，结束时间，是否停工等 @auther:renntrabbit@foxmail.com @date:Tue Jul 18 17:06:29 CST 2017 table:project")
@Entity
@Table(name = "project")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 20)
    @Column(name = "code", length = 20, nullable = false)
    private String code;

    /**
     * CODE
     */
    @Size(min = 0, max = 80)
    @ApiModelProperty(value = "CODE")
    @Column(name = "name", length = 80)
    private String name;

    /**
     * NAME
     */
    @Size(min = 0, max = 30)
    @ApiModelProperty(value = "NAME")
    @Column(name = "en_name", length = 30)
    private String enName;

    /**
     * EN_NAME
     */
    @Size(min = 0, max = 100)
    @ApiModelProperty(value = "EN_NAME")
    @Column(name = "supervisor", length = 100)
    private String supervisor;

    /**
     * SUPERVISOR
     */
    @Size(min = 0, max = 100)
    @ApiModelProperty(value = "SUPERVISOR")
    @Column(name = "o_contractor", length = 100)
    private String oContractor;

    /**
     * O_CONTRACTOR
     */
    @Size(min = 0, max = 100)
    @ApiModelProperty(value = "O_CONTRACTOR")
    @Column(name = "h_contractor", length = 100)
    private String hContractor;

    /**
     * H_CONTRACTOR
     */
    @ApiModelProperty(value = "H_CONTRACTOR")
    @Column(name = "start_date")
    private Instant startDate;

    /**
     * START_DATE
     */
    @ApiModelProperty(value = "START_DATE")
    @Column(name = "end_date")
    private Instant endDate;

    /**
     * END_DATE
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "END_DATE")
    @Column(name = "status")
    private Integer status;

    /**
     * 0：待审核 1：审核通过 2：审核失败 3：终结
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "0：待审核 1：审核通过 2：审核失败 3：终结")
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * DEL_FLAG
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "DEL_FLAG")
    @Column(name = "remark", length = 500)
    private String remark;

    /**
     * REMARK
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "REMARK")
    @Column(name = "extend_attr", length = 50)
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

    public String getoContractor() {
        return oContractor;
    }

    public Project oContractor(String oContractor) {
        this.oContractor = oContractor;
        return this;
    }

    public void setoContractor(String oContractor) {
        this.oContractor = oContractor;
    }

    public String gethContractor() {
        return hContractor;
    }

    public Project hContractor(String hContractor) {
        this.hContractor = hContractor;
        return this;
    }

    public void sethContractor(String hContractor) {
        this.hContractor = hContractor;
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
