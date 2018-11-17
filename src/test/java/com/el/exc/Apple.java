package com.el.exc;

public class Apple<E> {

    static <Z> Apple<Z> nil() {
        System.out.println("Apple");
        return null;
    }

    static <Z> Apple<Z> cons(Z head, Apple<Z> tail) {
        System.out.println("Z");
        return null;
    }
    E head() {
        return null;
    }
}
