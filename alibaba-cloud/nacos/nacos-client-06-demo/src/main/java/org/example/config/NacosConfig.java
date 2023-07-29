package org.example.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient
 * 可以将当前服务实例，注册到nacos注册中心，并持续上报心跳，保持可用状态
 */
@Configuration
@EnableDiscoveryClient
public class NacosConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
