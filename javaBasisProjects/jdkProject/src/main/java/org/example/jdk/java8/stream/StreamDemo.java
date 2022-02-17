package org.example.jdk.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloWorld");

        ArrayList<String> result = list.stream()
                .collect(ArrayList::new, ArrayList::add,
                        ArrayList::addAll);

        System.out.println(result);
    }
}
