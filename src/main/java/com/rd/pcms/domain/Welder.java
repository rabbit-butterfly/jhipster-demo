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
 * 焊工工人表-包括：焊工姓名、手机号码、所在班组等
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:welder
 */
@ApiModel(description = "焊工工人表-包括：焊工姓名、手机号码、所在班组等 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:welder")
@Entity
@Table(name = "welder")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Welder implements Serializable {

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
     * CODE
     */
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "CODE")
    @Column(name = "code", length = 20)
    private String code;

    /**
     * NAME
     */
    @NotNull
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "NAME", required = true)
    @Column(name = "name", length = 10, nullable = false)
    private String name;

    /**
     * MOBILLE
     */
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "MOBILLE")
    @Column(name = "mobille", length = 16)
    private String mobille;

    /**
     * IDENTITY_CARD
     */
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "IDENTITY_CARD")
    @Column(name = "identity_card", length = 20)
    private String identityCard;

    /**
     * WORK_TERM
     */
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "WORK_TERM")
    @Column(name = "work_term", length = 10)
    private String workTerm;

    /**
     * UNIT_NAME
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "UNIT_NAME")
    @Column(name = "unit_name", length = 50)
    private String unitName;

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

    /**
     * REMARK
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "REMARK")
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

    public Welder compId(String compId) {
        this.compId = compId;
        return this;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getCode() {
        return code;
    }

    public Welder code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Welder name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobille() {
        return mobille;
    }

    public Welder mobille(String mobille) {
        this.mobille = mobille;
        return this;
    }

    public void setMobille(String mobille) {
        this.mobille = mobille;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public Welder identityCard(String identityCard) {
        this.identityCard = identityCard;
        return this;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getWorkTerm() {
        return workTerm;
    }

    public Welder workTerm(String workTerm) {
        this.workTerm = workTerm;
        return this;
    }

    public void setWorkTerm(String workTerm) {
        this.workTerm = workTerm;
    }

    public String getUnitName() {
        return unitName;
    }

    public Welder unitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public Welder createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Welder delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public Welder remark(String remark) {
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
        Welder welder = (Welder) o;
        if (welder.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), welder.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Welder{" +
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
