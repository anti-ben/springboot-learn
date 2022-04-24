package com.anti.springbootaop.controller;

import com.anti.springbootaop.config.LogFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPController {

    @LogFilter("保存请求日志")
    @RequestMapping("/saveRequestLog")
    public String saveRequestLog(@RequestParam("name") String name) {
        return "success：" + name;
    }

    @LogFilter("保存异常日志")
    @RequestMapping("/saveExceptionLog")
    public String saveExceptionLog(@RequestParam("name") String name) {
        int error = 100 / 0;
        System.out.println(error);
        return "success：" + name;
    }
}
