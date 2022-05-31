package com.cn.controller;
import com.cn.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orders")
public class OrderController{
    @Resource
    private OrderService orderservice;

    @PostMapping("{id}")
    public void order(@PathVariable String id) {
        orderservice.order(id);
    }
}
