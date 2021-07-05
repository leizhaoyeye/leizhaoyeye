package com.example.zhaolei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.zhaolei.mapper")
public class ZhaoleiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhaoleiApplication.class, args);
    }

}
