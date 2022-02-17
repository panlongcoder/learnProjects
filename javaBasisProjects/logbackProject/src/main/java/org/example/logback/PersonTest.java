package org.example.logback;

import ch.qos.logback.core.LogbackException;

/**
 * @author dragon
 * @date 2022/1/3
 */
public abstract class PersonTest {

    public abstract void test() throws LogbackException;


    static class ChildTest extends PersonTest  {

        @Override
        public void test() {
            System.out.println("hello world");
        }
    }
}
