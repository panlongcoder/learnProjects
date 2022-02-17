package org.example.io.stream;

import java.io.*;

/**
 * @author dragon
 * @since 2021/2/5
 */
public class BufferedInputStreamExample4 {

    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("/Users/panlong/Downloads/a.txt")));
        int ch;
        while ((ch = bis.read()) != -1) {
            System.out.println("读取到的值为:" + ch + "--对应的字符为:" + (char) ch);
        }

        bis.close();
    }
}
