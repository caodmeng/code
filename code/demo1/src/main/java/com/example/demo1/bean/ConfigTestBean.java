package com.example.demo1.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description:
 *
 * test配置文件测试
 *
 * @author caodm3
 * @date: 2019年05月03日  1:16
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "com.md", ignoreUnknownFields = false)
@PropertySource("classpath:test/test.properties")
@Component
public class ConfigTestBean {
	private String cc;
	private String dd;
}
