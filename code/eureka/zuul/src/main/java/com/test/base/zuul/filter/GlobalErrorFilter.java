package com.test.base.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 新增全局异常处理 在过滤器中将错误信息写入RequestContext中，这样SendErrorFilter就可以获取到信息，并转发到SpringBoot中进行处理
 */
@Component
public class GlobalErrorFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override public String filterType() {
        return FilterConstants.ERROR_TYPE;//类型为error
    }

    @Override public int filterOrder() {
        return 10;//执行顺序：第几个执行 10
    }

    @Override public boolean shouldFilter() {
        return true;//默认对所有请求都支持
    }

    @Override public Object run() throws ZuulException {
        //将错误信息设置到RequestContext中
        RequestContext context = RequestContext.getCurrentContext();
        Throwable throwable = context.getThrowable();
        log.error("[ErrorFilter] error message:{}",throwable.getCause().getMessage());
        context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        context.set("error.exception",throwable.getCause());
        return null;
    }
}
