package com.gjh.springcould.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;


public interface LoadBalancer {
    ServiceInstance inServiceInstance(List<ServiceInstance> serviceInstances);


}
