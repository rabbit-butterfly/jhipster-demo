package com.jumore.zhxf.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * A DTO for the Event entity.
 */
@ApiModel(description = "活动表列返回对象")
public class EventDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@ApiModelProperty(value = "活动ID")
	private Long id;

	@ApiModelProperty(value = "活动标题")
    private String title;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonDeserialize(using = CustomJsonDateDeserializer.class) 
    private Date startDate;
    //@JsonDeserialize(using = CustomJsonDateDeserializer.class) 
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    private Integer status;

    private String picPath;

    private String summary;

    private String content;

    private ZonedDateTime createdTime;
    
    //long personCount
    @ApiModelProperty(value = "报名人数")
    private long personCount;
    //完成数
    @ApiModelProperty(value = "完成数量")
    private long completedCount;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }


	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EventDTO eventDTO = (EventDTO) o;

        if ( ! Objects.equals(id, eventDTO.id)) return false;

        return true;
    }
	

    public long getPersonCount() {
		return personCount;
	}

	public void setPersonCount(long personCount) {
		this.personCount = personCount;
	}

	public long getCompletedCount() {
		return completedCount;
	}

	public void setCompletedCount(long completedCount) {
		this.completedCount = completedCount;
	}

	@Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "EventDTO{" +
            "id=" + id +
            ", title='" + title + "'" +
            ", startDate='" + startDate + "'" +
            ", endDate='" + endDate + "'" +
            ", status='" + status + "'" +
            ", picPath='" + picPath + "'" +
            ", summary='" + summary + "'" +
            ", content='" + content + "'" +
            ", createTime='" + createdTime + "'" +
            '}';
    }
    
}
