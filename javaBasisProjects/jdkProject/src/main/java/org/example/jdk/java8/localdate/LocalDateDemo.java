package org.example.jdk.java8.localdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalDateDemo {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2021, 3, 8);
        System.out.println(date);

        LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfYear());

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }
}
