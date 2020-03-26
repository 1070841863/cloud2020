package com.pro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author study
 * @create 2020-03-26 18:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaCustomerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaCustomerMain83.class,args);
    }
}
