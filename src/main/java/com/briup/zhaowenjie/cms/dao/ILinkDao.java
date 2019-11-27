package com.briup.zhaowenjie.cms.dao;

import com.briup.zhaowenjie.cms.bean.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILinkDao extends JpaRepository<Link,Integer> {
    Link findById(int id);
}
