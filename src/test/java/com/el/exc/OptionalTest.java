package com.el.exc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Optional 这是一个可以为null的容器对象，如果值存在则isPresent()返回true，调用get()方法返回该对象
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionalTest {

    /**
     * of方法通过工厂方法创建Optional类。
     * 需要注意的是，创建对象时传入的参数不能为null。如果传入参数为null，则抛出NullPointerException
     */
    @Test
    public void testOf() {
        // 调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("Sanaulla");
        //isPresent方法用来检查Optional实例中是否包含值
        if (name.isPresent()) {
            //在Optional实例内调用get()返回已存在的值
            System.out.println(name.get());//输出Sanaulla
        }

        // 传入参数为null，抛出NullPointerException.
//        Optional<String> someNull = Optional.of(null);
        Optional empty = Optional.ofNullable(null);
        //如果值不为null，orElse方法返回Optional实例的值。
        //输出：Sanaulla
        System.out.println(name.orElse("There is some value!"));
        //输出：There is no value present!
        System.out.println(empty.orElse("There is no value present!"));

        //orElseGet与orElse方法类似，区别在于orElse传入的是默认值，
        //orElseGet可以接受一个lambda表达式生成默认值。
        //输出：Default Value
        System.out.println(empty.orElseGet(() -> "Default Value"));
        //输出：Sanaulla
        System.out.println(name.orElseGet(() -> "Default Value"));

        try {
            //orElseThrow与orElse方法类似。与返回默认值不同，
            //orElseThrow会抛出lambda表达式或方法生成的异常

            empty.orElseThrow(RuntimeException::new);
        } catch (Throwable ex) {
            //输出: No value present in the Optional instance
            System.out.println(ex.getMessage());
        }
    }

    /**
     * 为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。
     */
    @Test
    public void testOfNullAble() {
        //下面创建了一个不包含任何值的Optional实例
        //例如，值为'null'
        Optional empty = Optional.ofNullable(null);
    }

    /**
     * 如果Optional实例有值则为其调用consumer，否则不做处理
     */
    @Test
    public void testIfPresent() {
        // 调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("Sanaulla");
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length());
        });
    }

    //map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
    //为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
    @Test
    public void testOptionalMap() {
        Optional<String> name = Optional.of("Sanaulla");
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));
        //flatMap与map（Function）非常类似，区别在于传入方法的lambda表达式的返回类型。
        //map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。
        //但flatMap方法中的lambda表达式返回值必须是Optionl实例。
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));//输出SANAULLA
    }

}
