package com.briup.zhaowenjie.cms.service;

import com.briup.zhaowenjie.cms.bean.Role;

import java.util.List;

public interface IRoleService {

    /**
     * 根据用户id查询用户所有的角色
     * @param customerId
     * @return
     */
    List<Role> selectAllByCustomerId(int customerId);

}