package com.test.base.ch.prov.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@ConfigurationProperties(prefix = "person")
@Data
public class PersonConfig {
    private String name;
    private Integer age;
    private Boolean single;
}
