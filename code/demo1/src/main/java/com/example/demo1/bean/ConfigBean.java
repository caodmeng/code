package com.example.demo1.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description:
 *
 * userBean配置
 *
 * @author caodm3
 * @date: 2019年05月03日  0:50
 */
@Data
@ConfigurationProperties(prefix = "com.caodm")
public class ConfigBean {
	private String name;
	private String want;
	private String yerHope;
}
