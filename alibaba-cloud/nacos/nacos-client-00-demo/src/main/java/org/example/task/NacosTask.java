package org.example.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Component
public class NacosTask {

    @Resource
    private RestTemplate restTemplate;

    @Scheduled(cron = "*/5 * * * * ?")
    public void sendHeartBeat() {
        String url = "http://localhost:8848/nacos/v1/ns/instance/beat";

        MultiValueMap params = new LinkedMultiValueMap();
        params.add("serviceName", "nacos-client-00");
        params.add("beat", "{\"cluster\":\"\",\"ip\":\"127.0.0.1\",\"metadata\":{},\"port\":8000,\"scheduled\":true,\"serviceName”:”Nacos”,”weight\":1}");

        restTemplate.put(url, params);
    }
}
