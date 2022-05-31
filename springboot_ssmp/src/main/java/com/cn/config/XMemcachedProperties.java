package com.cn.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@NoArgsConstructor //表示无参构造器
@AllArgsConstructor //表示有参构造器
@Data //生成get和set方法
@ToString //表示可以生成ToString方法
@Component
@ConfigurationProperties(prefix = "memcached")
public class XMemcachedProperties {
    //私有的成员变量
   private String servers;
   private int poolSize;
   private long opTimeout;

}