package com.cn.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//springMVC的异常处理器
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R doException(Exception e){
        //记录日志、通知运维、通知开发
        e.printStackTrace();
        return new R("服务器故障,请稍后再试！");
    }
}
