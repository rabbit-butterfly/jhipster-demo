package com.jumore.zhxf.web.rest.dto.oa;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.jumore.zhxf.domain.oa.WorkOvertime;
import com.jumore.zhxf.domain.util.CustomJsonDateDeserializer;
import com.jumore.zhxf.web.rest.dto.oa.EOAConstantHelper.EStatus;

public class WorkOvertimeDTO {

	@NotNull
	private Long id;
	@NotNull
	private EStatus status; // '状态@申请中:通过:驳回',
	@JsonDeserialize(using = CustomJsonDateDeserializer.class) 
	private Date startDate; // '开始时间',
	@NotNull
	@JsonDeserialize(using = CustomJsonDateDeserializer.class) 
	private Date endDate; // '结束时间',
	private Integer timeLength; // '时长(H)',
	private String remark;

	private String createdBy; // '加班早请人',

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
	@StaticMetamodel(WorkOvertime.class) 
	public static class WorkOvertime_ {
	    public static final SingularAttribute<WorkOvertime, String> createdBy=null;
	    public static final SingularAttribute<WorkOvertime, Integer> status=null;
	    public static final SingularAttribute<WorkOvertime, Date> startDate=null;
	    public static final SingularAttribute<WorkOvertime, Date> endDate=null;
	    
	}
	
}
