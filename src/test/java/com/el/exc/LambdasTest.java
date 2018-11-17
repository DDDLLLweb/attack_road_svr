package com.el.exc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdasTest {

    /**
     * lambda表达式替代
     */
    @Test
    public void testInsteadAnonymous() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("普通方法！");
            }
        }).start();
        new Thread(() -> {
            System.out.println("Java 8 ");
        }).start();
    }

    /**
     * lambda map 实例
     * reduce() 函数可以将所有值合并成一个
     */
    @Test
    public void testLambdaMap() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).forEach(System.out::println);
        double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
        double bill2 = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce(Double.valueOf(0), (sum, cost) -> sum + cost);
        System.out.println("Total : " + bill2);
    }

    /**
     * 字符串操作
     */
    @Test
    public void testLamdaStr() {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }

    /**
     * 利用流去重
     */
    @Test
    public void testLambdaDistinct() {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }

    /**
     * 获取数字的个数、最小值、最大值、总和以及平均值
     */
    @Test
    public void testLambdaSummary() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

    @Test
    public void testLambdaPerformance() {
        List<Integer> integers = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 100000; i++) {
            integers.add(i);
        }
        long startTime = System.currentTimeMillis();
//        使用迭代器循环列表
        for (Iterator<Integer> it = integers.iterator(); it.hasNext(); ) {
            max = Integer.max(max, it.next());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("迭代器: " + (endTime - startTime));
//         不使用迭代器循环列表
        long startTime2 = System.currentTimeMillis();
        for (Integer n : integers) {
            max = Integer.max(max, n);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("不使用迭代器循环列表: " + (endTime2 - startTime2));
//        for循环
        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < integers.size(); i++) {
            max = Integer.max(max, integers.get(i));
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println("for循环: " + (endTime3 - startTime3));
//      函数式风格
        long startTime4 = System.currentTimeMillis();
        max = integers.parallelStream().mapToInt(Integer::intValue).reduce(Integer.MIN_VALUE,Integer::max);
        long endTime4 = System.currentTimeMillis();
        System.out.println("函数式风格并行流: " + (endTime4 - startTime4));
//      流遍历
        long startTime5 = System.currentTimeMillis();
        max = integers.stream().mapToInt(Integer::intValue).reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
        long endTime5 = System.currentTimeMillis();
        System.out.println("函数式风流遍历: " + (endTime5 - startTime5));

    }
}
