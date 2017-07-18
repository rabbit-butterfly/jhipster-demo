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
 * 项目 焊工 工人 关系表
 * @auther:renntrabbit@foxmail.com
 * @date:Tue Jul 18 17:06:29 CST 2017
 * table:project_welder
 */
@ApiModel(description = "项目 焊工 工人 关系表 @auther:renntrabbit@foxmail.com @date:Tue Jul 18 17:06:29 CST 2017 table:project_welder")
@Entity
@Table(name = "project_welder")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProjectWelder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    @Column(name = "comp_id", length = 19, nullable = false)
    private String compId;

    /**
     * COMP_ID
     */
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "COMP_ID")
    @Column(name = "code", length = 20)
    private String code;

    /**
     * CODE
     */
    @NotNull
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "CODE", required = true)
    @Column(name = "name", length = 10, nullable = false)
    private String name;

    /**
     * NAME
     */
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "NAME")
    @Column(name = "mobille", length = 16)
    private String mobille;

    /**
     * MOBILLE
     */
    @Size(min = 0, max = 18)
    @ApiModelProperty(value = "MOBILLE")
    @Column(name = "identity_card", length = 18)
    private String identityCard;

    /**
     * IDENTITY_CARD
     */
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "IDENTITY_CARD")
    @Column(name = "work_term", length = 10)
    private String workTerm;

    /**
     * WORK_TERM
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "WORK_TERM")
    @Column(name = "unit_name", length = 50)
    private String unitName;

    /**
     * UNIT_NAME
     */
    @NotNull
    @ApiModelProperty(value = "UNIT_NAME", required = true)
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

    /**
     * DEL_FLAG
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "DEL_FLAG")
    @Column(name = "remark", length = 500)
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompId() {
        return compId;
    }

    public ProjectWelder compId(String compId) {
        this.compId = compId;
        return this;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getCode() {
        return code;
    }

    public ProjectWelder code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public ProjectWelder name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobille() {
        return mobille;
    }

    public ProjectWelder mobille(String mobille) {
        this.mobille = mobille;
        return this;
    }

    public void setMobille(String mobille) {
        this.mobille = mobille;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public ProjectWelder identityCard(String identityCard) {
        this.identityCard = identityCard;
        return this;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getWorkTerm() {
        return workTerm;
    }

    public ProjectWelder workTerm(String workTerm) {
        this.workTerm = workTerm;
        return this;
    }

    public void setWorkTerm(String workTerm) {
        this.workTerm = workTerm;
    }

    public String getUnitName() {
        return unitName;
    }

    public ProjectWelder unitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public ProjectWelder createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public ProjectWelder delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public ProjectWelder remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectWelder projectWelder = (ProjectWelder) o;
        if (projectWelder.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectWelder.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectWelder{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", mobille='" + getMobille() + "'" +
            ", identityCard='" + getIdentityCard() + "'" +
            ", workTerm='" + getWorkTerm() + "'" +
            ", unitName='" + getUnitName() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
