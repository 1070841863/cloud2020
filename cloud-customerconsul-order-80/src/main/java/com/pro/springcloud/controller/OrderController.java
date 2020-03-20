package com.pro.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author study
 * @create 2020-03-20 19:34
 */
@RestController
@Slf4j
public class OrderController {

    private static final String url="http://consul-provider-payment";

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/customer/order")
    public String getConsul(String name){
        return restTemplate.getForObject(url+"/payment/consul?name="+name,String.class);
    }

}
