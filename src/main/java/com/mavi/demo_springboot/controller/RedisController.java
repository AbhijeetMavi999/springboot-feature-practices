package com.mavi.demo_springboot.controller;

import com.mavi.demo_springboot.entity.User;
import com.mavi.demo_springboot.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = redisService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(redisService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getByUserId(@PathVariable Long id) {
        log.info("called getByUserId() from RedisController");
        User user = redisService.getByUserId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        redisService.deleteUserById(id);
        return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }
}
