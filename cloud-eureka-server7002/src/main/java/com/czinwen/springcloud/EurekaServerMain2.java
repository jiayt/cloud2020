package com.czinwen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: ytjia
 * @Create: 2020-05-30 21:37
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain2 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain2.class,args);
    }
}
