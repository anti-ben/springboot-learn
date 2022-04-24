package com.anti.springbootsql.service.imple;

import com.anti.springbootsql.domain.User;
import com.anti.springbootsql.service.UserRepository;
import com.anti.springbootsql.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;


@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    @CachePut(value = "addUser")
    public void addUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    @CachePut(value = "updateUser")
    public void updateUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    @Cacheable(cacheNames = "findById", key = "#id")
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUser(String name) {
        return userRepository.findUser(name);
    }

    @Override
    public User findByNameAndAge(String name, Integer age) {
        return userRepository.findByNameAndAge(name, age);
    }

    @Override
    @CacheEvict(value = "findById", key = "#id", beforeInvocation = true)
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}