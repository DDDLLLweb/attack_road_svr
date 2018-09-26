package com.el;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {

    /**
     * 使用内循环替代外循环
     */
    @Test
    public void testInsteadLoop() {
        List<String> features = Arrays.asList("Lambdas", "Default Method",
            "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println("normal: " + feature);
        }
        //        java 8
        features.forEach(s -> System.out.println("java8: " + s));
        features.forEach(System.out::println);
    }

    /**
     * 对于20元以上的商品，进行9折处理，最后得到这些商品的折后价格
     */
    @Test
    public void testReduce() {
        List<BigDecimal> prices = Arrays.asList(BigDecimal.ONE, BigDecimal.valueOf(20), BigDecimal.valueOf(30), BigDecimal.valueOf(40));
        final BigDecimal totalOfDiscountedPrices = prices.stream().filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0).map(price->
            price.multiply(BigDecimal.valueOf(0.9))
        ).reduce(BigDecimal.ZERO,BigDecimal::add);
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }

}
