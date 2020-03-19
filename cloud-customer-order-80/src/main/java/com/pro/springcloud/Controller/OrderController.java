package com.pro.springcloud.Controller;

import com.pro.springcloud.pojo.CommonResult;
import com.pro.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author study
 * @create 2020-03-18 16:51
 */
@RestController
@Slf4j
public class OrderController {

//    private static final String PAYMENT_URL="http://localhost:8001";
    private static final String PAYMENT_URL="http://CLOUD-PROVIDER-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/customer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("消费端远程调用创建");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/customer/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id")Integer id){
        log.info("消费端远程调用查询");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


}
