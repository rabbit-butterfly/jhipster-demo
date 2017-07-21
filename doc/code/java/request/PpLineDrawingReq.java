/**
 *  introspectedTable.getFullyQualifiedTable().getComment()
 * PpLineDrawingReq.java
 * Copyright(C) 2015-2015 xxxxxx公司
 * All rights reserved.
 * -----------------------------------------------
 * 2017-07-18 Created
 */
package java.request;

import java.io.Serializable;
import java.util.Date;

public class PpLineDrawingReq implements Serializable {
    private Long id;

    private Long pipeId;

    private Integer pageCode;

    private String versionCode;

    private String alterationCode;

    private String name;

    private String filePath;

    private String remark;

    private Date createTime;

    private Integer delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pp_line_drawing
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_drawing.ID
     *
     * @return the value of pp_line_drawing.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_drawing.ID
     *
     * @param id the value for pp_line_drawing.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_drawing.PIPE_ID
     *
     * @return the value of pp_line_drawing.PIPE_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getPipeId() {
        return pipeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_drawing.PIPE_ID
     *
     * @param pipeId the value for pp_line_drawing.PIPE_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setPipeId(Long pipeId) {
        this.pipeId = pipeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_drawing.PAGE_CODE
     *
     * @return the value of pp_line_drawing.PAGE_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Integer getPageCode() {
        return pageCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_drawing.PAGE_CODE
     *
     * @param pageCode the value for pp_line_drawing.PAGE_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setPageCode(Integer pageCode) {
        this.pageCode = pageCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_drawing.VERSION_CODE
     *
     * @return the value of pp_line_drawing.VERSION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getVersionCode() {
        return versionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_drawing.VERSION_CODE
     *
     * @param versionCode the value for pp_line_drawing.VERSION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode == null ? null : versionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_drawing.ALTERATION_CODE
     *
     * @return the value of pp_line_drawing.ALTERATION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getAlterationCode() {
        return alterationCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_drawing.ALTERATION_CODE
     *
     * @param alterationCode the value for pp_line_drawing.ALTERATION_CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setAlterationCode(String alterationCode) {
        this.alterationCode = alterationCode == null ? null : alterationCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_drawing.NAME
     *
     * @return the value of pp_line_drawing.NAME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_drawing.NAME
     *
     * @param name the value for pp_line_drawing.NAME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_drawing.FILE_PATH
     *
     * @return the value of pp_line_drawing.FILE_PATH
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_drawing.FILE_PATH
     *
     * @param filePath the value for pp_line_drawing.FILE_PATH
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_drawing.REMARK
     *
     * @return the value of pp_line_drawing.REMARK
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_drawing.REMARK
     *
     * @param remark the value for pp_line_drawing.REMARK
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_drawing.CREATE_TIME
     *
     * @return the value of pp_line_drawing.CREATE_TIME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_drawing.CREATE_TIME
     *
     * @param createTime the value for pp_line_drawing.CREATE_TIME
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pp_line_drawing.DEL_FLAG
     *
     * @return the value of pp_line_drawing.DEL_FLAG
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pp_line_drawing.DEL_FLAG
     *
     * @param delFlag the value for pp_line_drawing.DEL_FLAG
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_drawing
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
        PpLineDrawingReq other = (PpLineDrawingReq) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPipeId() == null ? other.getPipeId() == null : this.getPipeId().equals(other.getPipeId()))
            && (this.getPageCode() == null ? other.getPageCode() == null : this.getPageCode().equals(other.getPageCode()))
            && (this.getVersionCode() == null ? other.getVersionCode() == null : this.getVersionCode().equals(other.getVersionCode()))
            && (this.getAlterationCode() == null ? other.getAlterationCode() == null : this.getAlterationCode().equals(other.getAlterationCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pp_line_drawing
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPipeId() == null) ? 0 : getPipeId().hashCode());
        result = prime * result + ((getPageCode() == null) ? 0 : getPageCode().hashCode());
        result = prime * result + ((getVersionCode() == null) ? 0 : getVersionCode().hashCode());
        result = prime * result + ((getAlterationCode() == null) ? 0 : getAlterationCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}