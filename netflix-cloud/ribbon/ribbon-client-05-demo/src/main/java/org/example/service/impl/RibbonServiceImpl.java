package org.example.service.impl;

import org.example.service.RibbonService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class RibbonServiceImpl implements RibbonService {

    private static final String REST_URL_PROVIDER_PREFIX = "http://eureka-client/eureka";

    @Resource
    private RestTemplate restTemplate;

    @Override
    public String get() {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/get", String.class);
    }

    @Override
    public String sleep(Integer time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sleep finish!";
    }

    @Override
    public String breaker(Integer id) {
        if (id == null || id < 0) {
            throw new RuntimeException("id can't be negaive number");
        }
        return String.valueOf(id);
    }
}
