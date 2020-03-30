package com.pro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author study
 * @create 2020-03-30 20:16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //添加openfeign
public class Order84 {
    public static void main(String[] args) {
        SpringApplication.run(Order84.class,args);
    }
}
