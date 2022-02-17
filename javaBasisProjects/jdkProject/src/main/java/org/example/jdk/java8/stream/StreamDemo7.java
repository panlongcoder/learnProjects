package org.example.jdk.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo7 {

    public static void main(String[] args) {
        Stream.of("hello", "hello world", "world hello", "hello hello", "world world")
                .flatMap(item -> Arrays.stream(item.split(" ")))
                .distinct()
                .forEach(System.out::println);

        Student dragon = new Student("dragon", 12, 99);
        Student hero = new Student("hero", 16, 100);
        Student mars = new Student("mars", 19, 88);

        List<Student> list = Arrays.asList(dragon, hero, mars);

         list.stream()
                .collect(Collectors.groupingBy(Student::getName)).forEach((k,v) -> System.out.println(k + ":" + v));
        list.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.counting())).forEach((k, v) -> System.out.println(k + ":" + v));

        list.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore))).forEach((k,v) -> System.out.println(k + ":" + v));
    }

    static class Student {

        private String name;

        private int age;

        private int score;

        public Student(String name, int age, int score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
