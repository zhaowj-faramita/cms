package com.briup.zhaowenjie.cms.bean;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cms_category")
@ApiModel
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long code;
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
