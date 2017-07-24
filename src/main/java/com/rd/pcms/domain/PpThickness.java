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
 * 管道壁厚设置表
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:pp_thickness
 */
@ApiModel(description = "管道壁厚设置表 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:pp_thickness")
@Entity
@Table(name = "pp_thickness")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PpThickness implements Serializable {

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
     * JSIZE
     */
    @Size(min = 0, max = 5)
    @ApiModelProperty(value = "JSIZE")
    @Column(name = "jsize", length = 5)
    private String jsize;

    /**
     * WALL_THICK_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "WALL_THICK_CODE")
    @Column(name = "wall_thick_code", length = 50)
    private String wallThickCode;

    /**
     * EXTERNAL_DIAMETER
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "EXTERNAL_DIAMETER")
    @Column(name = "external_diameter", length = 19)
    private String externalDiameter;

    /**
     * THICKNESS
     */
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "THICKNESS")
    @Column(name = "thickness", length = 19)
    private String thickness;

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

    public PpThickness compId(String compId) {
        this.compId = compId;
        return this;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getProjId() {
        return projId;
    }

    public PpThickness projId(String projId) {
        this.projId = projId;
        return this;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getJsize() {
        return jsize;
    }

    public PpThickness jsize(String jsize) {
        this.jsize = jsize;
        return this;
    }

    public void setJsize(String jsize) {
        this.jsize = jsize;
    }

    public String getWallThickCode() {
        return wallThickCode;
    }

    public PpThickness wallThickCode(String wallThickCode) {
        this.wallThickCode = wallThickCode;
        return this;
    }

    public void setWallThickCode(String wallThickCode) {
        this.wallThickCode = wallThickCode;
    }

    public String getExternalDiameter() {
        return externalDiameter;
    }

    public PpThickness externalDiameter(String externalDiameter) {
        this.externalDiameter = externalDiameter;
        return this;
    }

    public void setExternalDiameter(String externalDiameter) {
        this.externalDiameter = externalDiameter;
    }

    public String getThickness() {
        return thickness;
    }

    public PpThickness thickness(String thickness) {
        this.thickness = thickness;
        return this;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PpThickness createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PpThickness delFlag(Integer delFlag) {
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
        PpThickness ppThickness = (PpThickness) o;
        if (ppThickness.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppThickness.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpThickness{" +
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
