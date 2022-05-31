package com.cn.service;

import com.cn.domain.SMSCode;
import org.springframework.stereotype.Service;

public interface SMSCodeService {
    String sendCodeToSMS(String tele);
    boolean checkCode(SMSCode smsCode);
}
