package com.pro.springcloud.service;

import com.pro.springcloud.pojo.CommonResult;
import com.pro.springcloud.pojo.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author study
 * @create 2020-03-20 22:05
 */
@Component
@FeignClient(name = "CLOUD-PROVIDER-SERVICE") //CLOUD-PROVIDER-SERVICE是注册在eureka上的提供者名称
public interface PaymentFeignService {

    //此处直接将提供者的controller拿过来。
    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id")Integer id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
