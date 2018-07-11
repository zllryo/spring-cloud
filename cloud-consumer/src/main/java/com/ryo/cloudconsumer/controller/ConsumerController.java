package com.ryo.cloudconsumer.controller;

import com.ryo.cloudconsumer.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable(value = "name")String name)
    {
        return  helloRemote.hello(name);
    }


    @RequestMapping("/hi/{name}")
    public String hi(@PathVariable(value = "name")String name)
    {
        return  helloRemote.hi(name);
    }

    @ResponseBody
    @RequestMapping("/")
    public String he()
    {
        return "hi";
    }


}
