package org.example.jdk.java8;

/**
 * @author dragon
 * @since 2021/2/26
 */
public class LambdaClass {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("lambda表达式"));
        thread.start();
    }
}
