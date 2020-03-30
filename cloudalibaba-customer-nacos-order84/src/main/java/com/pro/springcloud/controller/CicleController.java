package com.pro.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pro.springcloud.pojo.CommonResult;
import com.pro.springcloud.pojo.Payment;
import com.pro.springcloud.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author study
 * @create 2020-03-30 20:17
 */
@RestController
public class CicleController {

    public static final String url="http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/customer/fallback/{id}")
//    @SentinelResource(value = "fallback",fallback = "fallbackHanlder")
//    @SentinelResource(value = "fallback",blockHandler = "bloackHanders")
    @SentinelResource(value = "fallback",blockHandler = "bloackHanders",fallback = "fallbackHanlder"
            ,exceptionsToIgnore = {IllegalArgumentException.class}
    )
    public CommonResult<Payment> fallback(@PathVariable("id") Integer id){
        CommonResult<Payment> res = restTemplate.getForObject(url + "/paymentSql/" + id, CommonResult.class, id);
        if (id==4){
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        }
        else if(res.getData()==null){
            throw new NullPointerException("NullPointerException 该id没有对应记录数据");
        }
        return res;
    }

    public CommonResult<Payment> bloackHanders(Integer id, BlockException e){
        Payment payment=new Payment(id,null);
        return new CommonResult<Payment>(444,"bloackHanders兜底方法异常处理handler，exception错误内容:"+e.getMessage(),payment);
    }

    public CommonResult<Payment> fallbackHanlder(Integer id,Throwable e){
        Payment payment=new Payment(id,null);
        return new CommonResult<Payment>(444,"fallback兜底方法异常处理handler，exception错误内容:"+e.getMessage(),payment);
    }

    @Autowired
    private FeignService feignService;

    @GetMapping("/customer/paymentsql/{id}")
    public CommonResult<Payment> paymentsql(@PathVariable("id") Integer id){
        CommonResult<Payment> paymentCommonResult = feignService.paymentSql(id);
        return paymentCommonResult;
    }




}

