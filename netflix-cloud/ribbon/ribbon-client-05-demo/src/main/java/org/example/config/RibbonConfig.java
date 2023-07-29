package org.example.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import my.example.config.MyRuleConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @RibbonClient(name = "eureka-client", configuration = MyRuleConfig.class) // 自定义负载规则，作用于eureka-client服务
public class RibbonConfig {

    @Bean
    public IRule myRule() {
        // RandomRule 为随机策略
        return  new RandomRule();
    }

}
