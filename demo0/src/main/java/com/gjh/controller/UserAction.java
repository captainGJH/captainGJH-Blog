package com.gjh.controller;


import com.gjh.entity.User;
import com.gjh.service.UserService;

import com.gjh.util.RedisUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Controller
@RequestMapping("douser")
public class UserAction {

    @Resource
    private UserService userService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisUtils redisUtils;

    @RequestMapping("gfile")//照片上传
    public String gfile(MultipartFile file,HttpSession session) throws Exception
    {

        String extName=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName= UUID.randomUUID().toString()+extName;

        String filepath="/root/img/";//linux地址
//        String filepath="F:\\upload\\";
        File dest=new File(filepath + fileName);
        file.transferTo(dest);
        User u=(User)session.getAttribute("user");
        u.setUheadimg(fileName);
        userService.add(u);

        return "redirect:/persiontext";

    }

    @GetMapping("yan")
    @ResponseBody
    public String yan(String email)throws Exception
    {
        //可以手机验证调用 userService.code()方法

        int random=(int)(Math.random()*9999)+10000;
        String random1=String.valueOf(random);
        //将email 和验证码存个60秒
        redisUtils.setForTimeMIN(email,random1,1);
        userService.email(email,random1);
        return random1;
    }
    @GetMapping("/register")
    @ResponseBody
    @Transactional
    public String register(User user,String num)throws Exception
    {
        System.out.println("我进来了啊");
        boolean isMember=redisUtils.isMember("email",user.getUemail());//判断是否重复
        String yan=redisUtils.get(user.getUemail());//获取验证码


        if(user==null||user.equals(""))
        {
            return "0";
        }
        if(yan==null)
        {
            return "2";
        }
      if(isMember==true) {
        return "3";
       }
        boolean u= userService.register(user);
        redisUtils.add("email",user.getUemail());
        if (u==true)
        {
            return "1";
        }else
        {
            return "0";
        }

    }

    @GetMapping("out")
    @ResponseBody
 public String out(HttpSession session)throws Exception
    {
        session.removeAttribute("user");
        session.removeAttribute("isfollow");

        return "0";
    }



}
