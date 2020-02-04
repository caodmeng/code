package com.test.base.zuul.filter;

import brave.Tracer;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 输出TraceID的指
 */
@Component
public class TraceIdFilter extends ZuulFilter {
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;
    //自动注入Sleuth的Tracer
    @Autowired
    private Tracer tracer;
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;//类型为post
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {
        //可以通过下面的代码获取TracerId,并将其设置到返回信息中
        RequestContext ctx = RequestContext.getCurrentContext();
        //引入包不正确
        //ctx.getResponse().addHeader("scd-trace-id",this.tracer.getCurrentSpan().tracerIdString());
        return null;
    }
}
