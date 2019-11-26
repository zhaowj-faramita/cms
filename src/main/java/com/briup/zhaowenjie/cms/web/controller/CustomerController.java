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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Api(description = "用户处理器")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private MessageUtil messageUtil;

    @ApiOperation("添加新的用户或者修改一个已有的用户")
    @PostMapping("/addOrUpdate")
    public Message addCustomer(Customer customer) {
        iCustomerService.addCustomer(customer);
        return messageUtil.success();
    }

    @ApiOperation("删除一个用户")
    @GetMapping("/remove")
    @ApiImplicitParam(name = "id",value = "要删除的用户的主键",paramType = "query",required = true)
    public Message removeCustomer(int id) {
        iCustomerService.removeCustomer(id);
        return messageUtil.success();
    }

    @ApiOperation("根据主键查询用户")
    @GetMapping("/queryById")
    @ApiImplicitParam(name = "id", value = "要删除的用户的主键", paramType = "query", required = true)
    public Message<Customer> queryCustomerById(int id) {
        return messageUtil.success(iCustomerService.queryCustomerById(id));
    }

    @ApiOperation("查询所有用户")
    @GetMapping("/findAll")
    public Message<List<Customer>> findAllCustomer() {
        return messageUtil.success(iCustomerService.findAll());
    }

}
