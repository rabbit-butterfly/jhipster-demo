package com.rd.pcms.domain;

import com.jumore.zhxf.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 公司成员表
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 14:33:07 CST 2017
 * table:user_info
 */
@ApiModel(description = "公司成员表 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 14:33:07 CST 2017 table:user_info")
@Entity
@Table(name = "user_info")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司ID
     */
    @NotNull
    @Min(value = 0)
    @Max(value = 19)
    @ApiModelProperty(value = "公司ID", required = true)
    @Column(name = "comp_id", nullable = false)
    private Long compId;

    /**
     * 用户工号
     */
    @Min(value = 0)
    @Max(value = 19)
    @ApiModelProperty(value = "用户工号")
    @Column(name = "code")
    private Long code;

    /**
     * 手机号码
     */
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "手机号码")
    @Column(name = "mobile", length = 16)
    private String mobile;

    /**
     * 0：无效 1：有效
     */
    @Size(min = 0, max = 5)
    @ApiModelProperty(value = "0：无效 1：有效")
    @Column(name = "status", length = 5)
    private String status;

    /**
     * 岗位@
     */
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "岗位@")
    @Column(name = "job_title", length = 16)
    private String jobTitle;

    /**
     * 专业@
     */
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "专业@")
    @Column(name = "major", length = 16)
    private String major;

    /**
     * JH_USER_ID
     */
    @NotNull
    @Min(value = 0)
    @Max(value = 19)
    @ApiModelProperty(value = "JH_USER_ID", required = true)
    @Column(name = "jh_user_id", nullable = false)
    private Long jhUserId;

    @OneToOne(optional = false)
    @JoinColumn(unique = true)
    private User user;

    @ManyToOne(optional = false)
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompId() {
        return compId;
    }

    public UserInfo compId(Long compId) {
        this.compId = compId;
        return this;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getCode() {
        return code;
    }

    public UserInfo code(Long code) {
        this.code = code;
        return this;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public UserInfo mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public UserInfo status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public UserInfo jobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getMajor() {
        return major;
    }

    public UserInfo major(String major) {
        this.major = major;
        return this;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Long getJhUserId() {
        return jhUserId;
    }

    public UserInfo jhUserId(Long jhUserId) {
        this.jhUserId = jhUserId;
        return this;
    }

    public void setJhUserId(Long jhUserId) {
        this.jhUserId = jhUserId;
    }

    public User getUser() {
        return user;
    }

    public UserInfo user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public UserInfo company(Company company) {
        this.company = company;
        return this;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInfo userInfo = (UserInfo) o;
        if (userInfo.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userInfo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", code='" + getCode() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", status='" + getStatus() + "'" +
            ", jobTitle='" + getJobTitle() + "'" +
            ", major='" + getMajor() + "'" +
            ", jhUserId='" + getJhUserId() + "'" +
            "}";
    }
}
