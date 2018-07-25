package com.el.genericity;

import lombok.extern.slf4j.Slf4j;

/**
 * 泛型类
 * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 * 在实例化泛型类时，必须指定T的具体类型
 *
 * 1, 泛型的类型参数只能是类类型，不能是简单类型。
 * 2, 不能对确切的泛型类型使用instanceof操作
 * @author Danfeng
 * @since 2018/7/19
 */
@Slf4j
public class GenerClass<T> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    //泛型构造方法形参key的类型也为T，T的类型由外部指定
    private GenerClass(T key) {
        this.key = key;
    }
    //泛型方法getKey的返回值类型为T，T的类型由外部指定
    private T getKey(){
        return key;
    }

    public static void main(String[] args) {
        GenerClass<Integer> genericInteger = new GenerClass<>(123456);
        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        GenerClass<String> genericString = new GenerClass<>("key_vlaue");
        System.out.println("泛型测试 key is " + genericInteger.getKey());
        System.out.println("泛型测试 key is " + genericString.getKey());
    }
}
