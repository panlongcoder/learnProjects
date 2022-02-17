package org.example.io.stream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author dragon
 * @since 2021/2/5
 */
public class ByteArrayInputStreamExample3 {

    public static void main(String[] args) throws IOException {
        String name = "dragonmynameisdragonhelloworld";
        byte[] bytes = name.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);

        byte[] array = new byte[10];
        int total = inputStream.read(array, 0, array.length);
        System.out.println("从此输入流中读取到的字节个数:" + total);

        for (byte b : array) {
            System.out.println("读取到的字节为:" + b + "==对应的字符为:" + (char)b);
        }
        inputStream.close();
    }
}
