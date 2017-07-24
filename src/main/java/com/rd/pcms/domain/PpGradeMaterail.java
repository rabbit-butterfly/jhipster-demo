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
 * 等级材质对照表
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:pp_grade_materail
 */
@ApiModel(description = "等级材质对照表 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:pp_grade_materail")
@Entity
@Table(name = "pp_grade_materail")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PpGradeMaterail implements Serializable {

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
     * PROJ_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PROJ_ID", required = true)
    @Column(name = "proj_id", length = 19, nullable = false)
    private String projId;

    /**
     * MATERIAL
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "MATERIAL")
    @Column(name = "material", length = 50)
    private String material;

    /**
     * PP_CLASS
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "PP_CLASS")
    @Column(name = "pp_class", length = 50)
    private String ppClass;

    /**
     * JSIZE_MIN
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "JSIZE_MIN")
    @Column(name = "jsize_min", length = 50)
    private String jsizeMin;

    /**
     * @ 来源抽检比例表 中的代号
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "@ 来源抽检比例表 中的代号")
    @Column(name = "jsize_max", length = 50)
    private String jsizeMax;

    /**
     * WALL_THICK_CODE
     */
    @Size(min = 0, max = 64)
    @ApiModelProperty(value = "WALL_THICK_CODE")
    @Column(name = "wall_thick_code", length = 64)
    private String wallThickCode;

    /**
     * @ CS SS PE
     */
    @Size(min = 0, max = 64)
    @ApiModelProperty(value = "@ CS SS PE")
    @Column(name = "material_type", length = 64)
    private String materialType;

    /**
     * @ 常量
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "@ 常量")
    @Column(name = "material_category", length = 50)
    private String materialCategory;

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

    public String getCompId() {
        return compId;
    }

    public PpGradeMaterail compId(String compId) {
        this.compId = compId;
        return this;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getProjId() {
        return projId;
    }

    public PpGradeMaterail projId(String projId) {
        this.projId = projId;
        return this;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getMaterial() {
        return material;
    }

    public PpGradeMaterail material(String material) {
        this.material = material;
        return this;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPpClass() {
        return ppClass;
    }

    public PpGradeMaterail ppClass(String ppClass) {
        this.ppClass = ppClass;
        return this;
    }

    public void setPpClass(String ppClass) {
        this.ppClass = ppClass;
    }

    public String getJsizeMin() {
        return jsizeMin;
    }

    public PpGradeMaterail jsizeMin(String jsizeMin) {
        this.jsizeMin = jsizeMin;
        return this;
    }

    public void setJsizeMin(String jsizeMin) {
        this.jsizeMin = jsizeMin;
    }

    public String getJsizeMax() {
        return jsizeMax;
    }

    public PpGradeMaterail jsizeMax(String jsizeMax) {
        this.jsizeMax = jsizeMax;
        return this;
    }

    public void setJsizeMax(String jsizeMax) {
        this.jsizeMax = jsizeMax;
    }

    public String getWallThickCode() {
        return wallThickCode;
    }

    public PpGradeMaterail wallThickCode(String wallThickCode) {
        this.wallThickCode = wallThickCode;
        return this;
    }

    public void setWallThickCode(String wallThickCode) {
        this.wallThickCode = wallThickCode;
    }

    public String getMaterialType() {
        return materialType;
    }

    public PpGradeMaterail materialType(String materialType) {
        this.materialType = materialType;
        return this;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialCategory() {
        return materialCategory;
    }

    public PpGradeMaterail materialCategory(String materialCategory) {
        this.materialCategory = materialCategory;
        return this;
    }

    public void setMaterialCategory(String materialCategory) {
        this.materialCategory = materialCategory;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PpGradeMaterail createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PpGradeMaterail delFlag(Integer delFlag) {
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
        PpGradeMaterail ppGradeMaterail = (PpGradeMaterail) o;
        if (ppGradeMaterail.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppGradeMaterail.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpGradeMaterail{" +
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
