package org.example.jdk.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo8 {

    public static void main(String[] args) {
        Student mars = new Student("mars", 12);
        Student hero = new Student("hero", 55);
        Student good = new Student("good", 99);
        Student mary = new Student("mary", 100);
        Student mars1 = new Student("mars", 22);
        Student mars2 = new Student("mars", 12);
        List<Student> list = Arrays.asList(mars, hero, good, mary, mars1, mars2);

        List<Student> studentList = list.stream().collect(Collectors.toList());

        HashSet<Student> studentHashSet = list.stream().collect(Collectors.toCollection(HashSet::new));

        Set<Student> studentSet = list.stream().collect(Collectors.toSet());

        Long count = list.stream().collect(Collectors.counting());

        System.out.println("集合中的元素个数:" + count);

        list.stream().min(Comparator.comparingInt(Student::getAge)).ifPresent(System.out::println);


        list.stream().max(Comparator.comparingInt(Student::getAge)).ifPresent(System.out::println);

        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("最大:"  + collect.getMax() + " 最小:" + collect.getMin() + " 总和:" + collect.getSum());

        Double collect1 = list.stream().collect(Collectors.averagingInt(Student::getAge));
        System.out.println("平均分:" + collect1);

        System.out.println(list.stream().map(Student::getName).collect(Collectors.joining(",", "[", "]")));

        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));

        TreeMap<String, Set<String>> treeMap = list.stream().collect(Collectors.groupingBy(Student::getName, TreeMap::new, Collectors.mapping(Student::getName, Collectors.toSet())));
        System.out.println("treeMap:" + treeMap);

        Map<String, Map<Integer, List<Student>>> mapMap = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getAge)));

        System.out.println("mapMap:" + mapMap);

        Map<Boolean, List<Student>> booleanListMap = list.stream()
                .collect(Collectors.partitioningBy(student -> student.getAge() > 50));

        System.out.println(booleanListMap);
    }

    static class Student {
        private String name;

        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
