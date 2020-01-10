package com.test.base.zuul.filter;

import com.alibaba.fastjson.serializer.FilterUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 用户认证校验过滤器
 */
@Component
public class JWTTokenFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
  /*  @Autowired
    private FilterUtils filterUtils;
    @Autowired
    private ServiceConfig serviceConfig;*/

    @Override public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override public int filterOrder() {
        return 0;
    }

    @Override public boolean shouldFilter() {
        return false;
    }

    @Override public Object run() throws ZuulException {
        return null;
    }
}
