package com.pro.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author study
 * @create 2020-03-22 20:35
 */
@Component
public class OrderFallbackService implements OrderHystrixService {
    @Override
    public String PaymentInfo_ok(Integer id) {
        return "feign hystrix PaymentInfo_ok";
    }

    @Override
    public String PaymentInfo_timeout(Integer id) {
        return "feign hystrix PaymentInfo_timeout";
    }
}
