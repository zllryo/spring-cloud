package com.ryo.cloudconsumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello" +name+", this messge send failed ";
    }

    @Override
    public String hi(@RequestParam(value = "name") String name) {
        return "hi" +name+", this messge send failed ";
    }
}
