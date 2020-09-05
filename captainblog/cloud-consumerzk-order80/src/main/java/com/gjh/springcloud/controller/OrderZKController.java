package com.gjh.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZKController {
    @Resource
    private RestTemplate restTemplate;
    public static final String PAYMENT_URL="http://could-payment-service";

    @GetMapping("/consumer/payment/zk")
    public String zk(){
      return restTemplate.getForObject(PAYMENT_URL+"/payment/zkp",String.class);


    }

}