package com.jumore.zhxf.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A ReportCount.
 */
@Entity
@Table(name = "zhxf_report_count")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "reportcount")
public class ReportCount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "person_name")
	private String personName;

	@Column(name = "person_mobile")
	private String personMobile;

	@Column(name = "event_id")
	private Long eventId;

	@Column(name = "completed_num")
	private Long completedNum;

	@Column(name = "remark")
	private String remark;

	@Column(name = "created_time")
	private ZonedDateTime createdTime;

	@Column(name = "modify_time")
	private ZonedDateTime modifyTime;

	public ReportCount(Long eventId) {
		super();
		this.eventId = eventId;
	}

	
	public ReportCount(ZonedDateTime createdTime) {
		super();
		this.createdTime = createdTime;
	}
	
	public ReportCount() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public ReportCount userId(Long userId) {
		this.userId = userId;
		return this;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPersonName() {
		return personName;
	}

	public ReportCount personName(String personName) {
		this.personName = personName;
		return this;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonMobile() {
		return personMobile;
	}

	public ReportCount personMobile(String personMobile) {
		this.personMobile = personMobile;
		return this;
	}

	public void setPersonMobile(String personMobile) {
		this.personMobile = personMobile;
	}

	public Long getEventId() {
		return eventId;
	}

	public ReportCount eventId(Long eventId) {
		this.eventId = eventId;
		return this;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getCompletedNum() {
		return completedNum;
	}

	public ReportCount completedNum(Long completedNum) {
		this.completedNum = completedNum;
		return this;
	}

	public void setCompleteNum(Long completedNum) {
		this.completedNum = completedNum;
	}

	public String getRemark() {
		return remark;
	}

	public ReportCount remark(String remark) {
		this.remark = remark;
		return this;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ZonedDateTime getCreatedTime() {
		return createdTime;
	}

	public ReportCount createdTime(ZonedDateTime createdTime) {
		this.createdTime = createdTime;
		return this;
	}

	public void setCreatedTime(ZonedDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public ZonedDateTime getModifyTime() {
		return modifyTime;
	}

	public ReportCount modifyTime(ZonedDateTime modifyTime) {
		this.modifyTime = modifyTime;
		return this;
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
		ReportCount reportCount = (ReportCount) o;
		if (reportCount.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, reportCount.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "ReportCount{" + "id=" + id + ", userId='" + userId + "'" + ", personName='" + personName + "'"
				+ ", personMobile='" + personMobile + "'" + ", eventId='" + eventId + "'" + ", completeNum='"
				+ completedNum + "'" + ", remark='" + remark + "'" + ", createTime='" + createdTime + "'"
				+ ", modifyTime='" + modifyTime + "'" + '}';
	}
}
