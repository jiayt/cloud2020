package com.czinwen.springcloud.controller;

import com.czinwen.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ytjia
 * @Create: 2020-06-01 20:03
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_FallbackMethod")  //全局降级配置
public class OrderHystrixController {
    @Autowired
    private OrderHystrixService orderHystrixService;
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return orderHystrixService.paymentInfo_ok(id);
    };

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //指定方法，就会走单独的降级处理方法
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            //超过3秒，出错走fallback方法
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand //不指名方法，使用类上配置的全局异常
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        String result = orderHystrixService.paymentInfo_timeout(id);
        return result;
    };


    public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙，请10秒后再试，或者自己运行出错，请检查自己o(╥﹏╥)o~";
    }

    //全局通用fallback方法
    public String payment_global_FallbackMethod(){
        return "global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }
}
