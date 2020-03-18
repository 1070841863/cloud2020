package com.pro.springcloud.service;

import com.pro.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author study
 * @create 2020-03-18 15:43
 */
public interface PaymentService {
    //写操作
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}
