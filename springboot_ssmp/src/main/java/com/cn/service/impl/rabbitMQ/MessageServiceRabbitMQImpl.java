package com.cn.service.impl.rabbitMQ;

import com.cn.service.MessageService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
//@Service
public class MessageServiceRabbitMQImpl implements MessageService {

    /*Rabbit消息队列技术之topic交换模式*/
    @Resource
    private AmqpTemplate amqpTemplate;
    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已列入消息队列(rabbitmq topic)，id："+id);
        amqpTemplate.convertAndSend("topicExchange","topic.order.id",id);
    }

  /*  *//*Rabbit消息队列技术之direct交换模式*//*
    @Resource
    private AmqpTemplate amqpTemplate;
    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已列入消息队列(rabbitmq direct)，id："+id);
        amqpTemplate.convertAndSend("directExchange","direct",id);
    }*/

    @Override
    public String doMessage() {
        return null;
    }
}
