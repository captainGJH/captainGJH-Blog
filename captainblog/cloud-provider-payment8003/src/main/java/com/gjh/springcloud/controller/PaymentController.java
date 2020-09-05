package com.gjh.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String ServerPort;

    @RequestMapping("/payment/zkp")
    public String paymentzk(){
        return "SpringCloud with zookeeper :"+ServerPort+"\t"+ UUID.randomUUID();
    }

}