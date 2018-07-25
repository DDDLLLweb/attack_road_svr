package com.el;


import com.el.lottery.Gift;
import com.el.redis.ObjectRedisTemplate;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Test
    public void testSha256() {
        Sha256Hash sha256Hash = new Sha256Hash("123456","abcdefg",1024);
        System.out.println(sha256Hash.toHex());
    }

    public static void main(String[] args) {
        Children1 children1 = new Children1();
        Children2 children2 = new Children2();
    }

}
