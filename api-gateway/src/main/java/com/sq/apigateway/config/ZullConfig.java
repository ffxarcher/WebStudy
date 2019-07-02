package com.sq.apigateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@Component
public class ZullConfig {

    @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties zullProperties()
    {
        return new ZuulProperties();
    }
}
