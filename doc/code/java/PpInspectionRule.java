package java;

import java.io.Serializable;
import java.util.Date;

/**
 * 抽检规则设置表
 * 
 * @author 菠萝大象
 * @version 1.0 2017-07-18
 */
public class PpInspectionRule implements Serializable {
    private Long id;

    private Long compId;

    private Long projId;

    private String material;

    private String ppClass;

    private String jacketedPipe;

    /**
     * @ 来源抽检比例表 中的代号
     */
    private String inspectionCode;

    private Date createTime;

    private Integer delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_inspection_rule
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_rule.ID
     *
     * @return the value of pp_inspection_rule.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_rule.ID
     *
     * @param id the value for pp_inspection_rule.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_rule.COMP_ID
     *
     * @return the value of pp_inspection_rule.COMP_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_rule.COMP_ID
     *
     * @param compId the value for pp_inspection_rule.COMP_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCompId(Long compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_rule.PROJ_ID
     *
     * @return the value of pp_inspection_rule.PROJ_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getProjId() {
        return projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_rule.PROJ_ID
     *
     * @param projId the value for pp_inspection_rule.PROJ_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setProjId(Long projId) {
        this.projId = projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_rule.MATERIAL
     *
     * @return the value of pp_inspection_rule.MATERIAL
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getMaterial() {
        return material;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_rule.MATERIAL
     *
     * @param material the value for pp_inspection_rule.MATERIAL
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_rule.PP_CLASS
     *
     * @return the value of pp_inspection_rule.PP_CLASS
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getPpClass() {
        return ppClass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_rule.PP_CLASS
     *
     * @param ppClass the value for pp_inspection_rule.PP_CLASS
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setPpClass(String ppClass) {
        this.ppClass = ppClass == null ? null : ppClass.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_rule.JACKETED_PIPE
     *
     * @return the value of pp_inspection_rule.JACKETED_PIPE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getJacketedPipe() {
        return jacketedPipe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_rule.JACKETED_PIPE
     *
     * @param jacketedPipe the value for pp_inspection_rule.JACKETED_PIPE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setJacketedPipe(String jacketedPipe) {
        this.jacketedPipe = jacketedPipe == null ? null : jacketedPipe.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_rule.INSPECTION_CODE
     *
     * @return the value of pp_inspection_rule.INSPECTION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getInspectionCode() {
        return inspectionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_rule.INSPECTION_CODE
     *
     * @param inspectionCode the value for pp_inspection_rule.INSPECTION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setInspectionCode(String inspectionCode) {
        this.inspectionCode = inspectionCode == null ? null : inspectionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_rule.CREATE_TIME
     *
     * @return the value of pp_inspection_rule.CREATE_TIME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_rule.CREATE_TIME
     *
     * @param createTime the value for pp_inspection_rule.CREATE_TIME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_inspection_rule.DEL_FLAG
     *
     * @return the value of pp_inspection_rule.DEL_FLAG
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_inspection_rule.DEL_FLAG
     *
     * @param delFlag the value for pp_inspection_rule.DEL_FLAG
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
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
        PpInspectionRule other = (PpInspectionRule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompId() == null ? other.getCompId() == null : this.getCompId().equals(other.getCompId()))
            && (this.getProjId() == null ? other.getProjId() == null : this.getProjId().equals(other.getProjId()))
            && (this.getMaterial() == null ? other.getMaterial() == null : this.getMaterial().equals(other.getMaterial()))
            && (this.getPpClass() == null ? other.getPpClass() == null : this.getPpClass().equals(other.getPpClass()))
            && (this.getJacketedPipe() == null ? other.getJacketedPipe() == null : this.getJacketedPipe().equals(other.getJacketedPipe()))
            && (this.getInspectionCode() == null ? other.getInspectionCode() == null : this.getInspectionCode().equals(other.getInspectionCode()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_inspection_rule
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
        result = prime * result + ((getMaterial() == null) ? 0 : getMaterial().hashCode());
        result = prime * result + ((getPpClass() == null) ? 0 : getPpClass().hashCode());
        result = prime * result + ((getJacketedPipe() == null) ? 0 : getJacketedPipe().hashCode());
        result = prime * result + ((getInspectionCode() == null) ? 0 : getInspectionCode().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}