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
 * 数据权限设置
 * @auther:renntrabbit@foxmail.com
 * @date:Thu Jul 27 10:58:26 CST 2017
 * table:jhi_biz
 */
@ApiModel(description = "数据权限设置 @auther:renntrabbit@foxmail.com @date:Thu Jul 27 10:58:26 CST 2017 table:jhi_biz")
@Entity
@Table(name = "jhi_biz")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Biz implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务名称
     */
    @NotNull
    @Size(min = 0, max = 16)
    @ApiModelProperty(value = "业务名称", required = true)
    @Column(name = "biz_name", length = 16, nullable = false)
    private String bizName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizName() {
        return bizName;
    }

    public Biz bizName(String bizName) {
        this.bizName = bizName;
        return this;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Biz biz = (Biz) o;
        if (biz.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), biz.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Biz{" +
            "id=" + getId() +
            ", bizName='" + getBizName() + "'" +
            "}";
    }
}
