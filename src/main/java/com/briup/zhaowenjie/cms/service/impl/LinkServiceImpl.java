package com.briup.zhaowenjie.cms.service.impl;

import com.briup.zhaowenjie.cms.bean.Link;
import com.briup.zhaowenjie.cms.dao.ILinkDao;
import com.briup.zhaowenjie.cms.exception.CustomerException;
import com.briup.zhaowenjie.cms.service.ILinkService;
import com.briup.zhaowenjie.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private ILinkDao linkDao;

    @Override
    public Link addLink(Link link) throws CustomerException {
        if (link == null) {
            throw new CustomerException(CodeUtil.DEADLY_CODE, "addLink:参数为空");
        } else {
            return linkDao.save(link);
        }
    }

    @Override
    public void removeLink(String name) throws CustomerException {
        if (name == null) {
            throw new CustomerException(CodeUtil.DEADLY_CODE, "removeLink:参数为空");
        } else {
            linkDao.deleteByName(name);
        }
    }

}
