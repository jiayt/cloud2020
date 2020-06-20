package com.czinwen.springcloud.service.impl;

import com.czinwen.springcloud.dao.PaymentDao;
import com.czinwen.springcloud.entities.Payment;
import com.czinwen.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: ytjia
 * @Create: 2020-05-30 15:35
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
