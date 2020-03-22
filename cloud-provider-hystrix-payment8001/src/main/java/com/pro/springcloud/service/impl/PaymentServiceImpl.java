package com.pro.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pro.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;
import java.util.UUID;

/**
 * @author study
 * @create 2020-03-22 15:41
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String PaymentInfo_ok(Integer id) {
        return "线程池:"+Thread.currentThread().getName()+" PaymentInfo_ok,id:"+id+"\t"+"hhhhh";
    }

    //3000表示3s中以内是正常的，超过就调用PaymentInfo_timeoutHandler
    @HystrixCommand(fallbackMethod = "PaymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3000")})
    public String PaymentInfo_timeout(Integer id) {
        int timeNumber=4000;
//        int x=10/0;
        try {
            Thread.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+" PaymentInfo_timeout,id:"+id+
                "\t"+"hhhhh"+"耗时"+(timeNumber/1000)+"s";
     }



    public String PaymentInfo_timeoutHandler(Integer id) {
        return "线程池:"+Thread.currentThread().getName()+" PaymentInfo_timeoutHandler,id:"+id+
                "\t"+"8001系统出错啦!!!!";
    }

    //    服务熔断
    @HystrixCommand(fallbackMethod = "fallbackBreaker",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    //此处的HystrixProperty解释为，在10秒钟的时间窗口期，十次请求里面有百分之60都是失败的，断路器将会起作用。
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        return "调用成功"+ UUID.randomUUID().toString();
    }

    public String fallbackBreaker(Integer id){
        return "失败咯！！！id:"+id;
    }

}
