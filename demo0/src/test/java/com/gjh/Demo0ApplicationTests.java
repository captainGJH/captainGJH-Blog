package com.gjh;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.gjh.dao.BlogDao;
import com.gjh.entity.AttentionRedis;
import com.gjh.entity.Blog;
import com.gjh.entity.User;
import com.gjh.service.BlogService;
import com.gjh.service.UserService;
import com.gjh.util.AliyunSmsUtils;
import com.gjh.util.RedisFollowHelper;
import com.gjh.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class Demo0ApplicationTests {
@Resource
private RedisUtils redisUtils;
	@Resource
	private UserService userService;

@Resource
private RedisFollowHelper redisFollowHelper;
	@Resource
	private BlogDao dao;

	@Resource
	private BlogService service;

	@Autowired
	private JavaMailSender mailSender;


	@Test
	public void contextLoads() {
		System.out.println(redisUtils.isMember("email","1138372894@qq.com"));


	}

}
