package org.example.io.stream;

import java.io.*;

/**
 * @author dragon
 * @since 2021/2/7
 */
public class ObjectOutputStreamExample1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("/Users/panlong/Downloads/a.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeLong(10L);

        Person person = new Person();
        person.setAge(10);
        person.setName("mars");
        oos.writeObject(person);


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/panlong/Downloads/a.txt"));
        long l = ois.readLong();
        System.out.println("读取到的long值:" + l);

        Object o = ois.readObject();
        System.out.println("读取到的o:" + o);


        ois.close();

        oos.close();
    }



    static class Person implements Serializable {

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
