package com.briup.zhaowenjie.cms.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * cms_category对应pojo类
 * @author darkStorm
 */
@Entity
@Table(name = "cms_category")
@ApiModel
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Category的id")
    private int id;
    @ApiModelProperty(value = "Category的code")
    private long code;
    @ApiModelProperty(value = "Category的name")
    private String name;

    public int getId() {
        return id;
    }

    public long getCode() {
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
