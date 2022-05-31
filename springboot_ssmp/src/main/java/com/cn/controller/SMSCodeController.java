package com.cn.controller;
import com.cn.domain.SMSCode;
import com.cn.service.SMSCodeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sms")
public class SMSCodeController{
    @Resource
    private SMSCodeService smscodeservice;

    @GetMapping()
    public String sendCodeToSMS(String tele) {
        return smscodeservice.sendCodeToSMS(tele);
    }

    @PostMapping
    public boolean checkCode(@RequestBody SMSCode smsCode) {
        return smscodeservice.checkCode(smsCode);
    }
}
