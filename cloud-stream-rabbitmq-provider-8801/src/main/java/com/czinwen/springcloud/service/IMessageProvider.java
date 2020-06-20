package com.czinwen.springcloud.service;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: ytjia
 * @Create: 2020-06-06 11:42
 */
public interface IMessageProvider {
    public String send();
}
