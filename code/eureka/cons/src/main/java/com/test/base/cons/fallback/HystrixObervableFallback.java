package com.test.base.cons.fallback;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

/**
 * @Description: 继承HystrixObservableCommand实现服务降级
 * @author caodm3
 * @date: 2019年08月01日  0:00
 */

public class HystrixObervableFallback extends HystrixObservableCommand<String> {

	private String name;

	public HystrixObervableFallback() {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("test")));
	}

	public HystrixObervableFallback(String name) {

		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("test")));
		this.name = name;
	}


	@Override
	protected Observable<String> construct() {
		// 实现具体的业务处理逻辑
		return null;
	}

	@Override
	protected Observable<String> resumeWithFallback() {
		// 实现服务降级处理逻辑
		return super.resumeWithFallback();
	}
}
