package com.czinwen.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: ytjia
 * @Create: 2020-06-14 13:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider9004Main {
    public static void main(String[] args) {
        SpringApplication.run(Provider9004Main.class,args);
    }
}
