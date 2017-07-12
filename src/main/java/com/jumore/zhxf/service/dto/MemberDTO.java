package com.jumore.zhxf.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;


/**
 * A DTO for the Member entity.
 */
public class MemberDTO implements Serializable {

    private Long id;
    
    @ApiModelProperty(value = "微信号")
    private String wxNo;

    @ApiModelProperty(value = "姓名")
    private String personName;

    @ApiModelProperty(value = "法号/昵称")
    private String alias;

    @ApiModelProperty(value = "手机号")
    private String personMobile;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "职务")
    private Integer nature;

    @ApiModelProperty(value = "省编编号")
    private String provinceCode;

    @ApiModelProperty(value = "城市编号")
    private String cityCode;

    @ApiModelProperty(value = "区域代码")
    private String areaCode;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "地址")
    private String Headimgurl;
    
    @ApiModelProperty(value = "")
    private String Auth;

    
    
    public String getAuth() {
		return Auth;
	}

	public void setAuth(String auth) {
		Auth = auth;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getPersonMobile() {
        return personMobile;
    }

    public void setPersonMobile(String personMobile) {
        this.personMobile = personMobile;
    }
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }
    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    

    public String getHeadimgurl() {
		return Headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		Headimgurl = headimgurl;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MemberDTO memberDTO = (MemberDTO) o;

        if ( ! Objects.equals(id, memberDTO.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
            "id=" + id +
            ", wxNo='" + wxNo + "'" +
            ", personName='" + personName + "'" +
            ", alias='" + alias + "'" +
            ", personMobile='" + personMobile + "'" +
            ", gender='" + gender + "'" +
            ", nature='" + nature + "'" +
            ", provinceCode='" + provinceCode + "'" +
            ", cityCode='" + cityCode + "'" +
            ", areaCode='" + areaCode + "'" +
            ", address='" + address + "'" +
            '}';
    }

}
