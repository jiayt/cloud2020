package com.czinwen.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ytjia
 * @Create: 2020-06-10 23:50
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "--------------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"/t"+".....testB");
        return "--------------testB";
    }

    @GetMapping("/testD")
    public String testD(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info(Thread.currentThread().getName()+"/t"+".....testD");
        log.info("异常比例  testD");
        int age = 1/0;
        return "--------------testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("异常数  testE");
        int age = 1/0;
        return "--------------测试异常数testE";
    }
    @GetMapping("/testHotkey")
    @SentinelResource(value ="testHotkey",blockHandler = "deal_testHotkey")  //这里value相当于id随便写只要唯一即可，
    public String testHotkey(@RequestParam(value="p1",required = false) String p1,
                             @RequestParam(value="p2",required = false) String p2){
        return "-------------------testHotkey";
    }

    public String deal_testHotkey(String p1, String p2, BlockException exception){
        return "deal_testHotkey";
    }

}
