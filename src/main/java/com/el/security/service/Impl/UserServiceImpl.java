package com.el.security.service.Impl;

import com.el.security.entity.User;
import com.el.security.mapper.UserMapper;
import com.el.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/**
 * @author danfeng
 * @since 2018/4/24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 用户登录
     * @param uname
     * @return
     */
    @Override
    public User findUserByName(String uname){
        return userMapper.findUserByName(uname);
    }
}
