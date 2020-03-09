package com.gjh.service.impl;


import com.gjh.dao.UserDao;
import com.gjh.entity.User;
import com.gjh.service.UserService;
import com.gjh.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public Boolean add(User user) {
        return userDao.save(user)!=null;
    }

    @Transactional
    @Override
    public Boolean register(User user) {
        user.setUcreateTime(new Date());
        user.setUupdateTime(new Date());
        String p=user.getUpwd();
        user.setUpwd(MD5.MD5(p));
        return userDao.save(user)!=null;
    }

    @Transactional
    @Override
    public User login(String email, String pwd) {

       User user=userDao.findByUemailAndUpwd(email, MD5.MD5(pwd));
        return user;
    }

    @Transactional
    @Override
    public User reEmail(String email) {
        User user=userDao.findByUemail(email);
        return user;
    }
    @Transactional
    @Override
    public User getUid(Long uid) {
        return userDao.findByUid(uid);
    }
}
