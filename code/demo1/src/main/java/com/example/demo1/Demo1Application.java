package com.example.demo1;

import com.example.demo1.bean.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
public class Demo1Application {
	@RequestMapping("/")
	public String index(){
		return "Hello Word!";
	}
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
