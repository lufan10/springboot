package com.cn.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean condition =true;
        if(condition){
            builder.withDetail("runtime",System.currentTimeMillis());
            Map infoMap = new HashMap();
            infoMap.put("buildTime","2022");
            builder.withDetails(infoMap);
            builder.status(Status.UP);
        }else{
            builder.withDetail("上线了吗？","别做梦");
            builder.status(Status.DOWN);

        }
    }
}
