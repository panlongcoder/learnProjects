package org.example.jdk.java8.supplier;

import java.util.function.Supplier;

/**
 * @author dragon
 * @since 2021/3/2
 */
public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Double> supplier = Math::random;

        Double aDouble = supplier.get();

        System.out.println("得到的随机数:" + aDouble);

        Supplier<Student> studentSupplier = Student::new;

        Supplier<Student> studentSupplier1 = () -> new Student();

        Student student = studentSupplier.get();

        Student student1 = studentSupplier1.get();

        System.out.println("是否相等:" + (student == student1));
    }

    static class Student {
        private String name;

        private Integer age;

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
    }
}
