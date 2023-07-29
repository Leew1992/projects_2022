package org.example.service.impl;

import org.example.service.EchoService;
import org.springframework.stereotype.Service;

@Service
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String string) {
        return "hello: nacos-client-06: " + string;
    }
}
