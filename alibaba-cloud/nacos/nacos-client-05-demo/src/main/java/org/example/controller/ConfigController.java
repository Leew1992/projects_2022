package org.example.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${config.info:aaa}")
    private String configInfo;

    @GetMapping("/get")
    public String get() {
        return "useLocalCache: " + useLocalCache + "; configInfo: " + configInfo;
    }
}
