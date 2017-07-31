package com.rd.pcms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * 数据权限设置
 * @auther:renntrabbit@foxmail.com
 * @date:Thu Jul 27 10:58:26 CST 2017
 * table:jhi_biz_auth
 */
@ApiModel(description = "数据权限设置 @auther:renntrabbit@foxmail.com @date:Thu Jul 27 10:58:26 CST 2017 table:jhi_biz_auth")
@Entity
@Table(name = "jhi_biz_auth")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BizAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务类别
     */
    @NotNull
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "业务类别", required = true)
    @Column(name = "biz_name", length = 16, nullable = false)
    private String bizName;

    /**
     * 角色编码
     */
    @NotNull
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "角色编码", required = true)
    @Column(name = "role_code", length = 16, nullable = false)
    private String roleCode;

    /**
     * 最小限码
     */
    @NotNull
    @Min(value = 0)
    @Max(value = 19)
    @ApiModelProperty(value = "最小限码", required = true)
    @Column(name = "min_auth_code", nullable = false)
    private Long minAuthCode;

    /**
     * 最大权限权
     */
    @Min(value = 0)
    @Max(value = 19)
    @ApiModelProperty(value = "最大权限权")
    @Column(name = "max_auth_code")
    private Long maxAuthCode;

    /**
     * 特殊权限码
     */
    @Size(min = 0, max = 1024)
    @ApiModelProperty(value = "特殊权限码")
    @Column(name = "auth_code", length = 1024)
    private String authCode;

    /**
     * 权限类别@0:范围1:特殊权限包含1:特殊权限排除
     */
    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    @ApiModelProperty(value = "权限类别@0:范围1:特殊权限包含1:特殊权限排除", required = true)
    @Column(name = "auth_category", nullable = false)
    private Integer authCategory;

    /**
     * 创建人
     */
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "创建人")
    @Column(name = "created_by", length = 16)
    private String createdBy;

    /**
     * 创建时间
     */
    @NotNull
    @ApiModelProperty(value = "创建时间", required = true)
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    /**
     * 修改人
     */
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "修改人")
    @Column(name = "last_modified_by", length = 16)
    private String lastModifiedBy;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;

    //@OneToOne
    @NotNull
    //@JoinColumn(name="biz_name",referencedColumnName="biz_name",unique = true)
    @OneToOne(cascade = CascadeType.ALL,targetEntity = Biz.class)
    @JoinColumn(name="biz_name", referencedColumnName="biz_name", insertable=false,updatable =false)
    private Biz biz;

    @OneToOne(cascade = CascadeType.ALL,targetEntity = Role.class)
    @JsonIgnore
    @NotNull
    @JoinColumn(name="role_code",referencedColumnName="code",insertable=false,updatable =false)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizName() {
        return bizName;
    }

    public BizAuth bizName(String bizName) {
        this.bizName = bizName;
        return this;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public BizAuth roleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getMinAuthCode() {
        return minAuthCode;
    }

    public BizAuth minAuthCode(Long minAuthCode) {
        this.minAuthCode = minAuthCode;
        return this;
    }

    public void setMinAuthCode(Long minAuthCode) {
        this.minAuthCode = minAuthCode;
    }

    public Long getMaxAuthCode() {
        return maxAuthCode;
    }

    public BizAuth maxAuthCode(Long maxAuthCode) {
        this.maxAuthCode = maxAuthCode;
        return this;
    }

    public void setMaxAuthCode(Long maxAuthCode) {
        this.maxAuthCode = maxAuthCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public BizAuth authCode(String authCode) {
        this.authCode = authCode;
        return this;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Integer getAuthCategory() {
        return authCategory;
    }

    public BizAuth authCategory(Integer authCategory) {
        this.authCategory = authCategory;
        return this;
    }

    public void setAuthCategory(Integer authCategory) {
        this.authCategory = authCategory;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public BizAuth createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public BizAuth createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public BizAuth lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public BizAuth lastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Biz getBiz() {
        return biz;
    }

    public BizAuth biz(Biz biz) {
        this.biz = biz;
        return this;
    }

    public void setBiz(Biz biz) {
        this.biz = biz;
    }

    public Role getRole() {
        return role;
    }

    public BizAuth role(Role role) {
        this.role = role;
        return this;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BizAuth bizAuth = (BizAuth) o;
        if (bizAuth.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bizAuth.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BizAuth{" +
            "id=" + getId() +
            ", bizName='" + getBizName() + "'" +
            ", roleCode='" + getRoleCode() + "'" +
            ", minAuthCode='" + getMinAuthCode() + "'" +
            ", maxAuthCode='" + getMaxAuthCode() + "'" +
            ", authCode='" + getAuthCode() + "'" +
            ", authCategory='" + getAuthCategory() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            "}";
    }
}
