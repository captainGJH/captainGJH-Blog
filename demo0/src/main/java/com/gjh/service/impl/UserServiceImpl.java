package com.gjh.service.impl;



import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.gjh.NotFoundException;
import com.gjh.dao.UserDao;
import com.gjh.entity.User;
import com.gjh.service.UserService;
import com.gjh.util.AliyunSmsUtils;
import com.gjh.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;//这个需要在SecurityConfig类中先创建才能使用否则报错

    @Autowired
    private UserDao userDao;
    @Autowired
    private JavaMailSender mailSender;

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
        user.setUpwd(passwordEncoder.encode(p));
        return userDao.save(user)!=null;
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

    @Override
    public String code(String phone, String code) {
        try {
            //发短信
            SendSmsResponse response1 = AliyunSmsUtils.sendSms(phone,code);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return code;
    }

    @Override//发email
    @Transactional
    public void email(String email, String xinxi) {
   try {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("1138372894@qq.com");
    message.setTo(email);
    message.setSubject("主题：CaptainGJH博客验证");
    message.setText(xinxi);
    mailSender.send(message);
   }catch (Exception e)
   {
    // TODO Auto-generated catch block
    e.printStackTrace();
       throw new NotFoundException("该email不存在");
  }


    }
}
