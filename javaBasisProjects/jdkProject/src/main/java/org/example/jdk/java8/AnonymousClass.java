package org.example.jdk.java8;

/**
 * @author dragon
 * @since 2021/2/26
 */
public class AnonymousClass {

    public static void main(String[] args) {
    Runnable runnable = () -> System.out.println("anonymous class");

    runnable.run();
    }


}
