package org.example.io.file;

import java.io.File;

/**
 * @author dragon
 * @since 2021/2/5
 */
public class Example4 {

    public static void main(String[] args) {
        // 键盘接收两个文件夹路径,把其中一个文件夹中(包含内容)拷贝到另一个文件夹中
    }

    public static void copy(String source, String destination) {
        if (source == null || destination == null) {
            return;
        }
        File sourceFile = new File(source);
        File destFile = new File(destination);
        if (!sourceFile.isDirectory()) {
            System.out.println("source路径需要为文件夹路径");
            return;
        }
        if (!destFile.isDirectory()) {
            System.out.println("dest路径需要为文件夹路径");
            return;
        }

        recursionCopy(sourceFile, destFile);
    }

    private static void recursionCopy(File source, File dest) {

        dest.mkdir();
    }
}
