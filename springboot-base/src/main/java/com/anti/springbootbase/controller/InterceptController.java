package com.anti.springbootbase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptController {

    @RequestMapping("/intercept")
    public String intercept() {
        return "success";
    }

}
