package org.example.jdk.java8.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo5 {

    public static void main(String[] args) {
        Student dragon = new Student("dragon", 21);
        Student hero = new Student("hero", 11);
        Student mars = new Student("mars", 111);
        Student good = new Student("good", 112);


        List<Student> studentList = new ArrayList<>();
        studentList.add(dragon);
        studentList.add(hero);
        studentList.add(mars);
        studentList.add(good);

        Student student = new Student();
        Student reduce = studentList
                .stream()
                .reduce(student, (v1, element) -> {
                    v1.setScore(v1.getScore() + element.getScore());
                    return v1;
                });
        System.out.println(reduce);
    }

    private static class Student {

        private String name;

        private int score;

        public Student() {

        }

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }


}
