package com.tina.spring.cloud.apache.dubbo.provider.service.impl;

import com.tina.spring.cloud.apache.dubbo.api.EchoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String string) {
        return "hello apache dubbo."+string;
    }

    /*测试负载均衡*/
    @Value("${dubbo.protocol.port}")
    private String port;

    @Override
    public String test(String string){
        return "provider负载均衡 test"+string+"i am from port :"+port;
    }


}
