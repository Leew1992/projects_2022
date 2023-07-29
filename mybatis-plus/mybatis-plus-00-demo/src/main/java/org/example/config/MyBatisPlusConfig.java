package org.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("org.example.mapper")
@Configuration
public class MyBatisPlusConfig {
}
