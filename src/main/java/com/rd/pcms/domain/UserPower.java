package com.rd.pcms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 用户菜单权限
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:user_power
 */
@ApiModel(description = "用户菜单权限 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:user_power")
@Entity
@Table(name = "user_power")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserPower implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * USER_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "USER_ID", required = true)
    @Column(name = "user_id", length = 19, nullable = false)
    private String userId;

    /**
     * PARENT_CODE
     */
    @NotNull
    @Size(min = 0, max = 3)
    @ApiModelProperty(value = "PARENT_CODE", required = true)
    @Column(name = "parent_code", length = 3, nullable = false)
    private String parentCode;

    /**
     * FUNC_CODE
     */
    @NotNull
    @Size(min = 0, max = 8)
    @ApiModelProperty(value = "FUNC_CODE", required = true)
    @Column(name = "func_code", length = 8, nullable = false)
    private String funcCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public UserPower userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public UserPower parentCode(String parentCode) {
        this.parentCode = parentCode;
        return this;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public UserPower funcCode(String funcCode) {
        this.funcCode = funcCode;
        return this;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPower userPower = (UserPower) o;
        if (userPower.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userPower.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserPower{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", parentCode='" + getParentCode() + "'" +
            ", funcCode='" + getFuncCode() + "'" +
            "}";
    }
}
