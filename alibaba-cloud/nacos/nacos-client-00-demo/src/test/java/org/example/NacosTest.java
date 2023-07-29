package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NacosTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testRegisterInstance() {
        String url = "http://localhost:8848/nacos/v1/ns/instance";

        MultiValueMap params = new LinkedMultiValueMap();
        params.put("ip", "127.0.0.1");
        params.put("port", 8000);
        params.put("serviceName", "nacos-client-00");

        restTemplate.postForObject(url, params, String.class);
    }

    @Test
    public void testSendHeartBeat() {
        String url = "http://localhost:8848/nacos/v1/ns/instance/beat";

        MultiValueMap params = new LinkedMultiValueMap();
        params.add("serviceName", "nacos-client-00");
        params.add("beat", "{\"cluster\":\"\",\"ip\":\"127.0.0.1\",\"metadata\":{},\"port\":8000,\"scheduled\":true,\"serviceName”:”Nacos”,”weight\":1}");

        restTemplate.put(url, params);
    }
}
