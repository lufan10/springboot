package com.cn.service.linsener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

//@Component
public class MessageActiveMQListener {
//    @JmsListener(destination = "order.queue.id")
//    public void receive(String id){
//        System.out.println("已完成短信发送业务，id："+id);
//    }
    @JmsListener(destination = "order.queue.id")
    @SendTo("order.other.queue.id")
    public String receive(String id){
        System.out.println("已完成短信发送业务，id："+id);
        return "new:"+id;
    }
}
