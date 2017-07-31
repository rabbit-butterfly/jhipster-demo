package com.rd.pcms.service.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rd.pcms.domain.BizAuth;
import com.rd.pcms.domain.Role;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.Instant;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A DTO for the Role entity.
 */
public class RoleDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 32)
    private String name;

    @NotNull
    @Size(min = 0, max = 16)
    private String code;

    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    private Integer level;

    @NotNull
    @Min(value = 0)
    @Max(value = 19)
    private Long parentId;

    @Size(min = 0, max = 16)
    private String createdBy;

    @NotNull
    private Instant createdDate;

    @Size(min = 0, max = 16)
    private String lastModifiedBy;

    private Instant lastModifiedDate;


    private BizAuth bizAuth;

    private Role role;

    private Set<Role> children = new HashSet<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RoleDTO roleDTO = (RoleDTO) o;
        if(roleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), roleDTO.getId());
    }

    public BizAuth getBizAuth() {
        return bizAuth;
    }

    public void setBizAuth(BizAuth bizAuth) {
        this.bizAuth = bizAuth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Role> getChildren() {
        return children;
    }

    public void setChildren(Set<Role> children) {
        this.children = children;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", level='" + getLevel() + "'" +
            ", parentId='" + getParentId() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", lastModifiedBy='" + getLastModifiedBy() + "'" +
            ", lastModifiedDate='" + getLastModifiedDate() + "'" +
            "}";
    }
}
