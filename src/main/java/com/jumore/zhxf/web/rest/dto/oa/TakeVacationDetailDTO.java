package com.jumore.zhxf.web.rest.dto.oa;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.jumore.zhxf.domain.util.CustomJsonDateDeserializer;
import com.jumore.zhxf.web.rest.dto.oa.EOAConstantHelper.EStatus;

public class TakeVacationDetailDTO {

	@NotNull
	private Long id;
	@NotNull
	private EStatus status; // '状态@申请中:通过:驳回',
	@JsonDeserialize(using = CustomJsonDateDeserializer.class) 
	@NotNull	
	private Date startDate; // '开始时间',
	@JsonDeserialize(using = CustomJsonDateDeserializer.class) 
	@NotNull
	private Date endDate; // '结束时间',
	private Integer timeLength; // '时长(H)',
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
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

	public Integer getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(Integer timeLength) {
		this.timeLength = timeLength;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
