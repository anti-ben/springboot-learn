package org.anti.springbootdemo.controller;

import org.anti.springbootdemo.domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RestController(value = "prettyTestController")
@RequestMapping("/pretty")
public class TestController {

    @PostMapping("/test-validation")
    public void testValidation(@RequestBody @Validated User user) {

    }
}

