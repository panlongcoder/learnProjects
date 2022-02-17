package org.example.io.stream;

import java.io.*;

/**
 *
 * @author dragon
 * @since 2021/2/5
 */
public class InputStreamExample1 {

    public static void main(String[] args) throws IOException {
        test2();
    }

    public static void test() throws IOException {
        File file = new File("/Users/panlong/Downloads/a.txt");
        InputStream inputStream = new FileInputStream(file);
        int bytes = -1;
        while ((bytes = inputStream.read()) != -1) {
            System.out.println(bytes + "===" + (char) (bytes));
        }
        inputStream.close();
    }

    public static void test2() throws IOException {
        File file = new File("/Users/panlong/Downloads/a.txt");
        InputStream inputStream = new FileInputStream(file);
        byte[] array = new  byte[1496];
        int total = inputStream.read(array);
        System.out.println("从输入流中读取到array中的字节个数为:" + total);
        for (int i = 0; i < array.length; i++) {
            byte b = array[i];
            System.out.println("读取的" + b + " --对应的字符为:" + (char) b);
        }
        inputStream.close();
    }
}
