package com.pro.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author study
 * @create 2020-03-20 21:28
 */
public interface LoadBalancer {
    //
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
