package com.pro.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author study
 * @create 2020-03-20 11:58
 */
@RestController
@Slf4j
public class OrderController {

    private static final String INVOKE_URL="http://cloud-provider-zookeeper-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/customer/payment/zk")
    public String getInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }

}
