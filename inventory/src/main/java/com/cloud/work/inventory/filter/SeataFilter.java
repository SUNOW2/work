package com.cloud.work.inventory.filter;

import io.seata.core.context.RootContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 描述：拦截器，全局事务ID的跨服务传递
 *
 * @ClassName SeataFilter
 * @Author 徐旭
 * @Date 2020-07-06 13:13
 * @Version 1.0
 */
@Component
public class SeataFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String xid = req.getHeader(RootContext.KEY_XID.toLowerCase());
        boolean isBind = false;
        if (StringUtils.isNotBlank(xid)) {
            RootContext.bind(xid);
            isBind = true;
        }

        try {
            chain.doFilter(request, response);
        } finally {
            if (isBind) {
                RootContext.unbind();
            }
        }
    }

    @Override
    public void destroy() {
    }
}
