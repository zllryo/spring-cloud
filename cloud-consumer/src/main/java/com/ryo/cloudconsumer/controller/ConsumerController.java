package com.ryo.cloudconsumer.controller;

import com.ryo.cloudconsumer.service.HelloRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@Api(value = "Consumer操作controller", description = "Consumer相关的操作", tags = {"Consumer模块校验接口"})
@RestController
public class ConsumerController {
    @Autowired
    private HelloRemote helloRemote;

    @ApiOperation(value="获取Consumer详细信息", notes="根据url的name来获取girls详细信息")
    @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String", paramType = "path")
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable(value = "name")String name)
    {
        return  helloRemote.hello(name);
    }

    @ApiOperation(value="获取Consumer详细信息", notes="根据url的name来获取girls详细信息")
    @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String", paramType = "path")
    @RequestMapping("/hi/{name}")
    public String hi(@PathVariable(value = "name")String name)
    {
        return  helloRemote.hi(name);
    }

    @ApiIgnore
    @ResponseBody
    @RequestMapping("/")
    public String he()
    {
        return "hi";
    }


}
