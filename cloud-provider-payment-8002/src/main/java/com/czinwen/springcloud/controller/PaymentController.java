package com.czinwen.springcloud.controller;

import com.czinwen.springcloud.entities.CommonResult;
import com.czinwen.springcloud.entities.Payment;
import com.czinwen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
            return new CommonResult(200,"插入数据成功,serverPort"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
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

    @GetMapping("/lb")
    public String getPaymentLb(){
        return serverPort;
    }




}
