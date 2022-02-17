package org.example.jdbc.base;

/**
 * 不可重复读:
 *
 * @author dragon
 * @since 2021/1/13
 */
public class NonRepeatableReadTest {


    public static void main(String[] args) {
        int a =100,b=50,c=a---b,d=a---b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }
}
