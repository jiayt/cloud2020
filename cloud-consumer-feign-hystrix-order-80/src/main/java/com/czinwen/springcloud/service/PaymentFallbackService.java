package com.czinwen.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: ytjia
 * @Create: 2020-06-01 22:34
 */
@Component
public class PaymentFallbackService implements OrderHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "--------paymentFallbackService fall back paymentInfo_ok o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "--------paymentFallbackService fall back paymentInfo_timeout o(╥﹏╥)o";
    }
}
