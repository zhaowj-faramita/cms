package com.briup.zhaowenjie.cms.service;


import com.briup.zhaowenjie.cms.bean.Customer;
import com.briup.zhaowenjie.cms.exception.CustomerException;

import java.util.List;

public interface ICustomerService {

    Customer addCustomer(Customer customer) throws CustomerException;

    void removeCustomer(int id) throws CustomerException;

    Customer queryCustomerById(int id) throws CustomerException;

    List<Customer> findAll() throws CustomerException;

    Customer queryCustomerByUsername(String username)throws CustomerException;
}
