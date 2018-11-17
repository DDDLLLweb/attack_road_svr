package com.el.cls;

import com.el.exc.Parent;
import com.sun.source.tree.ClassTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Method;

/**
 * @author Danfeng
 * @since 2018/8/8
 */
@RunWith(JUnit4.class)
public class TestCls {

    @Test
    public void instance() {
        Class<? extends Object> parentClass = Parent.class;
        try {
            parentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClassTree() {
        ClassLoader classLoader = ClassTree.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.toString());
            classLoader = classLoader.getParent();
        }
        // 输出
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        //sun.misc.Launcher$ExtClassLoader@ea30797
    }

    @Test
    public void testClassIdentity() {
        String clsData = "/Users/diaodanfeng/Documents/cloud_road/attack_road_svr/src/test/java/";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(clsData);
//        FileSystemClassLoader fscl2 = new FileSystemClassLoader(clsData);
        String className = "com.el.cls.Sample";
        try {
            Class<?> class1 = fscl1.findClass(className);
            Object obj1 = class1.newInstance();
            Class<?> class2 = fscl1.findClass(className);
            Object obj2 = class2.newInstance();
            Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
            setSampleMethod.setAccessible(true);
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
