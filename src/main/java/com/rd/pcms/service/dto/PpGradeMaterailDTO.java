package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PpGradeMaterail entity.
 */
public class PpGradeMaterailDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String compId;

    @NotNull
    @Size(min = 0, max = 19)
    private String projId;

    @Size(min = 0, max = 50)
    private String material;

    @Size(min = 0, max = 50)
    private String ppClass;

    @Size(min = 0, max = 50)
    private String jsizeMin;

    @Size(min = 0, max = 50)
    private String jsizeMax;

    @Size(min = 0, max = 64)
    private String wallThickCode;

    @Size(min = 0, max = 64)
    private String materialType;

    @Size(min = 0, max = 50)
    private String materialCategory;

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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPpClass() {
        return ppClass;
    }

    public void setPpClass(String ppClass) {
        this.ppClass = ppClass;
    }

    public String getJsizeMin() {
        return jsizeMin;
    }

    public void setJsizeMin(String jsizeMin) {
        this.jsizeMin = jsizeMin;
    }

    public String getJsizeMax() {
        return jsizeMax;
    }

    public void setJsizeMax(String jsizeMax) {
        this.jsizeMax = jsizeMax;
    }

    public String getWallThickCode() {
        return wallThickCode;
    }

    public void setWallThickCode(String wallThickCode) {
        this.wallThickCode = wallThickCode;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(String materialCategory) {
        this.materialCategory = materialCategory;
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

        PpGradeMaterailDTO ppGradeMaterailDTO = (PpGradeMaterailDTO) o;
        if(ppGradeMaterailDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppGradeMaterailDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpGradeMaterailDTO{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", projId='" + getProjId() + "'" +
            ", material='" + getMaterial() + "'" +
            ", ppClass='" + getPpClass() + "'" +
            ", jsizeMin='" + getJsizeMin() + "'" +
            ", jsizeMax='" + getJsizeMax() + "'" +
            ", wallThickCode='" + getWallThickCode() + "'" +
            ", materialType='" + getMaterialType() + "'" +
            ", materialCategory='" + getMaterialCategory() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
