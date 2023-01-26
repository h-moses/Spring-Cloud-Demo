package com.ms.cloud_alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlibabaConsumerMain83 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConsumerMain83.class, args);
    }
}
