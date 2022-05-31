package com.cn.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service
public class SendMailServiceImpl2 implements SendMailService{
    @Resource
    private JavaMailSender javaMailSender;

    private String from="dijia4220@qq.com"; //发送人
    private String to="dijia4220@126.com"; //接收人
    private String subject="测试邮件"; //标题
    private String context="测试邮件正文内容"; //正文
    @Override
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from+"(道修凡)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }
}
