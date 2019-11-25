package com.briup.zhaowenjie.cms.web.controller;

import com.briup.zhaowenjie.cms.bean.Customer;
import com.briup.zhaowenjie.cms.config.Message;
import com.briup.zhaowenjie.cms.config.MessageUtil;
import com.briup.zhaowenjie.cms.service.ICustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@Api(description = "用户处理器")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private MessageUtil messageUtil;

    @ApiOperation("添加新的用户")
    @GetMapping("/add")
    public Message<Customer> addCustomer(Customer customer) {
        Customer customer1 = iCustomerService.addCustomer(customer);
        return messageUtil.success(customer1);
    }

    @ApiOperation("删除一个用户")
    @GetMapping("/remove")
    @ApiImplicitParam(name = "username",value = "要删除的用户的用户名",paramType = "query")
    public Message<Customer> removeCustomer(String username) {
        iCustomerService.removeCustomer(username);
        return messageUtil.success();
    }

    @ApiOperation("修改已有的用户")
    @GetMapping("/reset")
    public Message<Customer> resetCustomer(Customer customer) {
        iCustomerService.removeCustomer(customer.getUsername());
        Customer customer1 = iCustomerService.addCustomer(customer);
        return messageUtil.success(customer1);
    }

}
