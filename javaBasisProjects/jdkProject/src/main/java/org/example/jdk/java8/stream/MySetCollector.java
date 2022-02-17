package org.example.jdk.java8.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MySetCollector<T> implements Collector<T, Set<T>, Map<T, T>> {

    @Override
    public Supplier<Set<T>> supplier() {
//        System.out.println("supplier invoke!");
        return () -> {
            System.out.println(Thread.currentThread().getName() + " new hashset");
            Set<T> set = new HashSet<>();
            return set;
        };
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
//        System.out.println("accumulator invoke!");
        return (set, item) -> {
            System.out.println(Thread.currentThread().getName() + " hashset add item");
            set.add(item);};
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
//        System.out.println("combiner invoke!");
        return (s1, s2) -> {
            System.out.println(Thread.currentThread().getName() + " hashset addAll");
            s1.addAll(s2);
            return s1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
//        System.out.println("finisher invoke!");
        return set -> {
            System.out.println(Thread.currentThread().getName() + " hashset convert to hashmap");
            Map<T, T> map = new HashMap<>();
            set.stream()
                    .forEach(item -> map.put(item, item));

            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
//        System.out.println("characteristics invoke!");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.IDENTITY_FINISH));
    }

    public static void main(String[] args) {
        List<String> asList = Arrays.asList("hello", "world", "dragon", "mars", "good", "hello world");
        asList.parallelStream()
                .collect(new MySetCollector<>()).forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
