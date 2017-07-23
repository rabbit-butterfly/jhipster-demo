package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ProjectWelder entity.
 */
public class ProjectWelderDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String compId;

    @Size(min = 0, max = 20)
    private String code;

    @NotNull
    @Size(min = 0, max = 10)
    private String name;

    @Size(min = 0, max = 16)
    private String mobille;

    @Size(min = 0, max = 18)
    private String identityCard;

    @Size(min = 0, max = 10)
    private String workTerm;

    @Size(min = 0, max = 50)
    private String unitName;

    @NotNull
    private Instant createTime;

    @Min(value = 0)
    @Max(value = 10)
    private Integer delFlag;

    @Size(min = 0, max = 500)
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

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobille() {
        return mobille;
    }

    public void setMobille(String mobille) {
        this.mobille = mobille;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getWorkTerm() {
        return workTerm;
    }

    public void setWorkTerm(String workTerm) {
        this.workTerm = workTerm;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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

    public String getRemark() {
        return remark;
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

        ProjectWelderDTO projectWelderDTO = (ProjectWelderDTO) o;
        if(projectWelderDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectWelderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectWelderDTO{" +
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
