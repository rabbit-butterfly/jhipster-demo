package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PpThickness entity.
 */
public class PpThicknessDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String compId;

    @NotNull
    @Size(min = 0, max = 19)
    private String projId;

    @Size(min = 0, max = 5)
    private String jsize;

    @Size(min = 0, max = 50)
    private String wallThickCode;

    @Size(min = 0, max = 19)
    private String externalDiameter;

    @Size(min = 0, max = 19)
    private String thickness;

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

    public String getJsize() {
        return jsize;
    }

    public void setJsize(String jsize) {
        this.jsize = jsize;
    }

    public String getWallThickCode() {
        return wallThickCode;
    }

    public void setWallThickCode(String wallThickCode) {
        this.wallThickCode = wallThickCode;
    }

    public String getExternalDiameter() {
        return externalDiameter;
    }

    public void setExternalDiameter(String externalDiameter) {
        this.externalDiameter = externalDiameter;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
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

        PpThicknessDTO ppThicknessDTO = (PpThicknessDTO) o;
        if(ppThicknessDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppThicknessDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpThicknessDTO{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", projId='" + getProjId() + "'" +
            ", jsize='" + getJsize() + "'" +
            ", wallThickCode='" + getWallThickCode() + "'" +
            ", externalDiameter='" + getExternalDiameter() + "'" +
            ", thickness='" + getThickness() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
