package java;

import java.io.Serializable;
import java.util.Date;

/**
 * 存放项目的基本信息:开始时间，结束时间，是否停工等
 * 
 * @author 菠萝大象
 * @version 1.0 2017-07-25
 */
public class Project implements Serializable {
    private Long id;

    /**
     * 项目公司ID
     */
    private Long projCompId;

    /**
     * 项目公司名称
     */
    private String projCompName;

    private String code;

    private String name;

    private String enName;

    private String supervisor;

    private String ownerContractor;

    private String totalContractor;

    private Date startDate;

    private Date endDate;

    /**
     * 0：待审核
            1：审核通过
            2：审核失败
            3：终结
     */
    private Integer status;

    private Integer delFlag;

    private String remark;

    /**
     * 扩展字段
     */
    private String extendAttr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table project
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.ID
     *
     * @return the value of project.ID
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.ID
     *
     * @param id the value for project.ID
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.PROJ_COMP_ID
     *
     * @return the value of project.PROJ_COMP_ID
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public Long getProjCompId() {
        return projCompId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.PROJ_COMP_ID
     *
     * @param projCompId the value for project.PROJ_COMP_ID
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setProjCompId(Long projCompId) {
        this.projCompId = projCompId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.PROJ_COMP_NAME
     *
     * @return the value of project.PROJ_COMP_NAME
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public String getProjCompName() {
        return projCompName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.PROJ_COMP_NAME
     *
     * @param projCompName the value for project.PROJ_COMP_NAME
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setProjCompName(String projCompName) {
        this.projCompName = projCompName == null ? null : projCompName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.CODE
     *
     * @return the value of project.CODE
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.CODE
     *
     * @param code the value for project.CODE
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.NAME
     *
     * @return the value of project.NAME
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.NAME
     *
     * @param name the value for project.NAME
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.EN_NAME
     *
     * @return the value of project.EN_NAME
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public String getEnName() {
        return enName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.EN_NAME
     *
     * @param enName the value for project.EN_NAME
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.SUPERVISOR
     *
     * @return the value of project.SUPERVISOR
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.SUPERVISOR
     *
     * @param supervisor the value for project.SUPERVISOR
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor == null ? null : supervisor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.OWNER_CONTRACTOR
     *
     * @return the value of project.OWNER_CONTRACTOR
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public String getOwnerContractor() {
        return ownerContractor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.OWNER_CONTRACTOR
     *
     * @param ownerContractor the value for project.OWNER_CONTRACTOR
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setOwnerContractor(String ownerContractor) {
        this.ownerContractor = ownerContractor == null ? null : ownerContractor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.TOTAL_CONTRACTOR
     *
     * @return the value of project.TOTAL_CONTRACTOR
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public String getTotalContractor() {
        return totalContractor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.TOTAL_CONTRACTOR
     *
     * @param totalContractor the value for project.TOTAL_CONTRACTOR
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setTotalContractor(String totalContractor) {
        this.totalContractor = totalContractor == null ? null : totalContractor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.START_DATE
     *
     * @return the value of project.START_DATE
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.START_DATE
     *
     * @param startDate the value for project.START_DATE
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.END_DATE
     *
     * @return the value of project.END_DATE
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.END_DATE
     *
     * @param endDate the value for project.END_DATE
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.STATUS
     *
     * @return the value of project.STATUS
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.STATUS
     *
     * @param status the value for project.STATUS
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.DEL_FLAG
     *
     * @return the value of project.DEL_FLAG
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.DEL_FLAG
     *
     * @param delFlag the value for project.DEL_FLAG
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.REMARK
     *
     * @return the value of project.REMARK
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.REMARK
     *
     * @param remark the value for project.REMARK
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column project.EXTEND_ATTR
     *
     * @return the value of project.EXTEND_ATTR
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public String getExtendAttr() {
        return extendAttr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column project.EXTEND_ATTR
     *
     * @param extendAttr the value for project.EXTEND_ATTR
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    public void setExtendAttr(String extendAttr) {
        this.extendAttr = extendAttr == null ? null : extendAttr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
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
        Project other = (Project) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjCompId() == null ? other.getProjCompId() == null : this.getProjCompId().equals(other.getProjCompId()))
            && (this.getProjCompName() == null ? other.getProjCompName() == null : this.getProjCompName().equals(other.getProjCompName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getSupervisor() == null ? other.getSupervisor() == null : this.getSupervisor().equals(other.getSupervisor()))
            && (this.getOwnerContractor() == null ? other.getOwnerContractor() == null : this.getOwnerContractor().equals(other.getOwnerContractor()))
            && (this.getTotalContractor() == null ? other.getTotalContractor() == null : this.getTotalContractor().equals(other.getTotalContractor()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getExtendAttr() == null ? other.getExtendAttr() == null : this.getExtendAttr().equals(other.getExtendAttr()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbggenerated Tue Jul 25 20:17:26 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjCompId() == null) ? 0 : getProjCompId().hashCode());
        result = prime * result + ((getProjCompName() == null) ? 0 : getProjCompName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getSupervisor() == null) ? 0 : getSupervisor().hashCode());
        result = prime * result + ((getOwnerContractor() == null) ? 0 : getOwnerContractor().hashCode());
        result = prime * result + ((getTotalContractor() == null) ? 0 : getTotalContractor().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getExtendAttr() == null) ? 0 : getExtendAttr().hashCode());
        return result;
    }
}