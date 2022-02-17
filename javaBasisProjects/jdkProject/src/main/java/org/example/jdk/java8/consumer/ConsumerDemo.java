package org.example.jdk.java8.consumer;

import java.util.function.Consumer;

/**
 * @author dragon
 * @since 2021/2/26
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        testConsumer();
        testAndThenConsumer();
    }

    public static void testConsumer() {
        Consumer<Integer> consumer = a -> System.out.println(a + "的平方:" + (a * a));

        consumer.accept(3);
    }

    public static void testAndThenConsumer() {
        Consumer<Integer> consumerA = a -> System.out.println("当前的值:" + a);
        Consumer<Integer> consumerB = a -> System.out.println("相加:" + (a + a));
        Consumer<Integer> consumerC = a -> System.out.println("相乘:" + (a * a));

        consumerA.andThen(consumerB).andThen(consumerC).accept(1);
    }
}
