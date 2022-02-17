package org.example.io.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author dragon
 * @since 2021/2/5
 */
public class InputStreamExample2 {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/panlong/Downloads/a.txt");
        InputStream inputStream = new FileInputStream(file);
        byte[] array = new byte[1024];

        int total = inputStream.read(array, 1022, 2);

        System.out.println("从io流中读取到的字节个数:" + total);

        for (byte b : array) {
            System.out.println("读取到的字节:" + b + "--对应字符:" + (char)b);
        }
        int read = inputStream.read();
        System.out.println("读取到的字节::" + read + "--对应字符:" + (char)read);
        int read1 = inputStream.read();
        System.out.println("读取到的字节::" + read1 + "--对应字符:" + (char)read1);
        inputStream.close();
    }
}
