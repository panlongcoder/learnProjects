package org.example.jdk.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dragon
 * @date 2021/11/16
 */
public class GenericsDemo2 {

    public static void main(String[] args) {
        Holder<Child1> holder1 = new AHolder();
        Grandson dragon = new Grandson("dragon", 999);
        holder1.add(dragon);
    }


    public static abstract class Holder<T extends Parent> {
        protected List<T> container = new ArrayList<>();

        public abstract void add(T e);

        public abstract List<T> query();
    }

    public static class AHolder extends Holder<Child1> {

        @Override
        public void add(Child1 e) {
            this.container.add(e);
        }

        @Override
        public List<Child1> query() {
            return container;
        }
    }

    public static class BHolder extends Holder<Child2> {

        @Override
        public void add(Child2 e) {
            this.container.add(e);
        }

        @Override
        public List<Child2> query() {
            return container;
        }
    }

    public static class Parent {
        protected String name;

        public Parent(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Child1 extends Parent {
        protected Integer age;

        public Child1(String name, Integer age) {
            super(name);
            this.age = age;
        }

        @Override
        public String toString() {
            return "Child1{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class Child2 extends Parent {
        private String school;

        public Child2(String name, String school) {
            super(name);
            this.school = school;
        }
    }

    public static class Grandson extends Child1 {

        public Grandson(String name, Integer age) {
            super(name, age);
        }

        @Override
        public String toString() {
            return "Grandson{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
