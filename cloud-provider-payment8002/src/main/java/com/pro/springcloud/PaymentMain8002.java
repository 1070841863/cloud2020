package com.pro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author study
 * @create 2020-03-16 23:12
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient //Discovery服务发现
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
