package com.jumore.zhxf.domain.oa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "oa_check_config")
@Document(indexName = "CheckConfig")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CheckConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long userId;
	
	/**
	 * oa账号
	 */
	@Column(name = "OA_ACC",nullable = false, length = 32)
	private String oaAcc;//
	/**
	 * oa密码
	 */
	@Column(name = "OA_PWD",nullable = false, length = 64)
	private String oaPwd;
	/**
	 * oa平台
	 */
	@Column(name = "OA_PLATFORM")
	private String oaPlatform;
	/**
	 * 状态0：启用｜1:停用
	 */
	@Column(name = "STATUS")
	private int status;
	/**
	 * 最后一次打卡时间
	 */
	@Column(name = "LAST_MODIFY_TIME")
	private Date lastModifyTime;
	/**
	 * 是否接收email
	 */
	@Column(name = "IS_RECEIVE_EMAIL")
	private boolean receiveEmail;
	/**
	 * 说明
	 */
	@Column(name = "REMARK")
	private String remark;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOaAcc() {
		return oaAcc;
	}
	public void setOaAcc(String oaAcc) {
		this.oaAcc = oaAcc;
	}
	public String getOaPwd() {
		return oaPwd;
	}
	public void setOaPwd(String oaPwd) {
		this.oaPwd = oaPwd;
	}
	public String getOaPlatform() {
		return oaPlatform;
	}
	public void setOaPlatform(String oaPlatform) {
		this.oaPlatform = oaPlatform;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public boolean isReceiveEmail() {
		return receiveEmail;
	}
	public void setReceiveEmail(boolean receiveEmail) {
		this.receiveEmail = receiveEmail;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

	
	
}
