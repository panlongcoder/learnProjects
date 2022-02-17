package org.example.jdk.java8.stream;

import java.util.UUID;
import java.util.stream.Stream;

public class StreamDemo2 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);

        stream.findFirst().ifPresent(System.out::println);
    }
}
