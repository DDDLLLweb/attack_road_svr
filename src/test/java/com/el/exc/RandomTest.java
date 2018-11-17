package com.el.exc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 在Java8中java.util.Random类的一个非常明显的变化就是新增了返回随机数流(random Stream of numbers)的一些方法。
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RandomTest {
//    @Test
//    public void testRandom() {
//        Random random = new Random();
//        DoubleStream doubleStream = random.doubles();
//        IntStream intStream = random.ints(0, 100);
////        创建10个随机的整数流并打印出来
//        intStream.limit(10).forEach(System.out::println);
////        创建100个随机整数
//        List<Integer> randomBetween0And99 = intStream
//            .limit(100)
//            .boxed()
//            .collect(Collectors.toList());
////        高斯伪随机数
//        DoubleStream gaussianStream = Stream.generate(random::nextGaussian).mapToDouble(e -> e);
//    }
}
