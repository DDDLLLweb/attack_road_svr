package com.el;

import baseclass.ExcuteTest;
import com.el.demo.mapper.DemoUserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author danfeng
 * @since 2018/4/4
 */


public class AppTest extends ExcuteTest {
    @Autowired
    private DemoUserMapper demoUserMapper;

}
