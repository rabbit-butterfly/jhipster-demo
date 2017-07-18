package com.rd.pcms.service.dto;


import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PpLineDrawing entity.
 */
public class PpLineDrawingDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String pipeId;

    @Min(value = 0)
    @Max(value = 10)
    private Integer pageCode;

    @Size(min = 0, max = 50)
    private String versionCode;

    @Size(min = 0, max = 50)
    private String alterationCode;

    @Size(min = 0, max = 50)
    private String name;

    @Size(min = 0, max = 200)
    private String filePath;

    @Size(min = 0, max = 500)
    private String remark;

    @NotNull
    private Instant createTime;

    @Min(value = 0)
    @Max(value = 10)
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

    public void setPipeId(String pipeId) {
        this.pipeId = pipeId;
    }

    public Integer getPageCode() {
        return pageCode;
    }

    public void setPageCode(Integer pageCode) {
        this.pageCode = pageCode;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getAlterationCode() {
        return alterationCode;
    }

    public void setAlterationCode(String alterationCode) {
        this.alterationCode = alterationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
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

        PpLineDrawingDTO ppLineDrawingDTO = (PpLineDrawingDTO) o;
        if(ppLineDrawingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ppLineDrawingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PpLineDrawingDTO{" +
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
