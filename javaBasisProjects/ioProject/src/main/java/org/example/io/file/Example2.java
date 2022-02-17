package org.example.io.file;

import java.io.File;
import java.util.Scanner;

/**
 * @author dragon
 * @since 2021/2/5
 */
public class Example2 {


    public static void main(String[] args) {
        // 从键盘接收一个文件夹路径,统计该文件夹大小
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
        System.out.println("该文件下的总字节数:" + total(file));
    }

    public static long total(File file) {
        if (file == null) {
            return 0;
        }
        if (file.isFile()) {
            return file.length();
        }

        File[] files = file.listFiles();
        long total = 0;
        if (files != null) {
            for (File item : files) {
                total += total(item);
            }
        }

        return total;
    }


}
