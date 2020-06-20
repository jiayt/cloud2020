package com.czinwen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ytjia
 * @Create: 2020-06-06 21:31
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value="/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos registry, serverPort: "+serverPort+"\t id: "+id;
    }
}
