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
 * 焊工技能表
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:welder_skill
 */
@ApiModel(description = "焊工技能表 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:welder_skill")
@Entity
@Table(name = "welder_skill")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WelderSkill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * WELDER_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "WELDER_ID", required = true)
    @Column(name = "welder_id", length = 19, nullable = false)
    private String welderId;

    /**
     * NAME
     */
    @NotNull
    @Size(min = 0, max = 80)
    @ApiModelProperty(value = "NAME", required = true)
    @Column(name = "name", length = 80, nullable = false)
    private String name;

    /**
     * ASSESSMENT_DATE
     */
    @ApiModelProperty(value = "ASSESSMENT_DATE")
    @Column(name = "assessment_date")
    private Instant assessmentDate;

    /**
     * EFFECTIVE_DATE
     */
    @ApiModelProperty(value = "EFFECTIVE_DATE")
    @Column(name = "effective_date")
    private Instant effectiveDate;

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

    public String getWelderId() {
        return welderId;
    }

    public WelderSkill welderId(String welderId) {
        this.welderId = welderId;
        return this;
    }

    public void setWelderId(String welderId) {
        this.welderId = welderId;
    }

    public String getName() {
        return name;
    }

    public WelderSkill name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getAssessmentDate() {
        return assessmentDate;
    }

    public WelderSkill assessmentDate(Instant assessmentDate) {
        this.assessmentDate = assessmentDate;
        return this;
    }

    public void setAssessmentDate(Instant assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public Instant getEffectiveDate() {
        return effectiveDate;
    }

    public WelderSkill effectiveDate(Instant effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public void setEffectiveDate(Instant effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public WelderSkill createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public WelderSkill delFlag(Integer delFlag) {
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
        WelderSkill welderSkill = (WelderSkill) o;
        if (welderSkill.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), welderSkill.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WelderSkill{" +
            "id=" + getId() +
            ", welderId='" + getWelderId() + "'" +
            ", name='" + getName() + "'" +
            ", assessmentDate='" + getAssessmentDate() + "'" +
            ", effectiveDate='" + getEffectiveDate() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
