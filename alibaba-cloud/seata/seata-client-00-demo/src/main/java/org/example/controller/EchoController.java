package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RefreshScope
@RestController
public class EchoController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL; //服务提供者的服务名

    @RequestMapping(value = "/rest/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return restTemplate.getForObject(serverURL + "/echo/" + string, String.class);
    }
}
