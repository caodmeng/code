package com.test.base.cons.fallback;

import com.test.base.cons.fc.HelloServiceFc;
import org.springframework.stereotype.Component;

/**
 * @Description: 降级服务
 * @author caodm3
 * @date: 2019年08月01日  0:01
 */
@Component
public class HelloFallBack implements HelloServiceFc {
	@Override
	public String hello(String name) {
		return this.fallHello(name);
	}

	protected String fallHello(String name) {
		return "fallHello" + name;
	}
}
