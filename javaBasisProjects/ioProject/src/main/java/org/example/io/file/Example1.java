package org.example.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dragon
 * @since 2021/2/4
 */
public class Example1 {

    public static final String OTHER_PATH = "/Users/panlong/文档/other";

    public static void main(String[] args) throws IOException {
        printFile();
    }

    /**
     * 如何 实现 判断给定的录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称(注意以下代码只是返回文件名,并不是操作文件.)
     */
    public static boolean existFileOfJpgSuffix(String path) throws IOException {
        if (path == null || "".equals(path.trim())) {
            return false;
        }
        path = normalizePath(path);

        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        String[] filterFileList = file.list((item, name) -> name.endsWith(".jpg"));
        if (filterFileList != null) {
            System.out.println(Arrays.toString(filterFileList));
            return true;
        }

        return false;
    }

    // 需求:从键盘输入接收一个文件夹路径,打印出该文件夹下所有的.java文件名
    public static void printFile() throws IOException {
        System.out.println("请输入一个文件夹路径;例如[/user/tmp/dragon]");
        int count = 3;
        Scanner sc = new Scanner(System.in);
        File file = null;
        boolean flag =  true;
        for (int i = 1; i <= count; i++) {
            String path = sc.nextLine();
            file = new File(path);
            if (file.isDirectory()) {
                flag = false;
                break;
            }
            if (!file.exists()) {
                System.out.println("您输入的文件夹路径不存在,请重新输入,您还有" + (count - i) + "次机会");
                continue;
            }
            if (!file.isDirectory()) {
                System.out.println("您输入的不是文件夹路径,请重新输入,您还有" + (count - i) + "次机会");
                continue;
            }
        }
        if (flag) {
            System.out.println("您输入次数已经用完,程序已关闭");
            return;
        }

        recursionPrint(file, 0);


    }

    private static void recursionPrint(File file,  int level) throws IOException {
        if (file.isFile() && file.getAbsolutePath().endsWith(".java")) {
            for (int i = 0; i < level; i++) {
                System.out.print("| ");
            }
            System.out.println("\\- " + file.getCanonicalPath());
            return;
        }
        // System.out.println("+- " + file.getCanonicalPath());
        File[] fileChildList = file.listFiles();
        if (fileChildList  != null) {
            for (File item : fileChildList) {
                recursionPrint(item, level +  1);
            }
        }

    }

    public static String normalizePath(String path) {
        if (path == null || "".equals(path.trim())) {
            return null;
        }
        int n = path.length();
        char prev = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char current = path.charAt(i);
            if (current == '/' && current == prev) {
                continue;
            }
            sb.append(current);
            prev = current;
        }
        if ('/' == prev) {
            return sb.length() == 1 ? sb.toString() : sb.substring(0, sb.length() - 1);
        }

        return sb.toString();
    }
}
