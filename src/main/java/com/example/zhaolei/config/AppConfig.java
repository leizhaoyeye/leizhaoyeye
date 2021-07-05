package com.example.zhaolei.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.zhaolei")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AppConfig {
}
