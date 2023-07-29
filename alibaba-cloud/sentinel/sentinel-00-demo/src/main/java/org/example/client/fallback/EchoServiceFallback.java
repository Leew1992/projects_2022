package org.example.client.fallback;

import org.example.client.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String string) {
        return "echo service fall back!";
    }
}
