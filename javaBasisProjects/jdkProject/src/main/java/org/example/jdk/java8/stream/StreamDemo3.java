package org.example.jdk.java8.stream;

import java.util.stream.Stream;

public class StreamDemo3 {

    public static void main(String[] args) {
        Stream.iterate(1, item -> item * 2).limit(8).forEach(System.out::println);
    }
}
