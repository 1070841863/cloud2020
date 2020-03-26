package com.pro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author study
 * @create 2020-03-26 17:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderMain9001.class,args);
    }
}
