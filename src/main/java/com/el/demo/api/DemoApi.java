package com.el.demo.api;

import com.el.demo.domain.User;
import com.el.demo.mapper.DemoUserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author danfeng
 * @since 2018/4/10
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/demo")
public class DemoApi {

    private final DemoUserMapper demoUserMapper;

    @RequestMapping("/getUser")
    @Cacheable(value="user-key")
    public List<User> getUser() {
        List<User> users=demoUserMapper.selectAll();
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return users;
    }
    @RequestMapping("/user")
    public User userOf() {
        User user = new User(){{
           setId(1);
           setPassword("aaaa");
           setUsername("ddf");
        }};
        log.info("user-->,{}",user);
        return user;
    }
}
