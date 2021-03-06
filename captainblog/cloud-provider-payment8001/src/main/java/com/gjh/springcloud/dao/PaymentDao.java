package com.gjh.springcloud.dao;

import com.gjh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(@Param("id")long id);
}
