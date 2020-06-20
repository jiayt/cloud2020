package com.czinwen.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.czinwen.springcloud.alibaba.service.PaymentService;
import com.czinwen.springcloud.entities.CommonResult;
import com.czinwen.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: ytjia
 * @Create: 2020-06-14 13:56
 */
@RestController
@Slf4j
public class CircleBreakerController {
    @Value("${service-url.nacos-user-service}")
    private String Server_url;
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")  //配有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")  //只负责java运行时程序业务逻辑异常，兜底异常
//    @SentinelResource(value="fallback",blockHandler = "blockHandler")  //blockHandler只负责sentinel控制台配置的违规
   @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")//两种都配置
    public CommonResult fallback(@PathVariable("id") long id){
        CommonResult result = restTemplate.getForObject(Server_url + "/paymentSql/" + id, CommonResult.class, id);
        if(id==4){
            throw  new IllegalArgumentException("IllegalArgumentException 非法参数异常。。。。。");
        }else if(result.getData()==null){
            throw new NullPointerException("NullPointerException ,改id没有对应记录。。。。");
        }
        return  result;
    }

    //fallback
    public CommonResult handlerFallback(@PathVariable("id") long id,Throwable e){
        Payment payment = new Payment(id, null);
        return  new CommonResult(444,"业务兜底异常handlerFallback,exception 内容  "+e.getMessage(),payment);
    }

    //blockHandler
    public CommonResult blockHandler(@PathVariable("id") long id, BlockException e){
        Payment payment = new Payment(id, null);
        return  new CommonResult(445,"业务兜底异常blockHandler,BlockException 内容  "+e.getMessage(),payment);
    }

    //openFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value="/consumer/paymentSql/{id}")
    public CommonResult paymentSql(@PathVariable("id")long id){
        return paymentService.paymentSql(id);
    }

}
