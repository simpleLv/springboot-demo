package com.lfs.service.impl;

import com.lfs.entity.User;
import com.lfs.mapper.UserDao;
import com.lfs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(User user) {
        int i = userDao.insertSelective(user);
        if (i == 1) {
            log.info("插入的user的id为=>" + user.getId());
        }
        //测试异常
        int b = 1 / 0;
        return i;
    }

    @Override
    public List<User> listAll() {
        return userDao.selectByExample(null);
    }
}
