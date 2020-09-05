package com.gjh.springcould.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Component
public class MyLB implements LoadBalancer {
private AtomicInteger atomicInteger=new AtomicInteger(0);

public final int getAndInCrement(){
    int current;
    int next;
    do {
        current=this.atomicInteger.get();
        next=current>=2147483647?0:current+1;

    }while (!this.atomicInteger.compareAndSet(current,next));
    System.out.println("第几次访问次数********next:   "+next);
return next;
}

    @Override
    public ServiceInstance inServiceInstance(List<ServiceInstance> serviceInstances) {
    int index=getAndInCrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
