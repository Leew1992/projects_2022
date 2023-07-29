package org.example.client.service;

import org.example.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-client-06", configuration = FeignConfig.class)
@Component
public interface EchoService {
    @GetMapping("/echo/{string}")
    String echo(@PathVariable String string);
}
