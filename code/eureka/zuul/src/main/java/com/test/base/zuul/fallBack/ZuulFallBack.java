package com.test.base.zuul.fallBack;

import com.alibaba.fastjson.JSON;
import com.test.base.zuul.fallBack.exc.BizException;
import com.test.base.zuul.fallBack.exc.CommonConst;
import com.test.base.zuul.fallBack.exc.DateUtil;
import com.test.base.zuul.fallBack.exc.ErrorInfo;
import com.test.base.zuul.fallBack.exc.ErrorType;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 网关调用回退
 * @author caodm3
 * @date: 2019年08月15日  0:15
 */
@Component
public class ZuulFallBack implements FallbackProvider {
	private static final Logger LOG = LoggerFactory.getLogger(ZuulFallBack.class);
	@Override
	public String getRoute() {
		//注意：这里指的是route的名称，而不是服务的名称
		//如果这里写成大些CON,则将无法起到回退作用，*代表所有
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		//创建一个Fallback的响应
		return new ClientHttpResponse() {
			//实现响应的状态、状态码的定义
			/**
			 * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
			 * 不应该把api的404,500等问题抛给客户端
			 * 网关和api服务集群对于客户端来说是黑盒子
			 */
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.OK.value();//200
			}

			@Override
			public String getStatusText() throws IOException {
				return HttpStatus.OK.getReasonPhrase();
			}

			@Override
			public void close() {
				//可针对服务构建服务信息

			}

			@Override
			public InputStream getBody() throws IOException {
				String errorMsg = cause.getCause().getLocalizedMessage();
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setErrorInfo(ErrorType.zuulError);
				errorInfo.setError("Connection errror");
				errorInfo.setTimestamp(DateUtil.getNow());
				if (!StringUtils.isEmpty(errorMsg)) {
					errorInfo.setMessage(errorMsg);
				}
				if (cause instanceof BizException) { //业务控制异常，只打印错误日志头信息
					LOG.error(errorMsg);
				} else {
					LOG.error(errorMsg, cause);
				}
				return new ByteArrayInputStream(JSON.toJSONString(errorInfo).getBytes(CommonConst.Encoding.DEFAULT));
			}

			@Override
			public HttpHeaders getHeaders() {
				//需要将返回的格式设置为json
				HttpHeaders headers = new HttpHeaders();
				//和body中的内容编码一致，否则容易乱码
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}
		};
	}
}
