package com.anti.springbootbase;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
//@EnableAsync        // 启用异步任务
//@EnableScheduling   // 启用定时任务
@SpringBootApplication
public class SpringbootBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBaseApplication.class, args);
    }

}
