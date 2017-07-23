package com.rd.pcms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ProjectArea entity.
 */
public class ProjectAreaDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String compId;

    @NotNull
    @Size(min = 0, max = 19)
    private String projId;

    @Size(min = 0, max = 80)
    private String name;

    @Size(min = 0, max = 100)
    private String enName;

    @Size(min = 0, max = 50)
    private String unitCode;

    @Size(min = 0, max = 80)
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

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getSubConstractor() {
        return subConstractor;
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

        ProjectAreaDTO projectAreaDTO = (ProjectAreaDTO) o;
        if(projectAreaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projectAreaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProjectAreaDTO{" +
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
