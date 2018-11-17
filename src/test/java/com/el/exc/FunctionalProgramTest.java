package com.el.exc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FunctionalProgramTest {

    public static void filter(List names, Predicate condition) {
        names.stream().filter(name -> condition.test(name)).forEach(name -> {
            System.out.println(name + " ");
        });
    }

    /**
     * 使用 java.util.function.Predicate 函数式接口 进行过滤
     */
    @Test
    public void testPredicate() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.toString().startsWith("J"));
        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.toString().endsWith("a"));
        System.out.println("Print all languages :");
        filter(languages, (str) -> true);
        System.out.println("Print no language : ");
        filter(languages, (str) -> false);
        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.toString().length() > 4);
    }

    /**
     * 使用 java.util.function.Predicate 函数式接口 合并过滤条件
     * 允许将两个或更多的 Predicate 合成一个
     * 它提供类似于逻辑操作符AND和OR的方法，名字叫做and()、or()和xor()，用于将传入 filters() 方法的条件合并起来
     */
    @Test
    public void testSumCondition() {
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        languages.stream().filter(startsWithJ.and(fourLetterLong))
            .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
    }
    @Test
    public void testCompare() {
        Predicate<Integer> compare = (n) -> n.equals(0);
        System.out.println(compare.test(Integer.valueOf(1)));
    }

    @Test
    public void testUnaryOpterator() {
        List<Integer> list = Arrays.asList(10,20,30,40,50);
        UnaryOperator<Integer> unaryOpt = i->i*i;
        List<Integer> uniList = new ArrayList<>();
        list.forEach(i->uniList.add(unaryOpt.apply(i)));
    }
}
