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

//        String filepath="/root/img";//linux地址
        String filepath="F:\\upload\\";
        File dest=new File(filepath + fileName);
        file.transferTo(dest);
        User u=(User)session.getAttribute("user");
        u.setUheadimg(fileName);
        userService.add(u);

        return "redirect:/persiontext";

    }
    @GetMapping("login")
    @ResponseBody
    public String login(String uemail,String upwd, HttpSession session)throws Exception
    {


        User u=userService.login(uemail,upwd);
        System.out.println(u);
        if(u!=null)
        {
            session.setAttribute("user",u);
            return "1";
        }else
            {
                return "0";

            }
    }

    @GetMapping("yan")
    @ResponseBody
    public String yan()throws Exception
    {
        int random=(int)(Math.random()*9999)+10000;
        String random1=String.valueOf(random);
        stringRedisTemplate.opsForValue().set("yan",random1,60, TimeUnit.SECONDS);
        return random1;
    }

    @GetMapping("register")
    @ResponseBody
    @Transactional
    public String register(User user,String num)throws Exception
    {
        String redisemail=redisUtils.get(user.getUemail());
        User ue=userService.reEmail(user.getUemail());

        String num1=stringRedisTemplate.opsForValue().get("yan");
        if(user==null||user.equals(""))
        {
            return "0";
        }else if(!num.equals(num1))
        {
            return "2";
      }else if(redisemail!=null)
      {
           return "3";
      }else if(ue!=null){
            return "3";
        }

        boolean u= userService.register(user);
        redisUtils.set(user.getUemail(),user.getUemail());
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

        return "0";
    }



}
