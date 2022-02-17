package org.example.jdk.java8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author dragon
 * @since 2021/3/1
 */
public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.equals("dragon");

        boolean isEquals = predicate.test("dragon");

        System.out.println("是否相等:" + isEquals);

        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 8, 9);

        filter(asList, i -> i > 5);
    }

    public static void filter(List<Integer> arrayList, Predicate<Integer> predicate) {
        for (Integer integer : arrayList) {
            if (predicate.test(integer)) {
                System.out.print(integer + " ");
            }
        }

    }
}
