package com.el.security.service;

import com.el.security.entity.Menu;
import com.el.security.entity.User;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/7/10
 */
public interface UserService {
    /***
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    User findUserByName(String userName);



}
