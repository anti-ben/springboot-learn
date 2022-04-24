package com.anti.springbootsql;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableSwagger2Doc
@EnableCaching
@SpringBootApplication
public class SpringbootSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSqlApplication.class, args);
    }

}
