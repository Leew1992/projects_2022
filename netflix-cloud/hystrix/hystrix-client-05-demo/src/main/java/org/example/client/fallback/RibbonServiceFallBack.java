package org.example.client.fallback;

import org.example.client.service.RibbonService;
import org.springframework.stereotype.Component;

@Component
public class RibbonServiceFallBack implements RibbonService {

    @Override
    public String get() {
        return "fallback get time out!";
    }

    @Override
    public String sleep(Integer time) {
        return "fallback sleep time out";
    }
}
