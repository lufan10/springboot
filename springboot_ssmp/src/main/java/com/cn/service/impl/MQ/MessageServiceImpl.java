package com.cn.service.impl.MQ;

import com.cn.service.MessageService;

import java.util.ArrayList;
import java.util.List;

public class MessageServiceImpl implements MessageService {
    /*集合实现消息队列技术*/
    private List<String> msgList=new ArrayList<>();
    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已列入消息队列，id："+id);
        msgList.add(id);
    }

    @Override
    public String doMessage() {
        String id = msgList.remove(0);
        System.out.println("已完成短信发送业务，id："+id);
        System.out.println();
        return id;
    }
}
