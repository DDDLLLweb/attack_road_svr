package com.el.cache;

import java.lang.annotation.*;

/**
 * @author danfeng
 * @since 2018/4/14
 * 1,@Target 用于设定注解使用范围
 *   METHOD(方法上) TYPE(类,接口上) ANNOTATION_TYPE(注解上) CONSTRUCTOR(构造方法) FIELD(域)
 *   LOCAL_VARIABLE 局部变量上 PACKAGE(用于记录Java文件的package信息) PARAMETER(参数上)
 * 2, @Retention 定义被它所注解的注解保留多久
 *    RetentionPolicy.SOURCE 被编译器忽略
 *    RetentionPolicy.CLASS 注解将会被保留在Class文件中，但在运行时并不会被VM保留。
 *    RetentionPolicy.RUNTIME 保留至运行时。
 * 3, @Inherited 阐述了某个被标注的类型是被继承的。
 *    如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类
 * 4, @Documented 注解表明这个注解应该被 javadoc工具记录.
 *    默认情况下,javadoc是不包括注解的.
 *    但如果声明注解时指定了 @Documented,则它会被 javadoc 之类的工具处理, 所以注解类型信息也会被包括在生成的文档中.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CacheName {
    String value() default "";
}
