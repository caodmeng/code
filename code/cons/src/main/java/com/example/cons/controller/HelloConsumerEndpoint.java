package com.example.cons.controller;

import com.example.cons.service.IHelloConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: Hello测试
 * @author caodm3
 * @date: 2019年07月09日  21:44
 */
@RestController
@RequestMapping("/hello")
public class HelloConsumerEndpoint {
	@Autowired
	IHelloConsumerService iHelloConsumerService;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String hello(@PathVariable String name) {
		return iHelloConsumerService.hello(name);
	}
}
