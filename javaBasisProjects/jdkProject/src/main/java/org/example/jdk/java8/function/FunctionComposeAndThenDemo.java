package org.example.jdk.java8.function;

import java.util.function.Function;

/**
 * @author dragon
 * @since 2021/3/1
 */
public class FunctionComposeAndThenDemo {

    public static void main(String[] args) {
        System.out.println(compose(2, a -> a * a, a -> a + 1));
        System.out.println(andThen(2, a -> a * a, a -> a + 1));
        System.out.println(composeAndThen(2, a -> a * a, a -> a + 1));
    }

    public static int compose(int a, Function<Integer, Integer> fn1, Function<Integer, Integer> fn2) {
        return fn1.compose(fn2).compose(fn1).apply(a);
    }

    public static int andThen(int a, Function<Integer, Integer> fn1, Function<Integer, Integer> fn2) {
        return fn1.andThen(fn2).apply(a);
    }

    public static int composeAndThen(int a, Function<Integer, Integer> fn1, Function<Integer, Integer> fn2) {
        return fn1.compose(fn2.andThen(fn1)).apply(a);
    }
}
