package com.rd.pcms.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Biz entity.
 */
public class BizDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 0, max = 16)
    private String bizName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BizDTO bizDTO = (BizDTO) o;
        if(bizDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bizDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BizDTO{" +
            "id=" + getId() +
            ", bizName='" + getBizName() + "'" +
            "}";
    }
}
