package org.example.jdk.java8.function;

import java.util.function.Function;

/**
 * @author dragon
 * @since 2021/3/1
 */
public class FunctionDemo {

    public static void main(String[] args) {
        Function<Integer, Integer> fc = a -> a * 5;
        System.out.println(fc.apply(1));
    }
}
