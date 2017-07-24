/**
 *  introspectedTable.getFullyQualifiedTable().getComment()
 * ProjectSpecReq.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-07-23 Created
 */
package java.request;

import java.io.Serializable;
import java.util.Date;

public class ProjectSpecReq implements Serializable {
    private Long id;

    private Long projId;

    /**
     * 规格名称
     */
    private String name;

    /**
     * 大小
     */
    private String size;

    /**
     * 场地
     */
    private String unit;

    private String remark;

    private Date createTime;

    private Integer delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project_spec
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_spec.ID
     *
     * @return the value of project_spec.ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_spec.ID
     *
     * @param id the value for project_spec.ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_spec.PROJ_ID
     *
     * @return the value of project_spec.PROJ_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getProjId() {
        return projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_spec.PROJ_ID
     *
     * @param projId the value for project_spec.PROJ_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setProjId(Long projId) {
        this.projId = projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_spec.NAME
     *
     * @return the value of project_spec.NAME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_spec.NAME
     *
     * @param name the value for project_spec.NAME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_spec.SIZE
     *
     * @return the value of project_spec.SIZE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_spec.SIZE
     *
     * @param size the value for project_spec.SIZE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_spec.UNIT
     *
     * @return the value of project_spec.UNIT
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getUnit() {
        return unit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_spec.UNIT
     *
     * @param unit the value for project_spec.UNIT
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_spec.REMARK
     *
     * @return the value of project_spec.REMARK
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_spec.REMARK
     *
     * @param remark the value for project_spec.REMARK
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_spec.CREATE_TIME
     *
     * @return the value of project_spec.CREATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_spec.CREATE_TIME
     *
     * @param createTime the value for project_spec.CREATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_spec.DEL_FLAG
     *
     * @return the value of project_spec.DEL_FLAG
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_spec.DEL_FLAG
     *
     * @param delFlag the value for project_spec.DEL_FLAG
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_spec
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
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
        ProjectSpecReq other = (ProjectSpecReq) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjId() == null ? other.getProjId() == null : this.getProjId().equals(other.getProjId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_spec
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjId() == null) ? 0 : getProjId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}