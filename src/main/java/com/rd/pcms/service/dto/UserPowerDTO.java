package com.rd.pcms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the UserPower entity.
 */
public class UserPowerDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String userId;

    @NotNull
    @Size(min = 0, max = 3)
    private String parentCode;

    @NotNull
    @Size(min = 0, max = 8)
    private String funcCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserPowerDTO userPowerDTO = (UserPowerDTO) o;
        if(userPowerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userPowerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserPowerDTO{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", parentCode='" + getParentCode() + "'" +
            ", funcCode='" + getFuncCode() + "'" +
            "}";
    }
}
