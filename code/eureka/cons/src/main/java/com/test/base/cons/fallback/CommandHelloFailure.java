package com.test.base.cons.fallback;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @Description: 继承HystrixCommand的降级代码
 * @author caodm3
 * @date: 2019年07月31日  23:42
 */

public class CommandHelloFailure extends HystrixCommand<String> {
	private String name;

	protected CommandHelloFailure(String name) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")));
		this.name = name;
	}

	@Override
	protected String run() throws Exception {
		//在这里实现具体的业务逻辑
		return "Hello Failure" + this.name;
	}

	@Override
	protected String getFallback() {

		// 实现服务降级处理逻辑
		return "Hello Failure" + this.name + "!";
	}
}
