package com.sq.sever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SeverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeverApplication.class, args);
    }

}
