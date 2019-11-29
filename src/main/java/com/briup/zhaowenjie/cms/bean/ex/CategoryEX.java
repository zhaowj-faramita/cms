package com.briup.zhaowenjie.cms.bean.ex;

import com.briup.zhaowenjie.cms.bean.Article;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cms_category")
public class CategoryEX implements Serializable {
    private static final long serialVersionUID = -1440805962348527136L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long code;
    private String name;
    @OneToMany
    private List<Article> articles;
}
