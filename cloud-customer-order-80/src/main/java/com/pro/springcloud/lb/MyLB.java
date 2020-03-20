package com.pro.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author study
 * @create 2020-03-20 21:29
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current>=2147483647?0:current+1;
            //如果当前值和下一个值不是current和next就结束循环
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("****next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index=getIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
