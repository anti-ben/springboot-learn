package org.anti.springbootdemo.controller;


import org.anti.springbootdemo.domain.User;
import org.anti.springbootdemo.response.ResponseResult;
import org.anti.springbootdemo.response.ResultData;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/hello")
    public ResultData<User> hello(){
        User user=new User(1,"demo",12);
        Assert.notNull(user, "用户不存在！");
        return ResultData.success(user);
    }

    @GetMapping("/error")
    public void empty(){
        throw new RuntimeException("自定义异常");
    }

}
