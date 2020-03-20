package com.pro.springcloud.controller;

import com.pro.springcloud.pojo.CommonResult;
import com.pro.springcloud.pojo.Payment;
import com.pro.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author study
 * @create 2020-03-18 15:46
 */
@RestController
@Slf4j //日志注解
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("******插入结果:"+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功,端口:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败,端口:"+serverPort);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable("id")Integer id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果:"+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功,端口:"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应的记录，查询ID:"+id+"端口:"+serverPort,null);
        }
    }

    @GetMapping("/payment/lb")
    public  String paymentLb(){
        return serverPort;
    }
}
