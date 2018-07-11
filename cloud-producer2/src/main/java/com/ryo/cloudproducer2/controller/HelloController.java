package com.ryo.cloudproducer2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public  String hello(@RequestParam(value = "name") String name)
    {
        return name+"hello2";
    }

    @RequestMapping("/hi")
    public String Hi(@RequestParam(value = "name") String name)
    {
        return  name+"hi2";
    }
}
