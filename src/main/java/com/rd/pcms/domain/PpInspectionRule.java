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
 * 抽检规则设置表
 * @auther:renntrabbit@foxmail.com
 * @date:Tue Jul 18 17:06:29 CST 2017
 * table:pp_inspection_rule
 */
@ApiModel(description = "抽检规则设置表 @auther:renntrabbit@foxmail.com @date:Tue Jul 18 17:06:29 CST 2017 table:pp_inspection_rule")
@Entity
@Table(name = "pp_inspection_rule")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PpInspectionRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    @Column(name = "comp_id", length = 19, nullable = false)
    private String compId;

    /**
     * COMP_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "COMP_ID", required = true)
    @Column(name = "proj_id", length = 19, nullable = false)
    private String projId;

    /**
     * PROJ_ID
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "PROJ_ID")
    @Column(name = "material", length = 50)
    private String material;

    /**
     * MATERIAL
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "MATERIAL")
    @Column(name = "pp_class", length = 50)
    private String ppClass;

    /**
     * PP_CLASS
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "PP_CLASS")
    @Column(name = "jacketed_pipe", length = 50)
    private String jacketedPipe;

    /**
     * JACKETED_PIPE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "JACKETED_PIPE")
    @Column(name = "inspection_code", length = 50)
    private String inspectionCode;

    /**
     * @ 来源抽检比例表 中的代号
     */
    @NotNull
    @ApiModelProperty(value = "@ 来源抽检比例表 中的代号", required = true)
    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    /**
     * CREATE_TIME
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "CREATE_TIME")
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

    public PpInspectionRule compId(String compId) {
        this.compId = compId;
        return this;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getProjId() {
        return projId;
    }

    public PpInspectionRule projId(String projId) {
        this.projId = projId;
        return this;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getMaterial() {
        return material;
    }

    public PpInspectionRule material(String material) {
        this.material = material;
        return this;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPpClass() {
        return ppClass;
    }

    public PpInspectionRule ppClass(String ppClass) {
        this.ppClass = ppClass;
        return this;
    }

    public void setPpClass(String ppClass) {
        this.ppClass = ppClass;
    }

    public String getJacketedPipe() {
        return jacketedPipe;
    }

    public PpInspectionRule jacketedPipe(String jacketedPipe) {
        this.jacketedPipe = jacketedPipe;
        return this;
    }

    public void setJacketedPipe(String jacketedPipe) {
        this.jacketedPipe = jacketedPipe;
    }

    public String getInspectionCode() {
        return inspectionCode;
    }

    public PpInspectionRule inspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode;
        return this;
    }

    public void setInspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PpInspectionRule createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PpInspectionRule delFlag(Integer delFlag) {
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
        PpInspectionRule ppInspectionRule = (PpInspectionRule) o;
        if (ppInspectionRule.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppInspectionRule.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpInspectionRule{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", projId='" + getProjId() + "'" +
            ", material='" + getMaterial() + "'" +
            ", ppClass='" + getPpClass() + "'" +
            ", jacketedPipe='" + getJacketedPipe() + "'" +
            ", inspectionCode='" + getInspectionCode() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
