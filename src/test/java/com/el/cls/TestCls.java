package com.el.cls;

import com.el.Parent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Danfeng
 * @since 2018/8/8
 */
@RunWith(JUnit4.class)
public class TestCls {

    @Test
    private void instance() {
        Class< ? extends Object> parentClass = Parent.class;
        try {
             parentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
