package com.el;

import com.el.util.SqlUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);


    @Test
    public void contextLoads() {
    }

    @Test
    public void testTrimStr() {
        System.out.println("AAA B ");
        String str = StringUtils.trimTrailingCharacter("AAA B ", ' ');
        System.out.println(str);
    }



    @Test
    public void testInsertUser() {
//        User user = new User() {{
//            setPassword("password");
//            setUsername("test");
//            setDeleteflag(true);
//        }};
//        demoUserMapper.insert(user);
    }

    @Test
    public void testToSqlWord() {
        String testStr = "454SAD";
        String result = SqlUtil.toSqlWord(testStr);
        log.info(result);
    }

    @Test
    public void testSqlUtil() {
        String test = SqlUtil.toSqlString("A'");
        System.out.println(test);
    }


}
