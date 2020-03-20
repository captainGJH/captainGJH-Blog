package com.gjh.service;

import com.gjh.dao.UserDao;
import com.gjh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {
    Boolean add(User user);//保存

    User getUid(Long uid);//id查找

    Boolean register(User user);//注册

//    User login(String email,String pwd);//登录用了springsecurity权限管理

    User reEmail(String email);//查看email是否重复

    public String code(String phone,String code);//手机短信功能

    public void email(String u_email,String xinxi);//qq邮箱验证功能

}
