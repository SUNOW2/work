package com.cloud.work.order.interceptor;

import io.seata.core.context.RootContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

/**
 * 描述：
 *
 * @ClassName SeataRestTemplateInterceptor
 * @Author 徐旭
 * @Date 2020-07-06 15:39
 * @Version 1.0
 */
public class SeataRestTemplateInterceptor implements ClientHttpRequestInterceptor {
    public SeataRestTemplateInterceptor(){}
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(httpRequest);
        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
            requestWrapper.getHeaders().add(RootContext.KEY_XID, xid);
        }
        return clientHttpRequestExecution.execute(requestWrapper, bytes);
    }
}
