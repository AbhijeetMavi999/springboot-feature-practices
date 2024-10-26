package com.mavi.demo_springboot.service;

import com.mavi.demo_springboot.entity.User;
import com.mavi.demo_springboot.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(String name) {
        User user = new User();
        user.setUsername(name);
        return userRepository.save(user);
    }

    @Transactional
    public void createMultipleUsers() {
        createUser("Alice");
        createUser("Bob");
//         int result = 1 / 0; // This will throw an ArithmeticException
        createUser("Charlie");
    }

    public List<User> getALlUsers() {
        return userRepository.findAll();
    }
}
