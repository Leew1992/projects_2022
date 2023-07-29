package org.example.client.service;

import org.example.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ribbon-client", configuration = FeignConfig.class)
@Component
public interface RibbonService {

    @GetMapping("/ribbon/get")
    String get();

    @GetMapping("/ribbon/sleep/{time}")
    String sleep(@PathVariable Integer time);
}
