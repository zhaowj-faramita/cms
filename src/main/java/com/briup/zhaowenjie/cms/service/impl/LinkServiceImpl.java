package com.briup.zhaowenjie.cms.service.impl;

import com.briup.zhaowenjie.cms.bean.Link;
import com.briup.zhaowenjie.cms.dao.ILinkDao;
import com.briup.zhaowenjie.cms.exception.CustomerException;
import com.briup.zhaowenjie.cms.service.ILinkService;
import com.briup.zhaowenjie.cms.utils.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void removeLink(int id) throws CustomerException {
        linkDao.deleteById(id);
    }

    @Override
    public Link queryLinkById(int id) throws CustomerException {
        return linkDao.findById(id);
    }

    @Override
    public List<Link> findAll() throws CustomerException {


        return linkDao.findAll();
    }
}
