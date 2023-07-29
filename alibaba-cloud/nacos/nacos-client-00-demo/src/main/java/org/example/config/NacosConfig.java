package org.example.config;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

@NacosPropertySource(dataId = "nacos-client-00", autoRefreshed = true)
@Configuration
public class NacosConfig {
}
