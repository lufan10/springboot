package com.cn.service.impl;
import com.cn.domain.SMSCode;
import com.cn.service.SMSCodeService;
import com.cn.service.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SMSCodeServiceImpl implements SMSCodeService{
    @Resource
    private CodeUtils codeUtils;

    //j2Cache缓存整合框架
    @Resource
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        cacheChannel.set("sms",tele,code);//开启缓存、创建sms缓存空间和加入数据进缓存空间
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = cacheChannel.get("sms", smsCode.getTele()).asString();
        return smsCode.getCode().equals(code);
    }

    //使用jetCache缓存技术创建缓存空间
//    @CreateCache(name = "jetCache_",expire = 3600)
  /*  @CreateCache(name = "jetCache_",expire = 3600,cacheType = CacheType.BOTH)
    private Cache<String,String> jetCache;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        //加入数据进入jetCache缓存空间
        jetCache.put(tele,code);
        return code;
    }
    @Override
    public boolean checkCode(SMSCode smsCode) {
        //缓存jetCache缓存空间获取数据
        String code = jetCache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }*/

    //使用springboot整合的缓存技术
    /* @Override
    @CachePut(value = "smsCode",key = "#tele")
    public String sendCodeToSMS(String tele) {
        return codeUtils.generator(tele);
    }
    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        String cacheCode = codeUtils.get(smsCode.getTele());
        return code.equals(cacheCode);
    }*/

    //使用memcached的Xmemcached客户端缓存技术
   /* @Resource
    private MemcachedClient memcachedClient;
    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        try {
            memcachedClient.set(tele,0,code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code=null;
        try {
            code=memcachedClient.get(smsCode.getTele());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smsCode.getCode().equals(code);
    }*/


}
