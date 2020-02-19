package com.gjh.service;

import com.gjh.dao.UserDao;
import com.gjh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {

    Boolean register(User user);

    User login(String email,String pwd);

    User reEmail(String email);//查看email是否重复

}
