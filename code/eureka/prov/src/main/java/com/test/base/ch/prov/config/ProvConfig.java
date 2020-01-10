package com.test.base.ch.prov.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
public class ProvConfig {
    @Value("$(com.prov.name)")
    private String name;
}
