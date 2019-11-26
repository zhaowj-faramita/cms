package com.briup.zhaowenjie.cms.service.impl;

import com.briup.zhaowenjie.cms.bean.Customer;
import com.briup.zhaowenjie.cms.dao.ICustomerDao;
import com.briup.zhaowenjie.cms.exception.CustomerException;
import com.briup.zhaowenjie.cms.service.ICustomerService;
import com.briup.zhaowenjie.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao iCustomerDao;

    @Override
    public Customer addCustomer(Customer customer) throws CustomerException {
        if (customer == null) {
            throw new CustomerException(CodeUtil.DEADLY_CODE, "addCustomer:参数为空");
        } else {
            return iCustomerDao.save(customer);
        }
    }

    @Override
    public void removeCustomer(int id) throws CustomerException {
            iCustomerDao.deleteById(id);
    }

    @Override
    public Customer queryCustomerById(int id) throws CustomerException {
        return iCustomerDao.findById(id);
    }

    @Override
    public List<Customer> findAll() throws CustomerException {
        return iCustomerDao.findAll();
    }
}
