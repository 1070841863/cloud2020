package com.pro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author study
 * @create 2020-03-25 16:47
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamCustomerMQMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamCustomerMQMain8803.class,args);
    }
}
