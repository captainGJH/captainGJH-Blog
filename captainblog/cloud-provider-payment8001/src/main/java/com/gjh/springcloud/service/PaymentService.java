package com.gjh.springcloud.service;

import com.gjh.springcloud.entities.Payment;


public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(long id);
}
