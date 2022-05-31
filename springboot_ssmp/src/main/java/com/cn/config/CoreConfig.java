package com.cn.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.cn.quartz.MyQuartz;
import com.cn.quartz.MyQuartz2;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MP分页拦截器、memcached缓存技术、定时任务技术
 */
@Configuration
public class CoreConfig {
    @Bean
    public JobDetail printJodDetail(){
        //绑定具体工作
        return JobBuilder
                .newJob(MyQuartz2.class)
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger printJobTrigger(){
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //绑定具体工作
        return TriggerBuilder.newTrigger()
                .forJob(printJodDetail())
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
//    @Resource
//    private XMemcachedProperties xMemcachedProperties;
//    @Bean
//    public MemcachedClient getMemcachedClient() throws IOException {
////        XMemcachedClientBuilder memcachedClientBuild = new XMemcachedClientBuilder("localhost:11211");
//        XMemcachedClientBuilder memcachedClientBuild = new XMemcachedClientBuilder(xMemcachedProperties.getServers());
//        memcachedClientBuild.setConnectionPoolSize(xMemcachedProperties.getPoolSize());
//        memcachedClientBuild.setOpTimeout(xMemcachedProperties.getOpTimeout());
//        MemcachedClient memcachedClient = memcachedClientBuild.build();
//        return memcachedClient;
//    }

}
