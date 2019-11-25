package com.briup.zhaowenjie.cms.service;

import com.briup.zhaowenjie.cms.bean.Link;
import com.briup.zhaowenjie.cms.exception.CustomerException;

public interface ILinkService {

    Link addLink(Link link) throws CustomerException;

    void removeLink(String name) throws CustomerException;

}
