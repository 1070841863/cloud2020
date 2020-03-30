package com.pro.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.pro.springcloud.pojo.CommonResult;

/**
 * @author study
 * 自定义处理限流逻辑
 * @create 2020-03-30 17:32
 */
public class CustomerBlockHandler {

    public static CommonResult MyGobol(BlockException exception){
        return new CommonResult(444,"客户自定义异常MyGobol");
    }

}
