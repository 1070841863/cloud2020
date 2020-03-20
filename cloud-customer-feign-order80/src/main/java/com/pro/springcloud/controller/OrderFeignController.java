package com.pro.springcloud.controller;

import com.pro.springcloud.pojo.CommonResult;
import com.pro.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author study
 * @create 2020-03-20 22:11
 */
@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    //此处直接将提供者的controller拿过来。
    @GetMapping("/customer/feign/get/{id}")
    public CommonResult get(@PathVariable("id")Integer id){
        return paymentFeignService.get(id);
    }

    @GetMapping("/customer/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon一般默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
