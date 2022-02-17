package org.example.jdk.java8.stream;

import java.util.stream.Stream;

public class StreamDemo6 {


    public static void main(String[] args) {
        Stream.of("hello", "world","hello world")
                .mapToInt(item -> {
                    int length = item.length();
                    System.out.println(item);
                    return length;
                })
                .filter(item -> {
                    System.out.println(item);
                    return item == 5;
                })
                .findFirst()
                .ifPresent(System.out::println);
    }
}
