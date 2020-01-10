package com.test.base.cons.fc;


import com.test.base.cons.fallback.HelloFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @author caodm3
 * @date: 2019年07月09日  21:51
 */
@FeignClient(value = "prov",fallback = HelloFallBack.class)
public interface HelloServiceFc {
	@RequestMapping(value = "/hello-provider/hello/{name}", method = RequestMethod.GET)
	String hello(@PathVariable String name);

	@RequestMapping(value = "/hello-provider/name", method = RequestMethod.GET)
	String name();

	@RequestMapping(value = "/hello-provider/person", method = RequestMethod.GET)
	String person();
}
