package java;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司表：存放公司的基本信息
 * 
 * @author 菠萝大象
 * @version 1.0 2017-07-23
 */
public class Company implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 公司名称
     */
    private String name;

    private String corporator;

    private String address;

    private String province;

    private String city;

    private String area;

    private String remark;

    private String mobile;

    /**
     * 0：冻结
            1：有效
     */
    private Integer status;

    /**
     * 0：有效
            1：逻辑删除
     */
    private Integer delFlag;

    private Date createTime;

    private String creator;

    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table company
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.ID
     *
     * @return the value of company.ID
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.ID
     *
     * @param id the value for company.ID
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.NAME
     *
     * @return the value of company.NAME
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.NAME
     *
     * @param name the value for company.NAME
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.CORPORATOR
     *
     * @return the value of company.CORPORATOR
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public String getCorporator() {
        return corporator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.CORPORATOR
     *
     * @param corporator the value for company.CORPORATOR
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setCorporator(String corporator) {
        this.corporator = corporator == null ? null : corporator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.ADDRESS
     *
     * @return the value of company.ADDRESS
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.ADDRESS
     *
     * @param address the value for company.ADDRESS
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.PROVINCE
     *
     * @return the value of company.PROVINCE
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.PROVINCE
     *
     * @param province the value for company.PROVINCE
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.CITY
     *
     * @return the value of company.CITY
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.CITY
     *
     * @param city the value for company.CITY
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.AREA
     *
     * @return the value of company.AREA
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.AREA
     *
     * @param area the value for company.AREA
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.REMARK
     *
     * @return the value of company.REMARK
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.REMARK
     *
     * @param remark the value for company.REMARK
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.MOBILE
     *
     * @return the value of company.MOBILE
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.MOBILE
     *
     * @param mobile the value for company.MOBILE
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.STATUS
     *
     * @return the value of company.STATUS
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.STATUS
     *
     * @param status the value for company.STATUS
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.DEL_FLAG
     *
     * @return the value of company.DEL_FLAG
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.DEL_FLAG
     *
     * @param delFlag the value for company.DEL_FLAG
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.CREATE_TIME
     *
     * @return the value of company.CREATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.CREATE_TIME
     *
     * @param createTime the value for company.CREATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.CREATOR
     *
     * @return the value of company.CREATOR
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.CREATOR
     *
     * @param creator the value for company.CREATOR
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.UPDATE_TIME
     *
     * @return the value of company.UPDATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.UPDATE_TIME
     *
     * @param updateTime the value for company.UPDATE_TIME
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
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
        Company other = (Company) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCorporator() == null ? other.getCorporator() == null : this.getCorporator().equals(other.getCorporator()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbggenerated Sun Jul 23 12:39:35 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCorporator() == null) ? 0 : getCorporator().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}