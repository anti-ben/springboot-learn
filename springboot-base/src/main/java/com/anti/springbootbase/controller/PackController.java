package com.anti.springbootbase.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackController {
    @Value("${project.sign}")
    private String sign;

    @RequestMapping("/getSign")
    public String getSign() {
        return sign;
    }
}
