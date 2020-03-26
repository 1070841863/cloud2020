package com.pro.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author study
 * @create 2020-03-26 18:32
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;


    @GetMapping("/customer/nacos/{id}")
    public String getOrder(@PathVariable("id")Integer id){
        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+id,String.class);
    }
}
