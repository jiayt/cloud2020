package com.czinwen.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.naming.Name;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ytjia
 * @Create: 2020-06-01 19:14
 */
@Service
public class PaymentService {

    /**
    * @description: 正常访问
    * @date:   2020/6/1 19:16
    * @Param:  [id]
    * @return: java.lang.String
    */
    public String paymentInfo_ok(Integer id){
        return "线程池："+ Thread.currentThread().getName()+"  paymentInfo_ok,id: "+id +"\t"+"O(∩_∩)O哈哈~";
    }

    //服务降级
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            //超过3秒，出错走fallback方法
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_timeout(Integer id){
        int timeNumber = 3000;
//        int age =10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+ Thread.currentThread().getName()+"  paymentInfo_timeout,id: "+id +"\t"+"耗时"+timeNumber+"秒钟~";
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池："+ Thread.currentThread().getName()+"  8001系统繁忙或出错，请稍后重试,id: "+id +"\t"+"o(╥﹏╥)o~";
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),  //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw  new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，o(╥﹏╥)o   id: "+id;
    }
}
