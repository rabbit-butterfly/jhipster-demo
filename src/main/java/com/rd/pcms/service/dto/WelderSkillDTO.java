package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the WelderSkill entity.
 */
public class WelderSkillDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String welderId;

    @NotNull
    @Size(min = 0, max = 80)
    private String name;

    private Instant assessmentDate;

    private Instant effectiveDate;

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

    public String getWelderId() {
        return welderId;
    }

    public void setWelderId(String welderId) {
        this.welderId = welderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(Instant assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public Instant getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Instant effectiveDate) {
        this.effectiveDate = effectiveDate;
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

        WelderSkillDTO welderSkillDTO = (WelderSkillDTO) o;
        if(welderSkillDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), welderSkillDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WelderSkillDTO{" +
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
