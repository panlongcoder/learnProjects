package org.example.jdk;

public class Test {

    public static void main(String[] args) {
        Person p1 = new Child();

        Person p2 = new Person() {
            {
                System.out.println("p2 构造代码块");
                sleep();

            }

            @Override
            public void eat() {
                System.out.println("p2 eat dog");
            }
        };

        p1.eat();
        p2.eat();

    }

    static class Child extends Person {

        public Child() {
            System.out.println("child constructor");
        }

        {
            System.out.println("hello world");
        }

        @Override
        public void eat() {
            System.out.println("child eat dog");
        }
    }

    static abstract class Person {
        private String name;
        private Integer age;

        public Person() {

        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public abstract void eat();

        public void sleep() {
            System.out.println("person sleep");
        }
    }
}
