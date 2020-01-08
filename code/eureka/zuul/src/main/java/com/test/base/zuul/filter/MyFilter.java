package com.test.base.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
 * pre：路由之前  在请求被路由之前调用，可用来实现身份认证，在集群中选择请求的微服务、记录调试信息
 * routing：路由之时 在调用目标服务之前被调用，通常可以用来处理一些动态路由
 * post： 路由之后  在目标微服务执行之后，所返回的结果在送回给客户端时被调用，用于数据采集、统计信息和指标，审计日志处理
 * error：发送错误调用   在处理请求过程中发生错误时被调用 实现对异常、错误的统一处理，从而为客户端调用显示更加友好的界面
 * filterOrder：过滤的顺序   优先级为0，数字越大，优先级越低
 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 */
@Component
public class MyFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    @Override public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override public int filterOrder() {
        return 0;
    }

    @Override public boolean shouldFilter() {
        return true;
    }

    @Override public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}

