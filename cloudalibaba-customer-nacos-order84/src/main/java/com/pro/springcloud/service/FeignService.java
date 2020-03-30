package com.pro.springcloud.service;

import com.pro.springcloud.pojo.CommonResult;
import com.pro.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author study
 * @create 2020-03-30 21:16
 */
@FeignClient(name = "nacos-payment-provider",fallback = FeignFallbackService.class)
public interface FeignService {

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Integer id);
}
