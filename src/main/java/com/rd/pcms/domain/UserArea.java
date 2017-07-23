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
 * 用户选中了项目中的哪几个分项
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:user_area
 */
@ApiModel(description = "用户选中了项目中的哪几个分项 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:user_area")
@Entity
@Table(name = "user_area")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserArea implements Serializable {

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
     * AREA_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "AREA_ID", required = true)
    @Column(name = "area_id", length = 19, nullable = false)
    private String areaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public UserArea userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAreaId() {
        return areaId;
    }

    public UserArea areaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserArea userArea = (UserArea) o;
        if (userArea.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userArea.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserArea{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", areaId='" + getAreaId() + "'" +
            "}";
    }
}
