package com.jumore.zhxf.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * A DTO for the Feedback entity.
 */
public class FeedbackDTO implements Serializable {

    private Long id;
    
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "创建时间")
    private ZonedDateTime createdTime;
 
    @ApiModelProperty(value = "")
    private String content;
    
    @ApiModelProperty(value = "")
    private String wxNo;
    
    @ApiModelProperty(value = "名字")
    private String personName;
    
    @ApiModelProperty(value = "手机号")
    private String personMobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
	public String getWxNo() {
		return wxNo;
	}

	public void setWxNo(String wxNo) {
		this.wxNo = wxNo;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonMobile() {
		return personMobile;
	}

	public void setPersonMobile(String personMobile) {
		this.personMobile = personMobile;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FeedbackDTO feedbackDTO = (FeedbackDTO) o;

        if ( ! Objects.equals(id, feedbackDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "FeedbackDTO{" +
            "id=" + id +
            ", userId='" + userId + "'" +
            ", createdTime='" + createdTime + "'" +
            ", content='" + content + "'" +
            '}';
    }
    
    
}
