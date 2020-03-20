package com.gjh.controller;


import com.github.pagehelper.PageHelper;
import com.gjh.dao.NewsDao;
import com.gjh.dao.UserDao;
import com.gjh.entity.News;
import com.gjh.entity.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
public class Action {
  @Resource
  StringRedisTemplate stringRedisTemplate;
@Resource
    UserDao userDao;
    @Resource
    NewsDao newsDao;


    @GetMapping("yan")
    public String yan()
    {
        int random=(int)(Math.random()*9999)+10000;
        String random1=String.valueOf(random);
       stringRedisTemplate.opsForValue().set("yan",random1,60, TimeUnit.SECONDS);
        return random1;
    }
    @GetMapping("zheng")
    public String zheng(User user,String num)
    {
        String yan=stringRedisTemplate.opsForValue().get("yan");
        System.out.println("我的验证码"+yan);
      if(yan==null || !yan.equals(num))
    {
        return "0" ;
     }else
    {
        userDao.save(user);
        return "1";
    }
    }
    @GetMapping("login")
    public String login(String pwd, String uname, HttpSession session)
    {
        User user=userDao.findByUnameAndUpwd(uname,pwd);
        if(user==null)
        {
            return "0";
        }else
            {
                session.setAttribute("user",user);
                return "1";
            }
    }


}
