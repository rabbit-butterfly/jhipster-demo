package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PpLineWeldMaterial entity.
 */
public class PpLineWeldMaterialDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String pipelineId;

    @Min(value = 0)
    @Max(value = 10)
    private Integer pageCode;

    @Min(value = 0)
    @Max(value = 10)
    private Integer sequenceNumber;

    @Size(min = 0, max = 50)
    private String materialCode;

    @Size(min = 0, max = 50)
    private String name;

    @Size(min = 0, max = 50)
    private String materialDesc;

    @Size(min = 0, max = 50)
    private String spec;

    @Size(min = 0, max = 20)
    private String unit;

    @Size(min = 0, max = 50)
    private String material;

    @Size(min = 0, max = 50)
    private String designQty;

    @Size(min = 0, max = 500)
    private String remark;

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

    public String getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(String pipelineId) {
        this.pipelineId = pipelineId;
    }

    public Integer getPageCode() {
        return pageCode;
    }

    public void setPageCode(Integer pageCode) {
        this.pageCode = pageCode;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDesignQty() {
        return designQty;
    }

    public void setDesignQty(String designQty) {
        this.designQty = designQty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

        PpLineWeldMaterialDTO ppLineWeldMaterialDTO = (PpLineWeldMaterialDTO) o;
        if(ppLineWeldMaterialDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineWeldMaterialDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineWeldMaterialDTO{" +
            "id=" + getId() +
            ", pipelineId='" + getPipelineId() + "'" +
            ", pageCode='" + getPageCode() + "'" +
            ", sequenceNumber='" + getSequenceNumber() + "'" +
            ", materialCode='" + getMaterialCode() + "'" +
            ", name='" + getName() + "'" +
            ", materialDesc='" + getMaterialDesc() + "'" +
            ", spec='" + getSpec() + "'" +
            ", unit='" + getUnit() + "'" +
            ", material='" + getMaterial() + "'" +
            ", designQty='" + getDesignQty() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
