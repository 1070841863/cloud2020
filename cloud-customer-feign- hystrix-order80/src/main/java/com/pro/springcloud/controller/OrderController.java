package com.pro.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pro.springcloud.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author study
 * @create 2020-03-22 16:31
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "order_global_method")
public class OrderController {

    @Autowired
    private OrderHystrixService orderHystrixService;

    @GetMapping("/customer/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable("id") Integer id) {
        String s = orderHystrixService.PaymentInfo_ok(id);
        return s;
    }

    //3000表示3s中以内是正常的，超过就调用PaymentInfo_timeoutHandler
    @HystrixCommand(fallbackMethod = "PaymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3000")})
    @GetMapping("/customer/hystrix/timeout/{id}")
    public String PaymentInfo_timeout(@PathVariable("id") Integer id) {
        int x=1/0;
        String s = orderHystrixService.PaymentInfo_timeout(id);
        return s;
    }

    //测试
    @HystrixCommand
    @GetMapping("/customer/test")
    public String test() {
        int x=1/0;
        return null;
    }


    public String PaymentInfo_timeoutHandler(Integer id) {
        return "线程池:"+Thread.currentThread().getName()+" PaymentInfo_timeoutHandler,id:"+id+
                "\t"+"80错了啊1111!!!!";
    }

    public String order_global_method(){
        return "全局异常处理！！！！";
    }
}
