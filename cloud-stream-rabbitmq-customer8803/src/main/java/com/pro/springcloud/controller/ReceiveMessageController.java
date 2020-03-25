package com.pro.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author study
 * @create 2020-03-25 16:58
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

    //这里的Message的泛型为啥是string？因为我们的生产者返回值就是string
    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message){
        System.out.println("消费者二号,----->收到的消息:"+message.getPayload()+"端口号为:"+serverPort);
    }
}
