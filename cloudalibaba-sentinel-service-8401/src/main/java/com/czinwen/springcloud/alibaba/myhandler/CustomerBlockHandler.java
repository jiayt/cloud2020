package com.czinwen.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.czinwen.springcloud.entities.CommonResult;

import java.io.InputStream;

/**
 * @Author: ytjia
 * @Create: 2020-06-14 12:15
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"按客户自定义，global，handlerException---1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义，global，handlerException---2");
    }
}
