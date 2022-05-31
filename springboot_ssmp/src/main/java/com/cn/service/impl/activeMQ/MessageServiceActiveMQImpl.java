package com.cn.service.impl.activeMQ;

import com.cn.service.MessageService;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service
public class MessageServiceActiveMQImpl implements MessageService {

    /*Activemq消息队列技术*/
    @Resource
    private JmsMessagingTemplate messagingTemplate;
    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已列入消息队列，id："+id);
        messagingTemplate.convertAndSend("order.queue.id",id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
