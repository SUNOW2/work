package com.cloud.work.inventory.config;

import com.cloud.work.inventory.interceptor.SeataRestTemplateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 描述：Seata配置类
 *
 * @ClassName SeataRestTemplateAutoConfiguration
 * @Author 徐旭
 * @Date 2020-07-06 13:21
 * @Version 1.0
 */
@Configuration
public class SeataRestTemplateAutoConfiguration {

    @Autowired(required = false)
    private Collection<RestTemplate> restTemplates;

    @Autowired
    private SeataRestTemplateInterceptor seataRestTemplateInterceptor;

    public SeataRestTemplateAutoConfiguration() {
    }

    @Bean
    public SeataRestTemplateInterceptor seataRestTemplateInterceptor() {
        return new SeataRestTemplateInterceptor();
    }

    @PostConstruct
    public void init() {
        if (this.restTemplates != null) {
            Iterator<RestTemplate> iterator = this.restTemplates.iterator();
            while (iterator.hasNext()) {
                RestTemplate template = iterator.next();
                List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
                interceptors.add(this.seataRestTemplateInterceptor);
                template.setInterceptors(interceptors);
            }
        }
    }
}
