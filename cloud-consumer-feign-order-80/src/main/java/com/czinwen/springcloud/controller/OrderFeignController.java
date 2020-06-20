package com.czinwen.springcloud.controller;

import com.czinwen.springcloud.entities.CommonResult;
import com.czinwen.springcloud.entities.Payment;
import com.czinwen.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: ytjia
 * @Create: 2020-05-31 22:16
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
       return paymentFeignService.getPaymentById(id);
    }
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign 底层使用ribbon，客户端一般默认等1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
