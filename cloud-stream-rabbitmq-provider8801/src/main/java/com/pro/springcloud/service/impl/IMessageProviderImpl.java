package com.pro.springcloud.service.impl;

import com.pro.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @author study
 * @create 2020-03-25 16:49
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String ids= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(ids).build());
        System.out.println("ids:"+ids);
        return ids;
    }
}
