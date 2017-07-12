package com.jumore.zhxf.service.dto;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * A DTO for the ReportCount entity.
 */
public class ReportCountDTO implements Serializable {

	private Long id;

	@ApiModelProperty(value = "用户Id")
	private Long userId;

	@ApiModelProperty(value = "姓名")
	private String personName;

	@ApiModelProperty(value = "手机号")
	private String personMobile;

	@ApiModelProperty(value = "活动id")
	private Long eventId;

	@ApiModelProperty(value = "数量")
	private Long completedNum;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "时间")
	private ZonedDateTime createdTime;

	private ZonedDateTime modifyTime;

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

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getCompletedNum() {
		return completedNum;
	}

	public void setCompletedNum(Long completedNum) {
		this.completedNum = completedNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ReportCountDTO reportCountDTO = (ReportCountDTO) o;

		if (!Objects.equals(id, reportCountDTO.id))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "ReportCountDTO{" + "id=" + id + ", userId='" + userId + "'" + ", personName='" + personName + "'"
				+ ", personMobile='" + personMobile + "'" + ", eventId='" + eventId + "'" + ", completedNum='"
				+ completedNum + "'" + ", remark='" + remark + "'" + ", createTime='" + createdTime + "'"
				+ ", modifyTime='" + modifyTime + "'" + '}';
	}

	public ReportCountDTO() {
		super();
	}

	public ReportCountDTO(ZonedDateTime createdTime) {
		super();
		this.createdTime = createdTime;
	}
}
