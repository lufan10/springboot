package com.cn.service.linsener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageKafkaListener {
    @KafkaListener(topics = "dijia")
    public void message(ConsumerRecord<String,String> record){
        System.out.println("已完成短信发送业务(kafka)，id："+record);
    }
}
