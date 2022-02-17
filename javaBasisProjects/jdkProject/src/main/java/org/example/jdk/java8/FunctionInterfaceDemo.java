package org.example.jdk.java8;

/**
 * 函数式接口
 *
 * @author dragon
 * @since 2021/2/26
 */
@FunctionalInterface
public interface FunctionInterfaceDemo {

    @Override
    String toString();

    default void a() {
        System.out.println("default method");
    }

    void sleep();
}
