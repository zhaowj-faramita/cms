package com.briup.zhaowenjie.cms.service;

import com.briup.zhaowenjie.cms.bean.Link;
import com.briup.zhaowenjie.cms.exception.CustomerException;

import java.util.List;

public interface ILinkService {

    Link addLink(Link link) throws CustomerException;

    void removeLink(int id) throws CustomerException;

    Link queryLinkById(int id) throws CustomerException;

    List<Link> findAll() throws CustomerException;
}
