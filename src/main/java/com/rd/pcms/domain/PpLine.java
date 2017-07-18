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
 * 管道特性表
 * @auther:renntrabbit@foxmail.com
 * @date:Tue Jul 18 17:06:29 CST 2017
 * table:pp_line
 */
@ApiModel(description = "管道特性表 @auther:renntrabbit@foxmail.com @date:Tue Jul 18 17:06:29 CST 2017 table:pp_line")
@Entity
@Table(name = "pp_line")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PpLine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    @Column(name = "comp_id", length = 19, nullable = false)
    private String compId;

    /**
     * comp_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "comp_ID", required = true)
    @Column(name = "proj_id", length = 19, nullable = false)
    private String projId;

    /**
     * PROJ_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PROJ_ID", required = true)
    @Column(name = "area_id", length = 19, nullable = false)
    private String areaId;

    /**
     * AREA_ID
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "AREA_ID")
    @Column(name = "line_num", length = 50)
    private String lineNum;

    /**
     * LINE_NUM
     */
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "LINE_NUM")
    @Column(name = "line_version", length = 20)
    private String lineVersion;

    /**
     * LINE_VERSION
     */
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "LINE_VERSION")
    @Column(name = "jhi_size", length = 10)
    private String size;

    /**
     * SIZE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "SIZE")
    @Column(name = "serv", length = 50)
    private String serv;

    /**
     * SERV
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "SERV")
    @Column(name = "class_spec", length = 50)
    private String classSpec;

    /**
     * @
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "@")
    @Column(name = "line_from", length = 50)
    private String lineFrom;

    /**
     * LINE_FROM
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "LINE_FROM")
    @Column(name = "line_to", length = 50)
    private String lineTo;

    /**
     * LINE_TO
     */
    @Size(min = 0, max = 20)
    @ApiModelProperty(value = "LINE_TO")
    @Column(name = "operate_pressure", length = 20)
    private String operatePressure;

    /**
     * OPERATE_PRESSURE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "OPERATE_PRESSURE")
    @Column(name = "operate_temperature", length = 50)
    private String operateTemperature;

    /**
     * OPERATE_TEMPERATURE
     */
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "OPERATE_TEMPERATURE")
    @Column(name = "line_level", length = 10)
    private String lineLevel;

    /**
     * LINE_LEVEL
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "LINE_LEVEL")
    @Column(name = "line_code", length = 50)
    private String lineCode;

    /**
     * LINE_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "LINE_CODE")
    @Column(name = "design_pressure", length = 50)
    private String designPressure;

    /**
     * DESIGN_PRESSURE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "DESIGN_PRESSURE")
    @Column(name = "design_temperature", length = 50)
    private String designTemperature;

    /**
     * DESIGN_TEMPERATURE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "DESIGN_TEMPERATURE")
    @Column(name = "kind_level", length = 50)
    private String kindLevel;

    /**
     * KIND_LEVEL
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "KIND_LEVEL")
    @Column(name = "inspection_code", length = 50)
    private String inspectionCode;

    /**
     * INSPECTION_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "INSPECTION_CODE")
    @Column(name = "insulation_code", length = 50)
    private String insulationCode;

    /**
     * INSULATION_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "INSULATION_CODE")
    @Column(name = "insulation_high", length = 50)
    private String insulationHigh;

    /**
     * INSULATION_HIGH
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "INSULATION_HIGH")
    @Column(name = "paint_code", length = 50)
    private String paintCode;

    /**
     * PAINT_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "PAINT_CODE")
    @Column(name = "p_i_diagram", length = 50)
    private String pIDiagram;

    /**
     * P_I_DIAGRAM
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "P_I_DIAGRAM")
    @Column(name = "test_pressure", length = 50)
    private String testPressure;

    /**
     * TEST_PRESSURE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "TEST_PRESSURE")
    @Column(name = "test_material", length = 50)
    private String testMaterial;

    /**
     * TEST_MATERIAL
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "TEST_MATERIAL")
    @Column(name = "jacketed_pipe", length = 50)
    private String jacketedPipe;

    /**
     * JACKETED_PIPE
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "JACKETED_PIPE")
    @Column(name = "remark", length = 500)
    private String remark;

    /**
     * REMARK
     */
    @NotNull
    @ApiModelProperty(value = "REMARK", required = true)
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

    public PpLine compId(String compId) {
        this.compId = compId;
        return this;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getProjId() {
        return projId;
    }

    public PpLine projId(String projId) {
        this.projId = projId;
        return this;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getAreaId() {
        return areaId;
    }

    public PpLine areaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getLineNum() {
        return lineNum;
    }

    public PpLine lineNum(String lineNum) {
        this.lineNum = lineNum;
        return this;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public String getLineVersion() {
        return lineVersion;
    }

    public PpLine lineVersion(String lineVersion) {
        this.lineVersion = lineVersion;
        return this;
    }

    public void setLineVersion(String lineVersion) {
        this.lineVersion = lineVersion;
    }

    public String getSize() {
        return size;
    }

    public PpLine size(String size) {
        this.size = size;
        return this;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getServ() {
        return serv;
    }

    public PpLine serv(String serv) {
        this.serv = serv;
        return this;
    }

    public void setServ(String serv) {
        this.serv = serv;
    }

    public String getClassSpec() {
        return classSpec;
    }

    public PpLine classSpec(String classSpec) {
        this.classSpec = classSpec;
        return this;
    }

    public void setClassSpec(String classSpec) {
        this.classSpec = classSpec;
    }

    public String getLineFrom() {
        return lineFrom;
    }

    public PpLine lineFrom(String lineFrom) {
        this.lineFrom = lineFrom;
        return this;
    }

    public void setLineFrom(String lineFrom) {
        this.lineFrom = lineFrom;
    }

    public String getLineTo() {
        return lineTo;
    }

    public PpLine lineTo(String lineTo) {
        this.lineTo = lineTo;
        return this;
    }

    public void setLineTo(String lineTo) {
        this.lineTo = lineTo;
    }

    public String getOperatePressure() {
        return operatePressure;
    }

    public PpLine operatePressure(String operatePressure) {
        this.operatePressure = operatePressure;
        return this;
    }

    public void setOperatePressure(String operatePressure) {
        this.operatePressure = operatePressure;
    }

    public String getOperateTemperature() {
        return operateTemperature;
    }

    public PpLine operateTemperature(String operateTemperature) {
        this.operateTemperature = operateTemperature;
        return this;
    }

    public void setOperateTemperature(String operateTemperature) {
        this.operateTemperature = operateTemperature;
    }

    public String getLineLevel() {
        return lineLevel;
    }

    public PpLine lineLevel(String lineLevel) {
        this.lineLevel = lineLevel;
        return this;
    }

    public void setLineLevel(String lineLevel) {
        this.lineLevel = lineLevel;
    }

    public String getLineCode() {
        return lineCode;
    }

    public PpLine lineCode(String lineCode) {
        this.lineCode = lineCode;
        return this;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getDesignPressure() {
        return designPressure;
    }

    public PpLine designPressure(String designPressure) {
        this.designPressure = designPressure;
        return this;
    }

    public void setDesignPressure(String designPressure) {
        this.designPressure = designPressure;
    }

    public String getDesignTemperature() {
        return designTemperature;
    }

    public PpLine designTemperature(String designTemperature) {
        this.designTemperature = designTemperature;
        return this;
    }

    public void setDesignTemperature(String designTemperature) {
        this.designTemperature = designTemperature;
    }

    public String getKindLevel() {
        return kindLevel;
    }

    public PpLine kindLevel(String kindLevel) {
        this.kindLevel = kindLevel;
        return this;
    }

    public void setKindLevel(String kindLevel) {
        this.kindLevel = kindLevel;
    }

    public String getInspectionCode() {
        return inspectionCode;
    }

    public PpLine inspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode;
        return this;
    }

    public void setInspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode;
    }

    public String getInsulationCode() {
        return insulationCode;
    }

    public PpLine insulationCode(String insulationCode) {
        this.insulationCode = insulationCode;
        return this;
    }

    public void setInsulationCode(String insulationCode) {
        this.insulationCode = insulationCode;
    }

    public String getInsulationHigh() {
        return insulationHigh;
    }

    public PpLine insulationHigh(String insulationHigh) {
        this.insulationHigh = insulationHigh;
        return this;
    }

    public void setInsulationHigh(String insulationHigh) {
        this.insulationHigh = insulationHigh;
    }

    public String getPaintCode() {
        return paintCode;
    }

    public PpLine paintCode(String paintCode) {
        this.paintCode = paintCode;
        return this;
    }

    public void setPaintCode(String paintCode) {
        this.paintCode = paintCode;
    }

    public String getpIDiagram() {
        return pIDiagram;
    }

    public PpLine pIDiagram(String pIDiagram) {
        this.pIDiagram = pIDiagram;
        return this;
    }

    public void setpIDiagram(String pIDiagram) {
        this.pIDiagram = pIDiagram;
    }

    public String getTestPressure() {
        return testPressure;
    }

    public PpLine testPressure(String testPressure) {
        this.testPressure = testPressure;
        return this;
    }

    public void setTestPressure(String testPressure) {
        this.testPressure = testPressure;
    }

    public String getTestMaterial() {
        return testMaterial;
    }

    public PpLine testMaterial(String testMaterial) {
        this.testMaterial = testMaterial;
        return this;
    }

    public void setTestMaterial(String testMaterial) {
        this.testMaterial = testMaterial;
    }

    public String getJacketedPipe() {
        return jacketedPipe;
    }

    public PpLine jacketedPipe(String jacketedPipe) {
        this.jacketedPipe = jacketedPipe;
        return this;
    }

    public void setJacketedPipe(String jacketedPipe) {
        this.jacketedPipe = jacketedPipe;
    }

    public String getRemark() {
        return remark;
    }

    public PpLine remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PpLine createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PpLine delFlag(Integer delFlag) {
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
        PpLine ppLine = (PpLine) o;
        if (ppLine.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLine.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLine{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", projId='" + getProjId() + "'" +
            ", areaId='" + getAreaId() + "'" +
            ", lineNum='" + getLineNum() + "'" +
            ", lineVersion='" + getLineVersion() + "'" +
            ", size='" + getSize() + "'" +
            ", serv='" + getServ() + "'" +
            ", classSpec='" + getClassSpec() + "'" +
            ", lineFrom='" + getLineFrom() + "'" +
            ", lineTo='" + getLineTo() + "'" +
            ", operatePressure='" + getOperatePressure() + "'" +
            ", operateTemperature='" + getOperateTemperature() + "'" +
            ", lineLevel='" + getLineLevel() + "'" +
            ", lineCode='" + getLineCode() + "'" +
            ", designPressure='" + getDesignPressure() + "'" +
            ", designTemperature='" + getDesignTemperature() + "'" +
            ", kindLevel='" + getKindLevel() + "'" +
            ", inspectionCode='" + getInspectionCode() + "'" +
            ", insulationCode='" + getInsulationCode() + "'" +
            ", insulationHigh='" + getInsulationHigh() + "'" +
            ", paintCode='" + getPaintCode() + "'" +
            ", pIDiagram='" + getpIDiagram() + "'" +
            ", testPressure='" + getTestPressure() + "'" +
            ", testMaterial='" + getTestMaterial() + "'" +
            ", jacketedPipe='" + getJacketedPipe() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
