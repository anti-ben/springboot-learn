package com.anti.springbootsql;

import com.anti.springbootsql.domain.User;
import com.anti.springbootsql.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootSqlApplication.class)
public class CacheTest {

    @Resource
    private UserService userService;

    @Test
    public void testAdd() {
        User user = new User();
        user.setId(13);
        user.setAge(13);
        user.setName("www");
        userService.addUser(user);
    }

    @Test
    public void testUpdate() {
        User user = userService.findById(13).get();
        user.setId(13);
        user.setName("ddd");
        userService.updateUser(user);
    }

    @Test
    public void testSelect() {
        userService.findById(12);
    }

//    @Test
//    public void testDelete() {
//        userService.deleteById(12);
//    }
}
