package com.pro.springcloud.dao;

import com.pro.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author study
 * @create 2020-03-18 15:26
 */
@Mapper
public interface PaymentDao {

    //写操作
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Integer id);
}
