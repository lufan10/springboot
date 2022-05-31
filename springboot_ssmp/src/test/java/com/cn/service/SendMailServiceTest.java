package com.cn.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SendMailServiceTest {
    @Resource
    private SendMailService sendMailService;
    @Test
    void contextLoads(){
        sendMailService.sendMail();
    }
}
