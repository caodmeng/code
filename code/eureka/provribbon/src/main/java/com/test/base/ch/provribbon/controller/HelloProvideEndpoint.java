package com.test.base.ch.provribbon.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: Hello测试
 * @author caodm3
 * @date: 2019年07月09日  21:38
 */
@RestController
@RequestMapping("/hello-provider")
public class HelloProvideEndpoint {
	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String hello(@PathVariable String name) {
		String hello = "Hello";
		return hello + name + "!！！！";
	}
}
