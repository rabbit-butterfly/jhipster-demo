package com.rd.pcms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * 公司表：存放公司的基本信息
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:35 CST 2017
 * table:company
 */
@ApiModel(description = "公司表：存放公司的基本信息 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:35 CST 2017 table:company")
@Entity
@Table(name = "company")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@EntityListeners(AuditingEntityListener.class)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司名称
     */
    @NotNull
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "公司名称", required = true)
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * CORPORATOR
     */
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "CORPORATOR")
    @Column(name = "corporator", length = 10)
    private String corporator;

    /**
     * ADDRESS
     */
    @NotNull
    @Size(min = 0, max = 100)
    @ApiModelProperty(value = "ADDRESS", required = true)
    @Column(name = "address", length = 100, nullable = false)
    private String address;

    /**
     * PROVINCE
     */
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "PROVINCE")
    @Column(name = "province", length = 10)
    private String province;

    /**
     * CITY
     */
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "CITY")
    @Column(name = "city", length = 10)
    private String city;

    /**
     * AREA
     */
    @Size(min = 0, max = 10)
    @ApiModelProperty(value = "AREA")
    @Column(name = "area", length = 10)
    private String area;

    /**
     * REMARK
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "REMARK")
    @Column(name = "remark", length = 500)
    private String remark;

    /**
     * MOBILE
     */
    @NotNull
    @Size(min = 0, max = 11)
    @ApiModelProperty(value = "MOBILE", required = true)
    @Column(name = "mobile", length = 11, nullable = false)
    private String mobile;

    /**
     * 0：冻结 1：有效
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "0：冻结 1：有效")
    @Column(name = "status")
    private Integer status;

    /**
     * 0：有效 1：逻辑删除
     */
    @ApiModelProperty(value = "0：有效 1：逻辑删除")
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * CREATE_TIME
     */
    @ApiModelProperty(value = "created_date")
    @Column(name = "created_date")
    //@Type(type = "com.javahonk.model.LocalDateHibernateUserType")
    //@Temporal(TemporalType.DATE)
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Transient
    private Instant createTime;

    /**
     * CREATOR
     */
    @ApiModelProperty(value = "created_by")
    @CreatedBy
    @NotNull
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    @JsonIgnore
    private String creator;

    /**
     * UPDATE_TIME
     */
    @ApiModelProperty(value = "last_modified_date")
    //@Column(name = "update_time", nullable = false)
    @Transient
    private Instant updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Company name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorporator() {
        return corporator;
    }

    public Company corporator(String corporator) {
        this.corporator = corporator;
        return this;
    }

    public void setCorporator(String corporator) {
        this.corporator = corporator;
    }

    public String getAddress() {
        return address;
    }

    public Company address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public Company province(String province) {
        this.province = province;
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public Company city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public Company area(String area) {
        this.area = area;
        return this;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRemark() {
        return remark;
    }

    public Company remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMobile() {
        return mobile;
    }

    public Company mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public Company status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Company delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public Company createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public Company creator(String creator) {
        this.creator = creator;
        return this;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public Company updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Company company = (Company) o;
        if (company.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), company.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Company{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", corporator='" + getCorporator() + "'" +
            ", address='" + getAddress() + "'" +
            ", province='" + getProvince() + "'" +
            ", city='" + getCity() + "'" +
            ", area='" + getArea() + "'" +
            ", remark='" + getRemark() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", status='" + getStatus() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", creator='" + getCreator() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
