package com.ryo.cloudribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hello/{name}" )
    public String hello(@PathVariable(value = "name")String name) {
        return restTemplate.getForEntity("http://spring-cloud-producer/hello?name="+name, String.class).getBody();
    }
}
