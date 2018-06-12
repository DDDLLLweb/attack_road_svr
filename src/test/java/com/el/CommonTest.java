package com.el;


import com.el.redis.ObjectRedisTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author danfeng
 * @since 2018/4/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {
    @Autowired
    ObjectRedisTemplate template;

    @Test
    public void testRedisTemp() {
        template.opsForValue().set("key2","aa");
        System.out.println(template.opsForValue().get("key2"));
    }
    @Test
    public void testString() {
        String str = "http://localhost:8080/b2bpc/survey/fillSurvey.do";
        System.out.println(str.substring(0,str.indexOf("/b2bpc")));
    }
    @Test
    public void testCondition() {
        Map<String,Object> map = new HashMap<>(1);
        map.put("key1","a");
        for (int i =0; i<3; i++) {
            map.put("key2",i);
        }
        System.out.println(map);
    }
}
