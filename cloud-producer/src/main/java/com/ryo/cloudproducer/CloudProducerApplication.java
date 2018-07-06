package com.ryo.cloudproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProducerApplication.class, args);
    }
}
