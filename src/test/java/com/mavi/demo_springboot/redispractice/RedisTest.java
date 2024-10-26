package com.mavi.demo_springboot.redispractice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Disabled
    @Test
    void testSaveUserName() {
        redisTemplate.opsForValue().set("username", "abhijeetmavi");
        Object username = redisTemplate.opsForValue().get("username");
        Object salary = redisTemplate.opsForValue().get("salary");  // the salary value is set from redis cli
    }
}
