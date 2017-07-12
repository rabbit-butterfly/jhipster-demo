package com.jumore.zhxf.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A News.
 */
@Entity
@Table(name = "zhxf_news")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "news")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "title")
    private String title;

    @Column(name = "pic_path")
    private String picPath;

    @Column(name = "summary")
    private String summary;

    @Column(name = "status")
    private Integer status;

    @Column(name = "content_url")
    private String contentUrl;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public News categoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public News title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicPath() {
        return picPath;
    }

    public News picPath(String picPath) {
        this.picPath = picPath;
        return this;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getSummary() {
        return summary;
    }

    public News summary(String summary) {
        this.summary = summary;
        return this;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getStatus() {
        return status;
    }

    public News status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public News contentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
        return this;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public News createdTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public ZonedDateTime getModifyTime() {
        return modifyTime;
    }

    public News modifyTime(ZonedDateTime modifyTime) {
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
        News news = (News) o;
        if (news.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, news.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "News{" +
            "id=" + id +
            ", categoryId='" + categoryId + "'" +
            ", title='" + title + "'" +
            ", picPath='" + picPath + "'" +
            ", summary='" + summary + "'" +
            ", status='" + status + "'" +
            ", contentUrl='" + contentUrl + "'" +
            ", createdTime='" + createdTime + "'" +
            ", modifyTime='" + modifyTime + "'" +
            '}';
    }
}
