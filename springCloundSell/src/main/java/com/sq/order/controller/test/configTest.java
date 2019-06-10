package com.sq.order.controller.test;

import com.sq.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class configTest {
    @Value("${env}")
    private  String env;
    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/testConfig")
    public String testConfig()
    {

        return girlConfig.getName()+" age:"+ girlConfig.getAge();

    }
}
