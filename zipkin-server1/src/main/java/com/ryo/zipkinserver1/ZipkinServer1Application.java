package com.ryo.zipkinserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

@EnableEurekaClient
@EnableZipkinServer
@SpringBootApplication
public class ZipkinServer1Application {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServer1Application.class, args);
    }
}
