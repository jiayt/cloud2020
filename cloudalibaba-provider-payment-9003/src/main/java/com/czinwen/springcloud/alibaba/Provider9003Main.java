package com.czinwen.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: ytjia
 * @Create: 2020-06-14 13:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider9003Main {
    public static void main(String[] args) {
        SpringApplication.run(Provider9003Main.class,args);
    }
}
