package com.cloud.work.eur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableEurekaServer
@SpringBootApplication
public class EurApplication {

    @PostConstruct
    public void started(){
        setZone();
    }

    /**
     * 设置JVM默认时区
     */
    private static void setZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    public static void main(String[] args) {
        SpringApplication.run(EurApplication.class, args);
    }

}
