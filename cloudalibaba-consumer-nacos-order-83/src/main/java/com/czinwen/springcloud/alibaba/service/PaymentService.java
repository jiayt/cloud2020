package com.czinwen.springcloud.alibaba.service;

import com.czinwen.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: ytjia
 * @Create: 2020-06-14 16:15
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value="/paymentSql/{id}")
    public CommonResult paymentSql(@PathVariable("id")long id);
}
