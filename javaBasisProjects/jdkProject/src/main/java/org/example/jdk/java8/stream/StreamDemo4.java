package org.example.jdk.java8.stream;

import java.util.stream.Stream;

public class StreamDemo4 {

    public static void main(String[] args) {
        int sum = Stream.iterate(1, item -> item * 2)
                .limit(6)
                .filter(item -> item > 2)
                .mapToInt(item -> item * 2)
                .skip(2)
                .limit(2)
                .sum();
        System.out.println(sum);
    }
}
