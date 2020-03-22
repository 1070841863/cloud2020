package com.pro.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author study
 * @create 2020-03-22 16:29
 */
@Component
@FeignClient(name="CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderFallbackService.class)
public interface OrderHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String PaymentInfo_timeout(@PathVariable("id") Integer id);
}
