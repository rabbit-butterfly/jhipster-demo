package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the BizAuth entity.
 */
public class BizAuthDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 16)
    private String bizName;

    @NotNull
    @Size(min = 0, max = 16)
    private String roleCode;

    @NotNull
    @Min(value = 0)
    @Max(value = 19)
    private Long minAuthCode;

    @Min(value = 0)
    @Max(value = 19)
    private Long maxAuthCode;

    @Size(min = 0, max = 1024)
    private String authCode;

    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    private Integer authCategory;

    @Size(min = 0, max = 16)
    private String createdBy;

    @NotNull
    private Instant createdDate;

    @Size(min = 0, max = 16)
    private String lastModifiedBy;

    private Instant lastModifiedDate;

    private Long bizId;

    private String bizBizName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getMinAuthCode() {
        return minAuthCode;
    }

    public void setMinAuthCode(Long minAuthCode) {
        this.minAuthCode = minAuthCode;
    }

    public Long getMaxAuthCode() {
        return maxAuthCode;
    }

    public void setMaxAuthCode(Long maxAuthCode) {
        this.maxAuthCode = maxAuthCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Integer getAuthCategory() {
        return authCategory;
    }

    public void setAuthCategory(Integer authCategory) {
        this.authCategory = authCategory;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public String getBizBizName() {
        return bizBizName;
    }

    public void setBizBizName(String bizBizName) {
        this.bizBizName = bizBizName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BizAuthDTO bizAuthDTO = (BizAuthDTO) o;
        if(bizAuthDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bizAuthDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BizAuthDTO{" +
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
