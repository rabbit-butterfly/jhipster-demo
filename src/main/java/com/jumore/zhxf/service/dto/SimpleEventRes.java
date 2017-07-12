package com.jumore.zhxf.service.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A DTO for the Event entity.
 */
@ApiModel(description = "活动表列查询返回对象")
public class SimpleEventRes implements Serializable {

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

	@Override
	public String toString() {
		return "SimpleEventRes [id=" + id + ", title=" + title + "]";
	}

	public SimpleEventRes(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public SimpleEventRes() {
		super();
	}
	
}
