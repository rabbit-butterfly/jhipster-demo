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
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * 角色
 *
 * @auther:renntrabbit@foxmail.com
 * @date:Thu Jul 27 10:58:26 CST 2017
 * table:jhi_role
 */
@ApiModel(description = "角色 @auther:renntrabbit@foxmail.com @date:Thu Jul 27 10:58:26 CST 2017 table:jhi_role")
@Entity
@Table(name = "jhi_role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 权限名称
     */
    @NotNull
    @Size(min = 0, max = 32)
    @ApiModelProperty(value = "权限名称", required = true)
    @Column(name = "name", length = 32, nullable = false)
    private String name;

    /**
     * 编码
     */
    @NotNull
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "编码", required = true)
    @Column(name = "code", length = 16, nullable = false)
    private String code;

    /**
     * 级别
     */
    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    @ApiModelProperty(value = "级别", required = true)
    @Column(name = "level", nullable = false)
    private Integer level;

    /**
     * 父节点
     */
    @NotNull
    @Min(value = 0)
    @Max(value = 19)
    @ApiModelProperty(value = "父节点", required = true)
    @Column(name = "parent_id", nullable = false)
    private Long parentId;

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

    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
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

    public Role name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Role code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLevel() {
        return level;
    }

    public Role level(Integer level) {
        this.level = level;
        return this;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public Role parentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Role createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Role createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Role lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Role lastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<Role> getChildren() {
        return children;
    }

    public void setChildren(Set<Role> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        if (role.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Role{" +
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
