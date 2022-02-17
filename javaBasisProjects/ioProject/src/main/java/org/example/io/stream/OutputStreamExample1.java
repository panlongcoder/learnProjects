package org.example.io.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author dragon
 * @since 2021/2/7
 */
public class OutputStreamExample1 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/panlong/Downloads/c.txt");

        fos.write(189);

        FileInputStream fis = new FileInputStream("/Users/panlong/Downloads/c.txt");
        int read = fis.read();
        System.out.println("码表对应的值:" + read + "--对应的字符:" + (char)read);
        fos.close();
    }

}
