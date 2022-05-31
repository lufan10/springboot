package com.cn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
//@EnableCaching //开启spring默认缓存功能
//@EnableCreateCacheAnnotation //开启jetCach缓存功能
//@EnableMethodCache(basePackages = {"com.cn"}) //开启jetCach方法注解缓存
@EnableScheduling //开启定时任务功能
public class SSMPApplication {
	public static void main(String[] args) {
		SpringApplication.run(SSMPApplication.class);

	}

}
