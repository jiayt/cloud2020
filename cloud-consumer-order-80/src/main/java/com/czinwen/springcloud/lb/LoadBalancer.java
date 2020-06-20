package com.czinwen.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: ytjia
 * @Create: 2020-05-31 17:01
 */
//自定义负载均衡策略（轮询）
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
