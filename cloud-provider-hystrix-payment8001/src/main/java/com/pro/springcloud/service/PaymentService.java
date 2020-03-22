package com.pro.springcloud.service;

/**
 * @author study
 * @create 2020-03-22 15:40
 */
public interface PaymentService {
    public String PaymentInfo_ok(Integer id);

    public String PaymentInfo_timeout(Integer id);

    public String paymentCircuitBreaker(Integer id);

}

