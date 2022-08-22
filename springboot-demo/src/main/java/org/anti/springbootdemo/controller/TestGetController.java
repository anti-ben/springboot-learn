package org.anti.springbootdemo.controller;

import org.anti.springbootdemo.domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RestController(value = "getTestController")
@RequestMapping("/prettyget")
@Validated
public class TestGetController {

    @GetMapping("/{num}")
    public Integer detail(@PathVariable("num") @Min(1) @Max(20) Integer num) {
        return num * num;
    }

    @GetMapping("/getByEmail")
    public User getByAccount(@RequestParam @NotBlank @Email String email) {
        User user = new User();
        user.setEmail(email);
        return user;
    }
}

