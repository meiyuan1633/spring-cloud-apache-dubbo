package com.tina.spring.cloud.apache.dubbo.business.controller;

import com.tina.spring.cloud.apache.dubbo.api.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    /*使用dubbo下的注解*/
    @Reference(version = "1.0.0")
    private EchoService echoService;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string){
        return echoService.echo(string);
    }

    /*测试负载均衡*/
    @GetMapping(value = "/test/{string}")
    public String test(@PathVariable String string){
        return echoService.test(string);
    }
}
