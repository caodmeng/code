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

	@Override
	public String name() {
		return this.fallName();
	}

	@Override public String person() {
		return this.fallPerson();
	}

	protected String fallHello(String name) {
		return "fallHello" + name;
	}

	protected String fallName() {
		return " fallName config名称读取失败！";
	}

	protected String fallPerson() {
		return "fallPerson config名称读取失败！";
	}
}
