package com.pro.springcloud.controller;

import com.pro.springcloud.pojo.CommonResult;
import com.pro.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author study
 * @create 2020-03-30 20:04
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Integer, Payment> map=new HashMap<>();
    static{
        map.put(1,new Payment(1,"dada"));
        map.put(2,new Payment(2,"dada222"));
        map.put(3,new Payment(3,"dada333"));
    }

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Integer id){
        Payment payment = map.get(id);
        CommonResult<Payment> res=new CommonResult<Payment>(200,"from mysql serverPort:"+serverPort,payment);
        return res;
    }
}
