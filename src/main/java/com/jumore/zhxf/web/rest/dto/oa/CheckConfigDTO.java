package com.jumore.zhxf.web.rest.dto.oa;

import java.util.Date;

import javax.persistence.Id;

public class CheckConfigDTO {

	/**
	 * 
	 */
	@Id
	private Long userId;
	
	/**
	 * oa账号
	 */
	private String oaAcc;//
	/**
	 * oa密码
	 */
	private String oaPwd;
	/**
	 * 新密码
	 * */
	private String newPwd;
	/**
	 * oa平台
	 */
	private String oaPlatform;
	/**
	 * 状态0：启用｜1:停用
	 */
	private EStatus status;
	/**
	 * 最后一次打卡时间
	 */
	private Date lastModifyTime;
	/**
	 * 是否接收email
	 */
	private boolean receiveEmail;
	/**
	 * 说明
	 */
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
	public EStatus getStatus() {
		return status;
	}
	public void setStatus(EStatus status) {
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
	
	
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}


	public enum EStatus{
		
		enabled,
		disabled
	}
	
	
}
