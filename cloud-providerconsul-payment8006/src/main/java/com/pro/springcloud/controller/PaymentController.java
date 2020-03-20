package com.pro.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author study
 * @create 2020-03-20 12:38
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentzk(String name){
        return "springcloud with consul"+serverPort+"\t"+name+"\t"+ UUID.randomUUID().toString();
    }
}
