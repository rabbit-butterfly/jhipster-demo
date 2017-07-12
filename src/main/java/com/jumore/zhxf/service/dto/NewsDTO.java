package com.jumore.zhxf.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * A DTO for the News entity.
 */
@ApiModel(description = "资讯返回对象")
public class NewsDTO implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "资讯ID")
	private Long id;

	@ApiModelProperty(value = "类目ID")
    private Long categoryId;

	@ApiModelProperty(value = "标题")
    private String title;

	@ApiModelProperty(value = "图片路径")
    private String picPath;
	
	@ApiModelProperty(value = "摘要")
    private String summary;

	@ApiModelProperty(value = "状态@1:启用,2:停用")
    private Integer status;

	@ApiModelProperty(value = "外部链接")
    private String contentUrl;

	@ApiModelProperty(value = "创建时间")
    private ZonedDateTime createdTime;

	@ApiModelProperty(value = "修改时间")
    private ZonedDateTime modifyTime;
    
    private String firstName;
   
    private String secondName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }
    public ZonedDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(ZonedDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NewsDTO newsDTO = (NewsDTO) o;

        if ( ! Objects.equals(id, newsDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
            "id=" + id +
            ", categoryId='" + categoryId + "'" +
            ", title='" + title + "'" +
            ", picPath='" + picPath + "'" +
            ", summary='" + summary + "'" +
            ", status='" + status + "'" +
            ", contentUrl='" + contentUrl + "'" +
            ", createdTime='" + createdTime + "'" +
            ", modifyTime='" + modifyTime + "'" +
            '}';
    }
}
