package com.pro.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author study
 * @create 2020-03-29 16:37
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testA----in");
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+"test B");
        return "----testB";
    }

    @GetMapping("/testC")
    public String testC(){
        int x=10/0;
        log.info(Thread.currentThread().getName()+"\t"+"test C");
        return "----testC";
    }


    @GetMapping("/testHostKey")
    @SentinelResource(value = "testHostKey",blockHandler = "deal_testHostKey")
    public String testHostKey(@RequestParam(value = "p1",required = false) String p1,
                              @RequestParam(value = "p2",required = false)String p2)
    {
        return "--hostKey";
    }


    public String deal_testHostKey(String p1, String p2, BlockException exception)
    {
        return "deal_testHostKey报错！！！"+exception.getMessage().toString();
    }


}
