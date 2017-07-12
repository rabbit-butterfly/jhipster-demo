package com.jumore.zhxf.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Member.
 */
@Entity
@Table(name = "zhxf_member")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "member")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "wx_no")
	private String wxNo;

	@Column(name = "person_name")
	private String personName;

	@Column(name = "alias")
	private String alias;

	@Column(name = "person_mobile")
	private String personMobile;

	@Column(name = "gender")
	private Integer gender;

	@Column(name = "nature")
	private Integer nature;

	@Column(name = "province_code")
	private String provinceCode;

	@Column(name = "city_code")
	private String cityCode;

	@Column(name = "area_code")
	private String areaCode;

	@Column(name = "address")
	private String address;

	@Column(name = "created_time")
	private ZonedDateTime createdTime;

	@Column(name = "modify_time")
	private ZonedDateTime modifyTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWxNo() {
		return wxNo;
	}

	public Member wxNo(String wxNo) {
		this.wxNo = wxNo;
		return this;
	}

	public void setWxNo(String wxNo) {
		this.wxNo = wxNo;
	}

	public String getPersonName() {
		return personName;
	}

	public Member personName(String personName) {
		this.personName = personName;
		return this;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getAlias() {
		return alias;
	}

	public Member alias(String alias) {
		this.alias = alias;
		return this;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPersonMobile() {
		return personMobile;
	}

	public Member personMobile(String personMobile) {
		this.personMobile = personMobile;
		return this;
	}

	public void setPersonMobile(String personMobile) {
		this.personMobile = personMobile;
	}

	public Integer getGender() {
		return gender;
	}

	public Member gender(Integer gender) {
		this.gender = gender;
		return this;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getNature() {
		return nature;
	}

	public Member nature(Integer nature) {
		this.nature = nature;
		return this;
	}

	public void setNature(Integer nature) {
		this.nature = nature;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public Member provinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
		return this;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public Member cityCode(String cityCode) {
		this.cityCode = cityCode;
		return this;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public Member areaCode(String areaCode) {
		this.areaCode = areaCode;
		return this;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAddress() {
		return address;
	}

	public Member address(String address) {
		this.address = address;
		return this;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Member member = (Member) o;
		if (member.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, member.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
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
	public String toString() {
		return "Member [id=" + id + ", wxNo=" + wxNo + ", personName=" + personName + ", alias=" + alias
				+ ", personMobile=" + personMobile + ", gender=" + gender + ", nature=" + nature + ", provinceCode="
				+ provinceCode + ", cityCode=" + cityCode + ", areaCode=" + areaCode + ", address=" + address
				+ ", createdTime=" + createdTime + ", modifyTime=" + modifyTime + "]";
	}
}
