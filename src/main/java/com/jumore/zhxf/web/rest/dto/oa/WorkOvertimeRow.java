package com.jumore.zhxf.web.rest.dto.oa;

import java.util.Date;

public class WorkOvertimeRow {
	
	private String mail;
	
	private String userName; //用户
	
	private String departName;  //部门
	
//	@JsonDeserialize(using = CustomJsonDateDeserializer.class) 
	private Date checkinTime; // '开始时间',
	
//	@JsonDeserialize(using = CustomJsonDateDeserializer.class) 
	private Date checkoutTime; // '结束时间',
	
	private Date checkdate;
	
	private String status; // 状态,
	
	private int timeLength;

	
	public WorkOvertimeRow() {
	}

	public WorkOvertimeRow(String mail, String userName, String departName, Date checkinTime, Date checkoutTime,
			Date checkdate, String status, int timeLength) {
		super();
		this.mail = mail;
		this.userName = userName;
		this.departName = departName;
		this.checkinTime = checkinTime;
		this.checkoutTime = checkoutTime;
		this.checkdate = checkdate;
		this.status = status;
		this.timeLength = timeLength;
	}




	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	public Date getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}

	public Date getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public Date getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	public int getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(int timeLength) {
		this.timeLength = timeLength;
	}

	@Override
	public String toString() {
		return "WorkOvertimeRow [mail=" + mail + ", userName=" + userName + ", departName=" + departName
				+ ", checkinTime=" + checkinTime + ", checkoutTime=" + checkoutTime + ", checkdate=" + checkdate
				+ ", status=" + status + ", timeLength=" + timeLength + "]";
	}

	

	
	
	
}
