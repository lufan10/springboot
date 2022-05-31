package com.cn.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("runtime",System.currentTimeMillis());
        Map infoMap = new HashMap();
        infoMap.put("buildTime","2022");
        builder.withDetails(infoMap);
    }
}
