package com.briup.zhaowenjie.cms.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * cms_article对应pojo类
 * @author darkStorm
 */
@Entity
@Table(name = "cms_article")
@ApiModel
public class Article implements Serializable {
    private static final long serialVersionUID = 3290284276016220724L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Article的id")
    private int id;
    @ApiModelProperty(value = "作者",required = true)
    private String author;
    @ApiModelProperty(value = "点击的次数",hidden = true)
    private int clickTimes;
    @ApiModelProperty(value = "连接地址",required = true)
    private String content;
    @ApiModelProperty(value = "发布的时间",hidden = true)
    private Date publishDate;
    @ApiModelProperty(value = "主题")
    private String title;
    @ApiModelProperty(value = "对应的栏目")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
                ", category=" + category +
                '}';
    }
}
