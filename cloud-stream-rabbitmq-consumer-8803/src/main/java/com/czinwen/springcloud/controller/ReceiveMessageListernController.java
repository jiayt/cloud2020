package com.czinwen.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: ytjia
 * @Create: 2020-06-06 12:49
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListernController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        log.info("消费者1号，-------->接收到的消息：{}\t port:{}",message.getPayload(),serverPort);
    }

}
