/**
 *  introspectedTable.getFullyQualifiedTable().getComment()
 * ProjectWelderReq.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-07-18 Created
 */
package java.request;

import java.io.Serializable;
import java.util.Date;

public class ProjectWelderReq implements Serializable {
    private Long id;

    private Long compId;

    private String code;

    private String name;

    private String mobille;

    private String identityCard;

    private String workTerm;

    private String unitName;

    private Date createTime;

    private Integer delFlag;

    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project_welder
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.ID
     *
     * @return the value of project_welder.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.ID
     *
     * @param id the value for project_welder.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.COMP_ID
     *
     * @return the value of project_welder.COMP_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.COMP_ID
     *
     * @param compId the value for project_welder.COMP_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCompId(Long compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.CODE
     *
     * @return the value of project_welder.CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.CODE
     *
     * @param code the value for project_welder.CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.NAME
     *
     * @return the value of project_welder.NAME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.NAME
     *
     * @param name the value for project_welder.NAME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.MOBILLE
     *
     * @return the value of project_welder.MOBILLE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getMobille() {
        return mobille;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.MOBILLE
     *
     * @param mobille the value for project_welder.MOBILLE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setMobille(String mobille) {
        this.mobille = mobille == null ? null : mobille.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.IDENTITY_CARD
     *
     * @return the value of project_welder.IDENTITY_CARD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.IDENTITY_CARD
     *
     * @param identityCard the value for project_welder.IDENTITY_CARD
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.WORK_TERM
     *
     * @return the value of project_welder.WORK_TERM
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getWorkTerm() {
        return workTerm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.WORK_TERM
     *
     * @param workTerm the value for project_welder.WORK_TERM
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setWorkTerm(String workTerm) {
        this.workTerm = workTerm == null ? null : workTerm.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.UNIT_NAME
     *
     * @return the value of project_welder.UNIT_NAME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.UNIT_NAME
     *
     * @param unitName the value for project_welder.UNIT_NAME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.CREATE_TIME
     *
     * @return the value of project_welder.CREATE_TIME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.CREATE_TIME
     *
     * @param createTime the value for project_welder.CREATE_TIME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.DEL_FLAG
     *
     * @return the value of project_welder.DEL_FLAG
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.DEL_FLAG
     *
     * @param delFlag the value for project_welder.DEL_FLAG
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_welder.REMARK
     *
     * @return the value of project_welder.REMARK
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_welder.REMARK
     *
     * @param remark the value for project_welder.REMARK
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_welder
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
        ProjectWelderReq other = (ProjectWelderReq) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompId() == null ? other.getCompId() == null : this.getCompId().equals(other.getCompId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMobille() == null ? other.getMobille() == null : this.getMobille().equals(other.getMobille()))
            && (this.getIdentityCard() == null ? other.getIdentityCard() == null : this.getIdentityCard().equals(other.getIdentityCard()))
            && (this.getWorkTerm() == null ? other.getWorkTerm() == null : this.getWorkTerm().equals(other.getWorkTerm()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_welder
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMobille() == null) ? 0 : getMobille().hashCode());
        result = prime * result + ((getIdentityCard() == null) ? 0 : getIdentityCard().hashCode());
        result = prime * result + ((getWorkTerm() == null) ? 0 : getWorkTerm().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}