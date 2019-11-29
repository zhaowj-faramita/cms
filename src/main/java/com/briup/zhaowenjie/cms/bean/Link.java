package com.briup.zhaowenjie.cms.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * cms_link对应pojo类
 * @author darkStorm
 */
@Entity
@Table(name = "cms_link")
@ApiModel
public class Link implements Serializable {
    private static final long serialVersionUID = 6043386062886310010L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "链接的id值")
    private int id;
    @ApiModelProperty(value = "链接名", required = true)
    private String name;
    @ApiModelProperty(value = "链接地址", required = true)
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
