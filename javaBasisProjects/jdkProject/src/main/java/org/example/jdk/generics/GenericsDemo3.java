package org.example.jdk.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dragon
 * @date 2021/11/16
 */
public class GenericsDemo3 {

    public static void main(String[] args) {
        GenericsDemo3 demo3 = new GenericsDemo3();

        List<Number> generate = demo3.generate();
        System.out.println(generate);

        FOO<String> foo = new FOO<>();

        String var = foo.getVar();
        System.out.println(var);

        ArrayList<? extends String>  list1 = new ArrayList<String>();
    }

    public <T extends Number> List<T>  generate() {
        List<T> result = new ArrayList<>();

        return result;
    }

    public static class FOO<T> {
        T var;

        public T getVar() {
            return var;
        }

        public void setVar(T var) {
            this.var = var;
        }
    }

}
