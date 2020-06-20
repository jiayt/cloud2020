package com.czinwen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: ytjia
 * @Create: 2020-06-06 21:29
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentNacos9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacos9001.class,args);
    }
}
