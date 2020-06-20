package com.czinwen.springcloud.alibaba.controller;

import com.czinwen.springcloud.entities.CommonResult;
import com.czinwen.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: ytjia
 * @Create: 2020-06-14 13:34
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    private static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1,"fsdafasdfsad98fsd9f8dsgad89gag"));
        hashMap.put(2L,new Payment(2,"3dgdgsdfgdg98d9udjgdfjgods4843"));
        hashMap.put(3L,new Payment(3,"3f46gdfasdf4543t43trhy5y6hy545"));
    }
    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult paymentSql(@PathVariable("id")long id){
        Payment payment = hashMap.get(id);
        CommonResult commonResult = new CommonResult(200, "from mysql,serverPort: " + serverPort, payment);
        return commonResult;
    }
}
