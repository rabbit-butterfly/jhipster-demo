package com.rd.pcms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the UserArea entity.
 */
public class UserAreaDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 19)
    private String userId;

    @NotNull
    @Size(min = 0, max = 19)
    private String areaId;

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

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserAreaDTO userAreaDTO = (UserAreaDTO) o;
        if(userAreaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userAreaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserAreaDTO{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", areaId='" + getAreaId() + "'" +
            "}";
    }
}
