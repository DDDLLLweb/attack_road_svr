package com.el.security.service;

import com.el.security.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/**
 * @author danfeng
 * @since 2018/4/24
 */
@Service
public class UserService {
    /**
     * 模拟查询返回用户信息
     * @param uname
     * @return
     */
    public User findUserByName(String uname){
        User user = new User();
        user.setUsername(uname);
        user.setNick(uname+"NICK");
        user.setPassword("J/ms7qTJtqmysekuY8/v1TAS+VKqXdH5sB7ulXZOWho=");//密码明文是123456
        user.setSalt("wxKYXuTPST5SG0jMQzVPsg==");//加密密码的盐值
        user.setUserId(new Random().nextLong());//随机分配一个id
        user.setCreateTime(LocalDateTime.now());
        return user;
    }
}
