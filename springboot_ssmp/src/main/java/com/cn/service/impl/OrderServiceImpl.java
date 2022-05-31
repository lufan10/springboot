package com.cn.service.impl;

import com.cn.service.MessageService;
import com.cn.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单业务
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private MessageService messageService;
    @Override
    public void order(String id) {
        //一系列操作，包括各种服务调用，处理各种业务
        System.out.println("订单处理开始");
        //短信消息处理
        messageService.sendMessage(id);
        System.out.println("订单处理结束");
        System.out.println();
    }
}
