package com.test.base.ch.prov.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@Component
@RefreshScope
public class ProvConfig {
    @Value("${com.prov.name}")
    private String name;
}
