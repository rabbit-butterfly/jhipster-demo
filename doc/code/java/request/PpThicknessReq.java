/**
 *  introspectedTable.getFullyQualifiedTable().getComment()
 * PpThicknessReq.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-07-23 Created
 */
package java.request;

import java.io.Serializable;
import java.util.Date;

public class PpThicknessReq implements Serializable {
    private Long id;

    private Long compId;

    private Long projId;

    private String jsize;

    private String wallThickCode;

    private Long externalDiameter;

    private Long thickness;

    private Date createTime;

    private Integer delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_thickness
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_thickness.ID
     *
     * @return the value of pp_thickness.ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_thickness.ID
     *
     * @param id the value for pp_thickness.ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_thickness.COMP_ID
     *
     * @return the value of pp_thickness.COMP_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_thickness.COMP_ID
     *
     * @param compId the value for pp_thickness.COMP_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setCompId(Long compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_thickness.PROJ_ID
     *
     * @return the value of pp_thickness.PROJ_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getProjId() {
        return projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_thickness.PROJ_ID
     *
     * @param projId the value for pp_thickness.PROJ_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setProjId(Long projId) {
        this.projId = projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_thickness.JSIZE
     *
     * @return the value of pp_thickness.JSIZE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getJsize() {
        return jsize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_thickness.JSIZE
     *
     * @param jsize the value for pp_thickness.JSIZE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setJsize(String jsize) {
        this.jsize = jsize == null ? null : jsize.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_thickness.WALL_THICK_CODE
     *
     * @return the value of pp_thickness.WALL_THICK_CODE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getWallThickCode() {
        return wallThickCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_thickness.WALL_THICK_CODE
     *
     * @param wallThickCode the value for pp_thickness.WALL_THICK_CODE
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setWallThickCode(String wallThickCode) {
        this.wallThickCode = wallThickCode == null ? null : wallThickCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_thickness.EXTERNAL_DIAMETER
     *
     * @return the value of pp_thickness.EXTERNAL_DIAMETER
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getExternalDiameter() {
        return externalDiameter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_thickness.EXTERNAL_DIAMETER
     *
     * @param externalDiameter the value for pp_thickness.EXTERNAL_DIAMETER
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setExternalDiameter(Long externalDiameter) {
        this.externalDiameter = externalDiameter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_thickness.THICKNESS
     *
     * @return the value of pp_thickness.THICKNESS
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getThickness() {
        return thickness;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_thickness.THICKNESS
     *
     * @param thickness the value for pp_thickness.THICKNESS
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setThickness(Long thickness) {
        this.thickness = thickness;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_thickness.CREATE_TIME
     *
     * @return the value of pp_thickness.CREATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_thickness.CREATE_TIME
     *
     * @param createTime the value for pp_thickness.CREATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_thickness.DEL_FLAG
     *
     * @return the value of pp_thickness.DEL_FLAG
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_thickness.DEL_FLAG
     *
     * @param delFlag the value for pp_thickness.DEL_FLAG
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_thickness
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
        PpThicknessReq other = (PpThicknessReq) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompId() == null ? other.getCompId() == null : this.getCompId().equals(other.getCompId()))
            && (this.getProjId() == null ? other.getProjId() == null : this.getProjId().equals(other.getProjId()))
            && (this.getJsize() == null ? other.getJsize() == null : this.getJsize().equals(other.getJsize()))
            && (this.getWallThickCode() == null ? other.getWallThickCode() == null : this.getWallThickCode().equals(other.getWallThickCode()))
            && (this.getExternalDiameter() == null ? other.getExternalDiameter() == null : this.getExternalDiameter().equals(other.getExternalDiameter()))
            && (this.getThickness() == null ? other.getThickness() == null : this.getThickness().equals(other.getThickness()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_thickness
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());
        result = prime * result + ((getProjId() == null) ? 0 : getProjId().hashCode());
        result = prime * result + ((getJsize() == null) ? 0 : getJsize().hashCode());
        result = prime * result + ((getWallThickCode() == null) ? 0 : getWallThickCode().hashCode());
        result = prime * result + ((getExternalDiameter() == null) ? 0 : getExternalDiameter().hashCode());
        result = prime * result + ((getThickness() == null) ? 0 : getThickness().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}