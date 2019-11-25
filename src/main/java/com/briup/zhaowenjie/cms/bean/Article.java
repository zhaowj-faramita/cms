package com.briup.zhaowenjie.cms.bean;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * cms_article对应pojo类
 * @author darkStorm
 */
@Entity
@Table(name = "cms_article")
@ApiModel
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private int clickTimes;
    private String content;
    private Date publishDate;
    private String title;
    private int category_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(int clickTimes) {
        this.clickTimes = clickTimes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DatabaseMetaDatate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(DatabaseMetaDatate publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", clickTimes=" + clickTimes +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", title='" + title + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
