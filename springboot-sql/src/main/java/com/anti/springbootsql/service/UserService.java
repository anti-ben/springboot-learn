package com.anti.springbootsql.service;

import com.anti.springbootsql.domain.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface UserService {

    @Transactional(isolation = Isolation.DEFAULT)
    void addUser(User user);

    @Transactional(isolation = Isolation.DEFAULT)
    void updateUser(User user);

    Optional<User> findById(Integer id);

    User findUser(String name);

    User findByNameAndAge(String name, Integer age);

    void deleteById(Integer id);
}