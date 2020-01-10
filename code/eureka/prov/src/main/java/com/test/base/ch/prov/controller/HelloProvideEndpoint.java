package com.test.base.ch.prov.controller;

import com.test.base.ch.prov.config.ProvConfig;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private ProvConfig config;
	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String hello(@PathVariable String name) {
		String hello = "Hello";
		return hello + name + "!";
	}
	@RequestMapping(value = "/name",method = RequestMethod.GET)
	public String name(){
		return config.getName();
	}
}
