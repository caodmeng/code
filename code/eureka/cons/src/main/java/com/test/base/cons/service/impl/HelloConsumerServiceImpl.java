package com.test.base.cons.service.impl;


import com.test.base.cons.fc.HelloServiceFc;
import com.test.base.cons.service.IHelloConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author caodm3
 * @date: 2019年07月09日  21:49
 */
@Service
public class HelloConsumerServiceImpl implements IHelloConsumerService {
	@Autowired
	HelloServiceFc helloServiceFc;

	@Override
	//@HystrixCommand(fallbackMethod = "fallHello")
	public String hello(String name) {
		return helloServiceFc.hello(name);
	}

	@Override
	public String name() {
		return helloServiceFc.name();
	}

	@Override public String person() {
		return helloServiceFc.person();
	}

	protected String fallHello(String name) {
		return "fallHello" + name;
	}
}
