package com.lfs.controller;


import com.lfs.entity.User;
import com.lfs.mapper.UserDao;
import com.lfs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/list")
    private List<User> list() {
        return userService.listAll();
    }


    @PostMapping("/add")
    private String add(@RequestBody User user) {
        int i = 0;
        try {
            i = userService.add(user);
        } catch (RuntimeException e) {
           e.printStackTrace();
        }
        return i == 1 ? "success" : "fail";
    }

}
