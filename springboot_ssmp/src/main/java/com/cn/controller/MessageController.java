package com.cn.controller;
import com.cn.service.MessageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//
//@RestController
//@RequestMapping("/msg")
public class MessageController  {
    @Resource
    private MessageService messageservice;

//    @GetMapping
//    public String doMessage() {
//        String id = messageservice.doMessage();
//        return id;
//    }
}
