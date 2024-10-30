package com.mavi.demo_springboot.service;

import com.mavi.demo_springboot.entity.User;
import com.mavi.demo_springboot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RedisService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Cacheable(key = "#id", value = "users")
    public User getByUserId(Long id) {
        log.info("called getByUserId() from RedisService");
        return userRepository.findById(id).orElse(null);
    }

    @CacheEvict(key = "#id", value = "users")
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}

// For Update use @CachePut(key = "#id", value = "users")
