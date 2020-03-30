package com.pro.springcloud.service;

import com.pro.springcloud.pojo.CommonResult;
import com.pro.springcloud.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 * @author study
 * @create 2020-03-30 21:19
 */
@Component
public class FeignFallbackService implements FeignService {

    @Override
    public CommonResult<Payment> paymentSql(Integer id) {
        Payment payment = new Payment(id,"error");
        return new CommonResult<Payment>(4444444,"openfeign服务降级返回,---fallbackService",payment);
    }
}
