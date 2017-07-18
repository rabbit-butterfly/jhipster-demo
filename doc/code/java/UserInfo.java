package java;

import java.io.Serializable;

/**
 * 公司成员表
 * 
 * @author 菠萝大象
 * @version 1.0 2017-07-18
 */
public class UserInfo implements Serializable {
    private Long id;

    /**
     * 公司ID
     */
    private Long compId;

    /**
     * 用户工号
     */
    private Long code;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 0：无效
            1：有效
     */
    private Short status;

    /**
     * 岗位@
     */
    private String jobTitle;

    /**
     * 专业@
     */
    private String major;

    private Long jhUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_info
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.ID
     *
     * @return the value of user_info.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.ID
     *
     * @param id the value for user_info.ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.COMP_ID
     *
     * @return the value of user_info.COMP_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getCompId() {
        return compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.COMP_ID
     *
     * @param compId the value for user_info.COMP_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCompId(Long compId) {
        this.compId = compId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.CODE
     *
     * @return the value of user_info.CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.CODE
     *
     * @param code the value for user_info.CODE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setCode(Long code) {
        this.code = code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.MOBILE
     *
     * @return the value of user_info.MOBILE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.MOBILE
     *
     * @param mobile the value for user_info.MOBILE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.STATUS
     *
     * @return the value of user_info.STATUS
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.STATUS
     *
     * @param status the value for user_info.STATUS
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.JOB_TITLE
     *
     * @return the value of user_info.JOB_TITLE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.JOB_TITLE
     *
     * @param jobTitle the value for user_info.JOB_TITLE
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.MAJOR
     *
     * @return the value of user_info.MAJOR
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public String getMajor() {
        return major;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.MAJOR
     *
     * @param major the value for user_info.MAJOR
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.JH_USER_ID
     *
     * @return the value of user_info.JH_USER_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public Long getJhUserId() {
        return jhUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.JH_USER_ID
     *
     * @param jhUserId the value for user_info.JH_USER_ID
     *
     * @mbggenerated Tue Jul 18 17:06:29 CST 2017
     */
    public void setJhUserId(Long jhUserId) {
        this.jhUserId = jhUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
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
        UserInfo other = (UserInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompId() == null ? other.getCompId() == null : this.getCompId().equals(other.getCompId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getJobTitle() == null ? other.getJobTitle() == null : this.getJobTitle().equals(other.getJobTitle()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getJhUserId() == null ? other.getJhUserId() == null : this.getJhUserId().equals(other.getJhUserId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
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
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getJobTitle() == null) ? 0 : getJobTitle().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getJhUserId() == null) ? 0 : getJhUserId().hashCode());
        return result;
    }
}