package com.example.zhaolei.config;

import com.example.zhaolei.lanjieqi.LanJieQi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class LanJieQiConfig implements WebMvcConfigurer {

    //注册拦截器
    @Bean
    public LanJieQi myInterceptor(){
        return new LanJieQi();
    }

    //添加拦截器到spring mvc拦截器链
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/*");
    }
}
