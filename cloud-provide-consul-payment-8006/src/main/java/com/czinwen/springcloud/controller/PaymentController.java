package com.czinwen.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: ytjia
 * @Create: 2020-05-31 14:11
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul: "+serverPort + UUID.randomUUID().toString();
    }

}
