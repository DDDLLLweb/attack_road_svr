package com.el;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author danfeng
 * @since 2018/4/4
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionTest {

    /**
     * 在方法调用返回一个只包含指定对象的不可变列表。
     */
    @Test
    public void testSingletonList() {
        String init[] = { "One", "Two", "Three", "One", "Two", "Three" };
        List list = new ArrayList(Arrays.asList(init));
        System.out.println("List value before: "+list);
        list = Collections.singletonList("TP");
        System.out.println("List value after: "+list);
    }
}
