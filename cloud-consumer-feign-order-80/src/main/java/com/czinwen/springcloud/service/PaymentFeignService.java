package com.czinwen.springcloud.service;

import com.czinwen.springcloud.entities.CommonResult;
import com.czinwen.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: ytjia
 * @Create: 2020-05-31 22:08
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment>  getPaymentById(@PathVariable("id") long id);
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
