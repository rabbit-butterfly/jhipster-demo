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
 * 管线-焊接材料记录表
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:pp_line_weld_material
 */
@ApiModel(description = "管线-焊接材料记录表 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:pp_line_weld_material")
@Entity
@Table(name = "pp_line_weld_material")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PpLineWeldMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * PIPELINE_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PIPELINE_ID", required = true)
    @Column(name = "pipeline_id", length = 19, nullable = false)
    private String pipelineId;

    /**
     * PAGE_CODE
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "PAGE_CODE")
    @Column(name = "page_code")
    private Integer pageCode;

    /**
     * SEQUENCE_NUMBER
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "SEQUENCE_NUMBER")
    @Column(name = "sequence_number")
    private Integer sequenceNumber;

    /**
     * MATERIAL_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "MATERIAL_CODE")
    @Column(name = "material_code", length = 50)
    private String materialCode;

    /**
     * NAME
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "NAME")
    @Column(name = "name", length = 50)
    private String name;

    /**
     * MATERIAL_DESC
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "MATERIAL_DESC")
    @Column(name = "material_desc", length = 50)
    private String materialDesc;

    /**
     * SPEC
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "SPEC")
    @Column(name = "spec", length = 50)
    private String spec;

    /**
     * UNIT
     */
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "UNIT")
    @Column(name = "unit", length = 20)
    private String unit;

    /**
     * MATERIAL
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "MATERIAL")
    @Column(name = "material", length = 50)
    private String material;

    /**
     * DESIGN_QTY
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "DESIGN_QTY")
    @Column(name = "design_qty", length = 50)
    private String designQty;

    /**
     * REMARK
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "REMARK")
    @Column(name = "remark", length = 500)
    private String remark;

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

    public String getPipelineId() {
        return pipelineId;
    }

    public PpLineWeldMaterial pipelineId(String pipelineId) {
        this.pipelineId = pipelineId;
        return this;
    }

    public void setPipelineId(String pipelineId) {
        this.pipelineId = pipelineId;
    }

    public Integer getPageCode() {
        return pageCode;
    }

    public PpLineWeldMaterial pageCode(Integer pageCode) {
        this.pageCode = pageCode;
        return this;
    }

    public void setPageCode(Integer pageCode) {
        this.pageCode = pageCode;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public PpLineWeldMaterial sequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
        return this;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public PpLineWeldMaterial materialCode(String materialCode) {
        this.materialCode = materialCode;
        return this;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getName() {
        return name;
    }

    public PpLineWeldMaterial name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public PpLineWeldMaterial materialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
        return this;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public String getSpec() {
        return spec;
    }

    public PpLineWeldMaterial spec(String spec) {
        this.spec = spec;
        return this;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public PpLineWeldMaterial unit(String unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMaterial() {
        return material;
    }

    public PpLineWeldMaterial material(String material) {
        this.material = material;
        return this;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDesignQty() {
        return designQty;
    }

    public PpLineWeldMaterial designQty(String designQty) {
        this.designQty = designQty;
        return this;
    }

    public void setDesignQty(String designQty) {
        this.designQty = designQty;
    }

    public String getRemark() {
        return remark;
    }

    public PpLineWeldMaterial remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PpLineWeldMaterial createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PpLineWeldMaterial delFlag(Integer delFlag) {
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
        PpLineWeldMaterial ppLineWeldMaterial = (PpLineWeldMaterial) o;
        if (ppLineWeldMaterial.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineWeldMaterial.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineWeldMaterial{" +
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
