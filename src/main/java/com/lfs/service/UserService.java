package com.lfs.service;

import com.lfs.entity.User;

import java.util.List;

public interface UserService {

    int add(User user);

    List<User> listAll();
}
