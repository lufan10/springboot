package com.cn.domain;

import com.cn.service.SMSCodeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor //表示无参构造器
@AllArgsConstructor //表示有参构造器
@Data //生成get和set方法
@ToString //表示可以生成ToString方法
public class SMSCode  {
    //私有的成员变量
//    private Integer id;
    private String tele;
    private String code;

}