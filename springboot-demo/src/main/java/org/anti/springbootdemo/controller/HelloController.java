package org.anti.springbootdemo.controller;


import org.anti.springbootdemo.domain.User;
import org.anti.springbootdemo.response.ResponseResult;
import org.anti.springbootdemo.response.Result;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping(value = "/returnString", produces = "application/json; charset=UTF-8")
    public String returnString() {
        return "success";
    }

    @GetMapping("/hello")
    public Result<User> hello() {
        User user = new User(1, "demo", 12);
        Assert.notNull(user, "用户不存在！");
        return Result.success(user);
    }

    @GetMapping("/error")
    public void empty() {
        throw new RuntimeException("自定义异常");
    }

}
