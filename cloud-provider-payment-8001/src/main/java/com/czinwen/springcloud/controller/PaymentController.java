package com.czinwen.springcloud.controller;

import com.czinwen.springcloud.entities.CommonResult;
import com.czinwen.springcloud.entities.Payment;
import com.czinwen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ytjia
 * @Create: 2020-05-30 15:43
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;
    /**
    * @description: 新增数据
    * @date:   2020/5/30 15:49
    * @Param:  [payment]
    * @return: com.czinwen.springcloud.entities.CommonResult
    */
    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果：{}",result);
        if(result>0){
            return new CommonResult(200,"插入数据成功,serverport:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据失败,serverPort"+serverPort,null);
        }
    }

    /**
    * @description: 根据id查询
    * @date:   2020/5/30 15:53
    * @Param:  [id]
    * @return: com.czinwen.springcloud.entities.CommonResult
    */
    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：{}",payment);
        if(payment !=null){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,payment);
        }else{
            return new CommonResult(444,"查询失败，查询id："+id,null);
        }
    }

    /**
    * @description: 服务发现，对于注册进eureka里面的微服务，可以通过服务发现来获得服务的信息
    * @date:   2020/5/30 23:00
    * @Param:  []
    * @return: java.lang.Object
    */
    @GetMapping("/discovery")
    public Object discovery(){
        //获取所有的服务信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******service: "+service);
        }

        //根据服务id获取对应的服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        //线程暂停三秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin(){
        return "hi, I'm paymentzipkin server fall back.........";
    }


}
