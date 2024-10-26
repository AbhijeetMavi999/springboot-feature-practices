package com.mavi.demo_springboot.schedular;

import com.mavi.demo_springboot.entity.User;
import com.mavi.demo_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSchedular {

    @Autowired
    private UserService userService;

//    @Scheduled(cron = "0/10 * * * * *")  // this means, it automatically run every 10 seconds. And you can generate crons from websites like cronmaker.
    public void getAllUsers() {
        List<User> user = userService.getALlUsers();
        System.out.println("Users: "+user.get(1));
    }
}
