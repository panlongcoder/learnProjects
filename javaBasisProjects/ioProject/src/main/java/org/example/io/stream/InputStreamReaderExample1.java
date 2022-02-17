package org.example.io.stream;

import java.io.*;

/**
 * @author dragon
 * @since 2021/2/7
 */
public class InputStreamReaderExample1 {

    public static void main(String[] args) throws IOException {
        InputStreamReader is = new InputStreamReader(new FileInputStream(new File("/Users/panlong/Downloads/b.txt")));
        int k = is.read();
        System.out.println("k:" + k + "----对应的字符:" + (char)k);
        is.close();
    }
}
