package org.example.jdk.java8.function;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author dragon
 * @since 2021/3/2
 */
public class BinaryOperatorDemo {

    public static void main(String[] args) {
        String aShort = getShort("dragon", "ddd", Comparator.comparingInt(String::length));
        System.out.println(aShort);
    }

    public static String getShort(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
