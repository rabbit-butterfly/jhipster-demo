package java;

import java.io.Serializable;
import java.util.Date;

/**
 * 管道特性表
 * 
 * @author 菠萝大象
 * @version 1.0 2017-07-18
 */
public class PpLine implements Serializable {
    private Long id;

    /**
     * comp_ID
     */
    private Long compId;

    private Long projId;

    private Long areaId;

    private String lineNum;

    private String lineVersion;

    private String size;

    private String serv;

    /**
     * @
     */
    private String classSpec;

    private String lineFrom;

    private String lineTo;

    private String operatePressure;

    private String operateTemperature;

    private String lineLevel;

    private String lineCode;

    private String designPressure;

    private String designTemperature;

    private String kindLevel;

    private String inspectionCode;

    private String insulationCode;

    private String insulationHigh;

    private String paintCode;

    private String pIDiagram;

    private String testPressure;

    private String testMaterial;

    private String jacketedPipe;

    private String remark;

    private Date createTime;

    private Integer delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_line
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.ID
     *
     * @return the value of pp_line.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.ID
     *
     * @param id the value for pp_line.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.COMP_ID
     *
     * @return the value of pp_line.COMP_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.COMP_ID
     *
     * @param compId the value for pp_line.COMP_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCompId(Long compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.PROJ_ID
     *
     * @return the value of pp_line.PROJ_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getProjId() {
        return projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.PROJ_ID
     *
     * @param projId the value for pp_line.PROJ_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setProjId(Long projId) {
        this.projId = projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.AREA_ID
     *
     * @return the value of pp_line.AREA_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.AREA_ID
     *
     * @param areaId the value for pp_line.AREA_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.LINE_NUM
     *
     * @return the value of pp_line.LINE_NUM
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getLineNum() {
        return lineNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.LINE_NUM
     *
     * @param lineNum the value for pp_line.LINE_NUM
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setLineNum(String lineNum) {
        this.lineNum = lineNum == null ? null : lineNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.LINE_VERSION
     *
     * @return the value of pp_line.LINE_VERSION
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getLineVersion() {
        return lineVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.LINE_VERSION
     *
     * @param lineVersion the value for pp_line.LINE_VERSION
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setLineVersion(String lineVersion) {
        this.lineVersion = lineVersion == null ? null : lineVersion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.SIZE
     *
     * @return the value of pp_line.SIZE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.SIZE
     *
     * @param size the value for pp_line.SIZE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.SERV
     *
     * @return the value of pp_line.SERV
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getServ() {
        return serv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.SERV
     *
     * @param serv the value for pp_line.SERV
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setServ(String serv) {
        this.serv = serv == null ? null : serv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.CLASS_SPEC
     *
     * @return the value of pp_line.CLASS_SPEC
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getClassSpec() {
        return classSpec;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.CLASS_SPEC
     *
     * @param classSpec the value for pp_line.CLASS_SPEC
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setClassSpec(String classSpec) {
        this.classSpec = classSpec == null ? null : classSpec.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.LINE_FROM
     *
     * @return the value of pp_line.LINE_FROM
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getLineFrom() {
        return lineFrom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.LINE_FROM
     *
     * @param lineFrom the value for pp_line.LINE_FROM
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setLineFrom(String lineFrom) {
        this.lineFrom = lineFrom == null ? null : lineFrom.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.LINE_TO
     *
     * @return the value of pp_line.LINE_TO
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getLineTo() {
        return lineTo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.LINE_TO
     *
     * @param lineTo the value for pp_line.LINE_TO
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setLineTo(String lineTo) {
        this.lineTo = lineTo == null ? null : lineTo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.OPERATE_PRESSURE
     *
     * @return the value of pp_line.OPERATE_PRESSURE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getOperatePressure() {
        return operatePressure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.OPERATE_PRESSURE
     *
     * @param operatePressure the value for pp_line.OPERATE_PRESSURE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setOperatePressure(String operatePressure) {
        this.operatePressure = operatePressure == null ? null : operatePressure.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.OPERATE_TEMPERATURE
     *
     * @return the value of pp_line.OPERATE_TEMPERATURE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getOperateTemperature() {
        return operateTemperature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.OPERATE_TEMPERATURE
     *
     * @param operateTemperature the value for pp_line.OPERATE_TEMPERATURE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setOperateTemperature(String operateTemperature) {
        this.operateTemperature = operateTemperature == null ? null : operateTemperature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.LINE_LEVEL
     *
     * @return the value of pp_line.LINE_LEVEL
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getLineLevel() {
        return lineLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.LINE_LEVEL
     *
     * @param lineLevel the value for pp_line.LINE_LEVEL
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setLineLevel(String lineLevel) {
        this.lineLevel = lineLevel == null ? null : lineLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.LINE_CODE
     *
     * @return the value of pp_line.LINE_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getLineCode() {
        return lineCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.LINE_CODE
     *
     * @param lineCode the value for pp_line.LINE_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setLineCode(String lineCode) {
        this.lineCode = lineCode == null ? null : lineCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.DESIGN_PRESSURE
     *
     * @return the value of pp_line.DESIGN_PRESSURE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getDesignPressure() {
        return designPressure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.DESIGN_PRESSURE
     *
     * @param designPressure the value for pp_line.DESIGN_PRESSURE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setDesignPressure(String designPressure) {
        this.designPressure = designPressure == null ? null : designPressure.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.DESIGN_TEMPERATURE
     *
     * @return the value of pp_line.DESIGN_TEMPERATURE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getDesignTemperature() {
        return designTemperature;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.DESIGN_TEMPERATURE
     *
     * @param designTemperature the value for pp_line.DESIGN_TEMPERATURE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setDesignTemperature(String designTemperature) {
        this.designTemperature = designTemperature == null ? null : designTemperature.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.KIND_LEVEL
     *
     * @return the value of pp_line.KIND_LEVEL
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getKindLevel() {
        return kindLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.KIND_LEVEL
     *
     * @param kindLevel the value for pp_line.KIND_LEVEL
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setKindLevel(String kindLevel) {
        this.kindLevel = kindLevel == null ? null : kindLevel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.INSPECTION_CODE
     *
     * @return the value of pp_line.INSPECTION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getInspectionCode() {
        return inspectionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.INSPECTION_CODE
     *
     * @param inspectionCode the value for pp_line.INSPECTION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setInspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode == null ? null : inspectionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.INSULATION_CODE
     *
     * @return the value of pp_line.INSULATION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getInsulationCode() {
        return insulationCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.INSULATION_CODE
     *
     * @param insulationCode the value for pp_line.INSULATION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setInsulationCode(String insulationCode) {
        this.insulationCode = insulationCode == null ? null : insulationCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.INSULATION_HIGH
     *
     * @return the value of pp_line.INSULATION_HIGH
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getInsulationHigh() {
        return insulationHigh;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.INSULATION_HIGH
     *
     * @param insulationHigh the value for pp_line.INSULATION_HIGH
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setInsulationHigh(String insulationHigh) {
        this.insulationHigh = insulationHigh == null ? null : insulationHigh.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.PAINT_CODE
     *
     * @return the value of pp_line.PAINT_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getPaintCode() {
        return paintCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.PAINT_CODE
     *
     * @param paintCode the value for pp_line.PAINT_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setPaintCode(String paintCode) {
        this.paintCode = paintCode == null ? null : paintCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.P_I_DIAGRAM
     *
     * @return the value of pp_line.P_I_DIAGRAM
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getpIDiagram() {
        return pIDiagram;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.P_I_DIAGRAM
     *
     * @param pIDiagram the value for pp_line.P_I_DIAGRAM
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setpIDiagram(String pIDiagram) {
        this.pIDiagram = pIDiagram == null ? null : pIDiagram.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.TEST_PRESSURE
     *
     * @return the value of pp_line.TEST_PRESSURE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getTestPressure() {
        return testPressure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.TEST_PRESSURE
     *
     * @param testPressure the value for pp_line.TEST_PRESSURE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setTestPressure(String testPressure) {
        this.testPressure = testPressure == null ? null : testPressure.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.TEST_MATERIAL
     *
     * @return the value of pp_line.TEST_MATERIAL
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getTestMaterial() {
        return testMaterial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.TEST_MATERIAL
     *
     * @param testMaterial the value for pp_line.TEST_MATERIAL
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setTestMaterial(String testMaterial) {
        this.testMaterial = testMaterial == null ? null : testMaterial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.JACKETED_PIPE
     *
     * @return the value of pp_line.JACKETED_PIPE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getJacketedPipe() {
        return jacketedPipe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.JACKETED_PIPE
     *
     * @param jacketedPipe the value for pp_line.JACKETED_PIPE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setJacketedPipe(String jacketedPipe) {
        this.jacketedPipe = jacketedPipe == null ? null : jacketedPipe.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.REMARK
     *
     * @return the value of pp_line.REMARK
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.REMARK
     *
     * @param remark the value for pp_line.REMARK
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.CREATE_TIME
     *
     * @return the value of pp_line.CREATE_TIME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.CREATE_TIME
     *
     * @param createTime the value for pp_line.CREATE_TIME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line.DEL_FLAG
     *
     * @return the value of pp_line.DEL_FLAG
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line.DEL_FLAG
     *
     * @param delFlag the value for pp_line.DEL_FLAG
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PpLine other = (PpLine) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompId() == null ? other.getCompId() == null : this.getCompId().equals(other.getCompId()))
            && (this.getProjId() == null ? other.getProjId() == null : this.getProjId().equals(other.getProjId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getLineNum() == null ? other.getLineNum() == null : this.getLineNum().equals(other.getLineNum()))
            && (this.getLineVersion() == null ? other.getLineVersion() == null : this.getLineVersion().equals(other.getLineVersion()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getServ() == null ? other.getServ() == null : this.getServ().equals(other.getServ()))
            && (this.getClassSpec() == null ? other.getClassSpec() == null : this.getClassSpec().equals(other.getClassSpec()))
            && (this.getLineFrom() == null ? other.getLineFrom() == null : this.getLineFrom().equals(other.getLineFrom()))
            && (this.getLineTo() == null ? other.getLineTo() == null : this.getLineTo().equals(other.getLineTo()))
            && (this.getOperatePressure() == null ? other.getOperatePressure() == null : this.getOperatePressure().equals(other.getOperatePressure()))
            && (this.getOperateTemperature() == null ? other.getOperateTemperature() == null : this.getOperateTemperature().equals(other.getOperateTemperature()))
            && (this.getLineLevel() == null ? other.getLineLevel() == null : this.getLineLevel().equals(other.getLineLevel()))
            && (this.getLineCode() == null ? other.getLineCode() == null : this.getLineCode().equals(other.getLineCode()))
            && (this.getDesignPressure() == null ? other.getDesignPressure() == null : this.getDesignPressure().equals(other.getDesignPressure()))
            && (this.getDesignTemperature() == null ? other.getDesignTemperature() == null : this.getDesignTemperature().equals(other.getDesignTemperature()))
            && (this.getKindLevel() == null ? other.getKindLevel() == null : this.getKindLevel().equals(other.getKindLevel()))
            && (this.getInspectionCode() == null ? other.getInspectionCode() == null : this.getInspectionCode().equals(other.getInspectionCode()))
            && (this.getInsulationCode() == null ? other.getInsulationCode() == null : this.getInsulationCode().equals(other.getInsulationCode()))
            && (this.getInsulationHigh() == null ? other.getInsulationHigh() == null : this.getInsulationHigh().equals(other.getInsulationHigh()))
            && (this.getPaintCode() == null ? other.getPaintCode() == null : this.getPaintCode().equals(other.getPaintCode()))
            && (this.getpIDiagram() == null ? other.getpIDiagram() == null : this.getpIDiagram().equals(other.getpIDiagram()))
            && (this.getTestPressure() == null ? other.getTestPressure() == null : this.getTestPressure().equals(other.getTestPressure()))
            && (this.getTestMaterial() == null ? other.getTestMaterial() == null : this.getTestMaterial().equals(other.getTestMaterial()))
            && (this.getJacketedPipe() == null ? other.getJacketedPipe() == null : this.getJacketedPipe().equals(other.getJacketedPipe()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());
        result = prime * result + ((getProjId() == null) ? 0 : getProjId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getLineNum() == null) ? 0 : getLineNum().hashCode());
        result = prime * result + ((getLineVersion() == null) ? 0 : getLineVersion().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getServ() == null) ? 0 : getServ().hashCode());
        result = prime * result + ((getClassSpec() == null) ? 0 : getClassSpec().hashCode());
        result = prime * result + ((getLineFrom() == null) ? 0 : getLineFrom().hashCode());
        result = prime * result + ((getLineTo() == null) ? 0 : getLineTo().hashCode());
        result = prime * result + ((getOperatePressure() == null) ? 0 : getOperatePressure().hashCode());
        result = prime * result + ((getOperateTemperature() == null) ? 0 : getOperateTemperature().hashCode());
        result = prime * result + ((getLineLevel() == null) ? 0 : getLineLevel().hashCode());
        result = prime * result + ((getLineCode() == null) ? 0 : getLineCode().hashCode());
        result = prime * result + ((getDesignPressure() == null) ? 0 : getDesignPressure().hashCode());
        result = prime * result + ((getDesignTemperature() == null) ? 0 : getDesignTemperature().hashCode());
        result = prime * result + ((getKindLevel() == null) ? 0 : getKindLevel().hashCode());
        result = prime * result + ((getInspectionCode() == null) ? 0 : getInspectionCode().hashCode());
        result = prime * result + ((getInsulationCode() == null) ? 0 : getInsulationCode().hashCode());
        result = prime * result + ((getInsulationHigh() == null) ? 0 : getInsulationHigh().hashCode());
        result = prime * result + ((getPaintCode() == null) ? 0 : getPaintCode().hashCode());
        result = prime * result + ((getpIDiagram() == null) ? 0 : getpIDiagram().hashCode());
        result = prime * result + ((getTestPressure() == null) ? 0 : getTestPressure().hashCode());
        result = prime * result + ((getTestMaterial() == null) ? 0 : getTestMaterial().hashCode());
        result = prime * result + ((getJacketedPipe() == null) ? 0 : getJacketedPipe().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}