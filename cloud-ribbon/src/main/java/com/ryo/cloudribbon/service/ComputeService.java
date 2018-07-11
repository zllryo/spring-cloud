package com.ryo.cloudribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputeService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="ServiceFallback")
    public String hello(String name)
    {
       return  restTemplate.getForEntity("http://spring-cloud-producer/hello?name="+name, String.class).getBody();
    }


    @HystrixCommand(fallbackMethod="ServiceFallback")
    public String hi(String name)
    {
        return  restTemplate.getForEntity("http://spring-cloud-producer/hi?name="+name, String.class).getBody();
    }


    /*
    *
    * 参数要与原方法一致
    *
    * * */
    public  String ServiceFallback(String name)
    {
        return "error";
    }
}
