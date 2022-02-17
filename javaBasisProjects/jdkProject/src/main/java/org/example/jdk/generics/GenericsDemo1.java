package org.example.jdk.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 在编译期间,泛型就被擦除了
 *
 * @author dragon
 * @since 2021/3/5
 */
public class GenericsDemo1 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);

        Method addMethod = list.getClass().getDeclaredMethod("add", Object.class);
        addMethod.invoke(list, "dragon");

        System.out.println(list);
    }
}
