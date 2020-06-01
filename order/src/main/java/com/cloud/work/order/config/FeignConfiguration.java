package com.cloud.work.order.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：Feign配置文件
 * 对请求头的信息进行处理，使用Base64进行加密，以实现访问inventory模块
 *
 * @ClassName FeignConfig
 * @Author 徐旭
 * @Date 2020-06-01 09:54
 * @Version 1.0
 */
@Configuration
public class FeignConfiguration {

    @Value("${security.user}")
    private String user;

    @Value("${security.password}")
    private String password;

    /**
     * 处理spring security权限配置
     *
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor authRequestInterceptor() {
        return new BasicAuthRequestInterceptor(user, password);
    }
}
