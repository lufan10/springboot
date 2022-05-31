package com.cn.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;

@NoArgsConstructor //表示无参构造器
@AllArgsConstructor //表示有参构造器
@Data //生成get和set方法
@ToString //表示可以生成ToString方法
@Component
@ConfigurationProperties(prefix = "servers")
@Validated //开启对当前类的属性注入校验
public class ServerProperties {
    //私有的成员变量
    private String ipAddress;
    @Max(value = 8888,message = "最大值不能超过8888")
    private int port;
    private long timeout;
}