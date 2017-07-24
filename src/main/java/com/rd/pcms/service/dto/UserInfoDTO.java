package com.rd.pcms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the UserInfo entity.
 */
public class UserInfoDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(value = 0)
    @Max(value = 19)
    private Long compId;

    @Min(value = 0)
    @Max(value = 19)
    private Long code;

    @Size(min = 0, max = 16)
    private String mobile;

    @Min(value = 0)
    @Max(value = 5)
    private Integer status;

    @Size(min = 0, max = 16)
    private String jobTitle;

    @Size(min = 0, max = 16)
    private String major;

    @NotNull
    @Min(value = 0)
    @Max(value = 19)
    private Long jhUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Long getJhUserId() {
        return jhUserId;
    }

    public void setJhUserId(Long jhUserId) {
        this.jhUserId = jhUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserInfoDTO userInfoDTO = (UserInfoDTO) o;
        if(userInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
            "id=" + getId() +
            ", compId='" + getCompId() + "'" +
            ", code='" + getCode() + "'" +
            ", mobile='" + getMobile() + "'" +
            ", status='" + getStatus() + "'" +
            ", jobTitle='" + getJobTitle() + "'" +
            ", major='" + getMajor() + "'" +
            ", jhUserId='" + getJhUserId() + "'" +
            "}";
    }
}
