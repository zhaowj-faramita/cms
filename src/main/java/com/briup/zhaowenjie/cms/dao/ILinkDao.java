package com.briup.zhaowenjie.cms.dao;

import com.briup.zhaowenjie.cms.bean.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ILinkDao extends JpaRepository<Link,Integer> {
    @Transactional
    void deleteByName(String name);
}
