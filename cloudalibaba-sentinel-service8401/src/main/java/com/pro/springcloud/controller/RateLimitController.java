package com.pro.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pro.springcloud.myhandler.CustomerBlockHandler;
import com.pro.springcloud.pojo.CommonResult;
import com.pro.springcloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author study
 * @create 2020-03-30 16:35
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020,"serial01"));
    }

    public CommonResult handlerException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t服务不可用");
    }

    @GetMapping("/myurl")
    @SentinelResource(value = "xxxx")
    public CommonResult myurl(){
        return new CommonResult(200,"按url限流测试ok",new Payment(2020,"serial01"));
    }


    @GetMapping("/testGo")
    @SentinelResource(value = "testGo",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "MyGobol"
            )
    public CommonResult testGo(){
        return new CommonResult(200,"客户自定义testGo",new Payment(2020,"serial01"));
    }

}
