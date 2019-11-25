package com.briup.zhaowenjie.cms.service;


import com.briup.zhaowenjie.cms.bean.Customer;
import com.briup.zhaowenjie.cms.exception.CustomerException;

public interface ICustomerService {

    Customer addCustomer(Customer customer) throws CustomerException;

    void removeCustomer(String name) throws CustomerException;

}
