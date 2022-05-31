package com.cn.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyQuartz{
    @Scheduled(cron = "0/5 * * * * ?")
    public void print(){
//        System.out.println("spring task run ...");
    }
}
