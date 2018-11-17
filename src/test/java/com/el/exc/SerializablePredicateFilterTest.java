package com.el.exc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.function.Predicate;

/**
 * @author danfeng
 * @since 2018/3/6.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SerializablePredicateFilterTest {
//    public String VALUE = "Danfeng";
//
//    public interface SerializablePredicate<T> extends Predicate<T>, Serializable {
//    }
//
//    public <T> void filters(SerializablePredicate<T> sp, T value) throws IOException, ClassNotFoundException {
//        sp.getClass().isLocalClass();
//        File tempFile = File.createTempFile("labmda","set");
//        try(ObjectOutput oo = new ObjectOutputStream((new FileOutputStream(tempFile)))) {
//            oo.writeObject(sp);
//        }
//        try(ObjectInput oi = new ObjectInputStream(new FileInputStream(tempFile))) {
//            SerializablePredicate<T> p = (SerializablePredicate<T>) oi.readObject();
//            System.out.println(p.test(value));
//        }
//    }

//    @Test(expected = NotSerializableException.class)
//    public void testAnonymousDirect()throws IOException, ClassNotFoundException  {
//        String value = VALUE;
//        filters((SerializablePredicate<String>) t -> value.length() > t.length(), "Danfeng");
//    }
}
