package com.czinwen.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: ytjia
 * @Create: 2020-05-30 17:10
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //测试自己实现的负载均衡策略，这里先注释默认的轮询策略
//    @LoadBalanced  //该注解赋予resttmeplate负载均衡的能力（默认轮询策略）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
