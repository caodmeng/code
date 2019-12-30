package com.example.cons.fallback;

import com.example.cons.fc.HelloServiceFc;
import org.springframework.stereotype.Component;

/**
 * @Description: 转发失败降级
 * @author caodm3
 * @date: 2019年07月09日  22:40
 */
@Component
public class HelloServiceFallback implements HelloServiceFc {
	@Override
	public String hello(String name) {
		return "Hello," + name + ",I am fallback!";
	}
}
