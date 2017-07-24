package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PpLine entity.
 */
public class PpLineDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String compId;

    @NotNull
    @Size(min = 0, max = 19)
    private String projId;

    @NotNull
    @Size(min = 0, max = 19)
    private String areaId;

    @Size(min = 0, max = 50)
    private String lineNum;

    @Size(min = 0, max = 20)
    private String lineVersion;

    @Size(min = 0, max = 10)
    private String size;

    @Size(min = 0, max = 50)
    private String serv;

    @Size(min = 0, max = 50)
    private String classSpec;

    @Size(min = 0, max = 50)
    private String lineFrom;

    @Size(min = 0, max = 50)
    private String lineTo;

    @Size(min = 0, max = 20)
    private String operatePressure;

    @Size(min = 0, max = 50)
    private String operateTemperature;

    @Size(min = 0, max = 10)
    private String lineLevel;

    @Size(min = 0, max = 50)
    private String lineCode;

    @Size(min = 0, max = 50)
    private String designPressure;

    @Size(min = 0, max = 50)
    private String designTemperature;

    @Size(min = 0, max = 50)
    private String kindLevel;

    @Size(min = 0, max = 50)
    private String inspectionCode;

    @Size(min = 0, max = 50)
    private String insulationCode;

    @Size(min = 0, max = 50)
    private String insulationHigh;

    @Size(min = 0, max = 50)
    private String paintCode;

    @Size(min = 0, max = 50)
    private String piDiagram;

    @Size(min = 0, max = 50)
    private String testPressure;

    @Size(min = 0, max = 50)
    private String testMaterial;

    @Size(min = 0, max = 50)
    private String jacketedPipe;

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

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public String getLineVersion() {
        return lineVersion;
    }

    public void setLineVersion(String lineVersion) {
        this.lineVersion = lineVersion;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getServ() {
        return serv;
    }

    public void setServ(String serv) {
        this.serv = serv;
    }

    public String getClassSpec() {
        return classSpec;
    }

    public void setClassSpec(String classSpec) {
        this.classSpec = classSpec;
    }

    public String getLineFrom() {
        return lineFrom;
    }

    public void setLineFrom(String lineFrom) {
        this.lineFrom = lineFrom;
    }

    public String getLineTo() {
        return lineTo;
    }

    public void setLineTo(String lineTo) {
        this.lineTo = lineTo;
    }

    public String getOperatePressure() {
        return operatePressure;
    }

    public void setOperatePressure(String operatePressure) {
        this.operatePressure = operatePressure;
    }

    public String getOperateTemperature() {
        return operateTemperature;
    }

    public void setOperateTemperature(String operateTemperature) {
        this.operateTemperature = operateTemperature;
    }

    public String getLineLevel() {
        return lineLevel;
    }

    public void setLineLevel(String lineLevel) {
        this.lineLevel = lineLevel;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getDesignPressure() {
        return designPressure;
    }

    public void setDesignPressure(String designPressure) {
        this.designPressure = designPressure;
    }

    public String getDesignTemperature() {
        return designTemperature;
    }

    public void setDesignTemperature(String designTemperature) {
        this.designTemperature = designTemperature;
    }

    public String getKindLevel() {
        return kindLevel;
    }

    public void setKindLevel(String kindLevel) {
        this.kindLevel = kindLevel;
    }

    public String getInspectionCode() {
        return inspectionCode;
    }

    public void setInspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode;
    }

    public String getInsulationCode() {
        return insulationCode;
    }

    public void setInsulationCode(String insulationCode) {
        this.insulationCode = insulationCode;
    }

    public String getInsulationHigh() {
        return insulationHigh;
    }

    public void setInsulationHigh(String insulationHigh) {
        this.insulationHigh = insulationHigh;
    }

    public String getPaintCode() {
        return paintCode;
    }

    public void setPaintCode(String paintCode) {
        this.paintCode = paintCode;
    }

    public String getPiDiagram() {
        return piDiagram;
    }

    public void setPiDiagram(String piDiagram) {
        this.piDiagram = piDiagram;
    }

    public String getTestPressure() {
        return testPressure;
    }

    public void setTestPressure(String testPressure) {
        this.testPressure = testPressure;
    }

    public String getTestMaterial() {
        return testMaterial;
    }

    public void setTestMaterial(String testMaterial) {
        this.testMaterial = testMaterial;
    }

    public String getJacketedPipe() {
        return jacketedPipe;
    }

    public void setJacketedPipe(String jacketedPipe) {
        this.jacketedPipe = jacketedPipe;
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

        PpLineDTO ppLineDTO = (PpLineDTO) o;
        if(ppLineDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineDTO{" +
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
            ", piDiagram='" + getPiDiagram() + "'" +
            ", testPressure='" + getTestPressure() + "'" +
            ", testMaterial='" + getTestMaterial() + "'" +
            ", jacketedPipe='" + getJacketedPipe() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
