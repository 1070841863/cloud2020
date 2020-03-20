package com.pro.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author study
 * @create 2020-03-20 20:54
 */
@Configuration
public class MyruleConfig {

    /**自定义配置ribbon负载均衡算法**/
    @Bean
    public IRule myRule(){
        //return new RoundRobinRule();//轮询
        //return new RetryRule();//重试
//        return new BestAvailableRule();
        return new RandomRule();//随机
    }
}
