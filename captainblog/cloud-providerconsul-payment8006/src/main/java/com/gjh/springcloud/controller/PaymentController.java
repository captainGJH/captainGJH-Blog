package com.gjh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String ServerPort;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "SpringCloud with consul :"+ServerPort+"\t"+ UUID.randomUUID();
    }


}
