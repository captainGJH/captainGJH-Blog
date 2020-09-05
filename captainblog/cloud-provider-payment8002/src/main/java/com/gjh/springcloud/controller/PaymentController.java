package com.gjh.springcloud.controller;

import com.gjh.springcloud.entities.CommonResult;
import com.gjh.springcloud.entities.Payment;
import com.gjh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverport;

   @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
      int result=paymentService.create(payment);
       log.info("*******插入结果"+result);

      if (result>0){
          Payment payment1=new Payment();

          return new CommonResult(200,"插入数据库成功"+"O(∩_∩)O哈哈~",result);
      } else{
          return new CommonResult(444,"插入数据库失败",null);
      }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id ){
        Payment payment=paymentService.getPaymentById(id);
        log.info("*******查询结果"+payment);
        if (payment!=null){

            return new CommonResult(200,"查询数据库成功  serverport="+serverport,payment);
        } else{
            return new CommonResult(444,"查询数据库失败",null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String lb(){
        return serverport;

    }
}
