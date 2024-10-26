package com.mavi.demo_springboot.schedular;

import com.mavi.demo_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserSchedular {

    @Autowired
    private UserService userService;

    @Scheduled(cron = "*/1 * * * *")  // this means, it automatically run every minute. And you can generate crons from websites like cronmaker.
    public void getAllUsers() {
        userService.getALlUsers();
    }
}
