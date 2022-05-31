package com.cn.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MP分页拦截器、memcached缓存技术
 */
@Configuration
public class CoreConfig {
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
