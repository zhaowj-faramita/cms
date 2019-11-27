package com.briup.zhaowenjie.cms.dao;

import com.briup.zhaowenjie.cms.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerDao extends JpaRepository<Customer,Integer> {
    Customer findById(int id);
}
