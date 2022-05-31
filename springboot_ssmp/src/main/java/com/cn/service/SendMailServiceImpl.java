package com.cn.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailServiceImpl implements SendMailService{
    @Resource
    private JavaMailSender javaMailSender;

    private String from="dijia4220@qq.com"; //发送人
    private String to="dijia4220@126.com"; //接收人
    private String subject="测试邮件"; //标题
    private String context="<img src='https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Fafcc244147c5ccaecf60dc7afa0307083a48706c.jpg&refer=http%3A%2F%2Fi0.hdslb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1656290394&t=cd0ea070c43d54637e165b2debc1dad1'><a href='https://www.baidu.com/'>点开有惊喜</a>"; //正文
    @Override
    public void sendMail() {
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from+"(道修凡)");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context,true);
            File file = new File("C:\\SpringBoot\\springboot_ssmp\\src\\main\\resources\\1.jpeg");
            File file1 = new File("F:\\电脑小知识 - 副本.txt");
            helper.addAttachment("二次元.jpeg",file);
            helper.addAttachment(file1.getName(),file1);
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
