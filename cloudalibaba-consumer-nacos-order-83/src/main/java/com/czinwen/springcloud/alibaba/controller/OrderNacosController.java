package com.czinwen.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: ytjia
 * @Create: 2020-06-06 23:05
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value="/consumer/payment/nacos/{id}")
    public String getPaymentInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }
}
