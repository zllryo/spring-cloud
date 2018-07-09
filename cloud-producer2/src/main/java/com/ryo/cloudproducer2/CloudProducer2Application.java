package com.ryo.cloudproducer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudProducer2Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProducer2Application.class, args);
    }
}
