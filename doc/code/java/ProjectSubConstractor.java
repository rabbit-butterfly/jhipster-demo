package java;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目分包商基本信息表
 * 
 * @author 菠萝大象
 * @version 1.0 2017-07-23
 */
public class ProjectSubConstractor implements Serializable {
    private Long id;

    private Long projId;

    private String name;

    private String remark;

    private Date createTime;

    private Integer delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project_sub_constractor
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_sub_constractor.ID
     *
     * @return the value of project_sub_constractor.ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_sub_constractor.ID
     *
     * @param id the value for project_sub_constractor.ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_sub_constractor.PROJ_ID
     *
     * @return the value of project_sub_constractor.PROJ_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Long getProjId() {
        return projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_sub_constractor.PROJ_ID
     *
     * @param projId the value for project_sub_constractor.PROJ_ID
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setProjId(Long projId) {
        this.projId = projId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_sub_constractor.NAME
     *
     * @return the value of project_sub_constractor.NAME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_sub_constractor.NAME
     *
     * @param name the value for project_sub_constractor.NAME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_sub_constractor.REMARK
     *
     * @return the value of project_sub_constractor.REMARK
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_sub_constractor.REMARK
     *
     * @param remark the value for project_sub_constractor.REMARK
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_sub_constractor.CREATE_TIME
     *
     * @return the value of project_sub_constractor.CREATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_sub_constractor.CREATE_TIME
     *
     * @param createTime the value for project_sub_constractor.CREATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project_sub_constractor.DEL_FLAG
     *
     * @return the value of project_sub_constractor.DEL_FLAG
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project_sub_constractor.DEL_FLAG
     *
     * @param delFlag the value for project_sub_constractor.DEL_FLAG
     *
     * @mbggenerated Sun Jul 23 12:39:36 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_sub_constractor
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
        ProjectSubConstractor other = (ProjectSubConstractor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjId() == null ? other.getProjId() == null : this.getProjId().equals(other.getProjId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project_sub_constractor
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
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}