package com.rd.pcms.domain;

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
 * 管线-图片
 * @auther:renntrabbit@foxmail.com
 * @date:Sun Jul 23 12:39:36 CST 2017
 * table:pp_line_drawing
 */
@ApiModel(description = "管线-图片 @auther:renntrabbit@foxmail.com @date:Sun Jul 23 12:39:36 CST 2017 table:pp_line_drawing")
@Entity
@Table(name = "pp_line_drawing")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PpLineDrawing implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * PIPE_ID
     */
    @NotNull
    @Size(min = 0, max = 19)
    @ApiModelProperty(value = "PIPE_ID", required = true)
    @Column(name = "pipe_id", length = 19, nullable = false)
    private String pipeId;

    /**
     * PAGE_CODE
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "PAGE_CODE")
    @Column(name = "page_code")
    private Integer pageCode;

    /**
     * VERSION_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "VERSION_CODE")
    @Column(name = "version_code", length = 50)
    private String versionCode;

    /**
     * ALTERATION_CODE
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "ALTERATION_CODE")
    @Column(name = "alteration_code", length = 50)
    private String alterationCode;

    /**
     * NAME
     */
    @Size(min = 0, max = 50)
    @ApiModelProperty(value = "NAME")
    @Column(name = "name", length = 50)
    private String name;

    /**
     * FILE_PATH
     */
    @Size(min = 0, max = 200)
    @ApiModelProperty(value = "FILE_PATH")
    @Column(name = "file_path", length = 200)
    private String filePath;

    /**
     * REMARK
     */
    @Size(min = 0, max = 500)
    @ApiModelProperty(value = "REMARK")
    @Column(name = "remark", length = 500)
    private String remark;

    /**
     * CREATE_TIME
     */
    @NotNull
    @ApiModelProperty(value = "CREATE_TIME", required = true)
    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    /**
     * DEL_FLAG
     */
    @Min(value = 0)
    @Max(value = 10)
    @ApiModelProperty(value = "DEL_FLAG")
    @Column(name = "del_flag")
    private Integer delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPipeId() {
        return pipeId;
    }

    public PpLineDrawing pipeId(String pipeId) {
        this.pipeId = pipeId;
        return this;
    }

    public void setPipeId(String pipeId) {
        this.pipeId = pipeId;
    }

    public Integer getPageCode() {
        return pageCode;
    }

    public PpLineDrawing pageCode(Integer pageCode) {
        this.pageCode = pageCode;
        return this;
    }

    public void setPageCode(Integer pageCode) {
        this.pageCode = pageCode;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public PpLineDrawing versionCode(String versionCode) {
        this.versionCode = versionCode;
        return this;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getAlterationCode() {
        return alterationCode;
    }

    public PpLineDrawing alterationCode(String alterationCode) {
        this.alterationCode = alterationCode;
        return this;
    }

    public void setAlterationCode(String alterationCode) {
        this.alterationCode = alterationCode;
    }

    public String getName() {
        return name;
    }

    public PpLineDrawing name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public PpLineDrawing filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getRemark() {
        return remark;
    }

    public PpLineDrawing remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PpLineDrawing createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PpLineDrawing delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PpLineDrawing ppLineDrawing = (PpLineDrawing) o;
        if (ppLineDrawing.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineDrawing.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineDrawing{" +
            "id=" + getId() +
            ", pipeId='" + getPipeId() + "'" +
            ", pageCode='" + getPageCode() + "'" +
            ", versionCode='" + getVersionCode() + "'" +
            ", alterationCode='" + getAlterationCode() + "'" +
            ", name='" + getName() + "'" +
            ", filePath='" + getFilePath() + "'" +
            ", remark='" + getRemark() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", delFlag='" + getDelFlag() + "'" +
            "}";
    }
}
