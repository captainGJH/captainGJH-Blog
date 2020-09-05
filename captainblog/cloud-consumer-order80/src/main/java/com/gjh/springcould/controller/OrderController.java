package com.gjh.springcould.controller;

import com.gjh.springcloud.entities.CommonResult;
import com.gjh.springcloud.entities.Payment;


import com.gjh.springcould.lb.LoadBalancer;
import com.sun.jndi.toolkit.url.Uri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

  //  public static final String PAYMENT_URL="http://localhost:2001";//单机
    //集群
    public static final String PAYMENT_URL="http://COULD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

           return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id")Long id){
           return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
}

  @GetMapping("/consumer/payment2/get/{id}")
  public CommonResult<Payment> get2(@PathVariable("id")Long id){

    ResponseEntity<CommonResult> entity=restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

    if(entity.getStatusCode().is2xxSuccessful()){
      return entity.getBody();
    }else{
      return new CommonResult<>(444,"操作失败");
    }

  }
  @GetMapping(value = "/consumer/payment/lb")
  public String lb(){
    List<ServiceInstance> serviceInstances=discoveryClient.getInstances("COULD-PAYMENT-SERVICE");
    if(serviceInstances==null || serviceInstances.size()<=0 ){
      return null;
    }
    ServiceInstance serviceInstance=loadBalancer.inServiceInstance(serviceInstances);
    URI uri=serviceInstance.getUri();
    return restTemplate.getForObject(uri+"/payment/lb",String.class);

  }

}
