package com.cn.service.impl.kafka;

import com.cn.service.MessageService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageServiceKafkaImpl implements MessageService {

    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;
    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已列入消息队列(kafka)，id："+id);
        kafkaTemplate.send("dijia",id);
    }

    @Override
    public String doMessage() {
        return null;
    }
}
