package com.ryo.cloudribbon.controller;

import com.ryo.cloudribbon.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/hello/{name}" )
    public String hello(@PathVariable(value = "name")String name) {
        this.loadBalancerClient.choose("spring-cloud-producer");//随机访问策略
        return computeService.hello(name);
        //return restTemplate.getForEntity("http://spring-cloud-producer/hello?name="+name, String.class).getBody();
    }
}
