package com.czinwen.springcloud.service;

import com.czinwen.springcloud.entities.Payment;

/**
 * @Author: ytjia
 * @Create: 2020-05-30 15:32
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
