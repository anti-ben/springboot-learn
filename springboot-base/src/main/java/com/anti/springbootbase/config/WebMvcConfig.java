package com.anti.springbootbase.config;

import com.anti.springbootbase.intercept.OneInterceptor;
import com.anti.springbootbase.intercept.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/**");
    }
}
