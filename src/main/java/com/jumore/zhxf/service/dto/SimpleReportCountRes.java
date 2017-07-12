package com.jumore.zhxf.service.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A DTO for the Event entity.
 */
@ApiModel(description = "活动表列查询返回对象")
public class SimpleReportCountRes implements Serializable {

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

	@ApiModelProperty(value = "姓名")
	private String personName;
	
	@ApiModelProperty(value = "数量")
	private Long completedNum;
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

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Long getCompletedNum() {
		return completedNum;
	}

	public void setCompletedNum(Long completedNum) {
		this.completedNum = completedNum;
	}

	@Override
	public String toString() {
		return "SimpleReportCountRes [id=" + id + ", title=" + title + ", personName=" + personName + ", completedNum="
				+ completedNum + "]";
	}

	
	
	public SimpleReportCountRes(Long id, String title,String personName,Long completedNum) {
		super();
		this.id = id;
		this.title = title;
		this.personName=personName;
		this.completedNum=completedNum;
	}

	public SimpleReportCountRes(Long id,String personName,Long completedNum) {
		super();
		this.id = id;
		this.personName=personName;
		this.completedNum=completedNum;
	}
	public SimpleReportCountRes() {
		super();
	}
	
}
