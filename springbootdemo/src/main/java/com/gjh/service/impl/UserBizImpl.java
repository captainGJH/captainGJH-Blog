package com.gjh.service.impl;

import com.gjh.service.UserBiz;
import com.gjh.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class UserBizImpl implements UserBiz {
    @Resource
    private UserDao userDao;
    @Transactional(rollbackFor=Exception.class)
    public void shiwu()
    {


    }


}
