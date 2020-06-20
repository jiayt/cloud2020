package com.czinwen.springcloud.alibaba.service;

import com.czinwen.springcloud.entities.CommonResult;
import com.czinwen.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author: ytjia
 * @Create: 2020-06-14 16:18
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult paymentSql(long id) {
        return new CommonResult(444,"服务降级返回，-------PaymentFallbackService",new Payment(id,"error"));
    }
}
