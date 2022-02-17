package org.example.jdk.java8.stream;

public class Test1 {
    public void a() {
        System.out.println("a方法运行了");
    }

    public static void main(String[] args) {
        MyInter m = Test1::a;
        m.d(new Test1());
    }
}

@FunctionalInterface
interface MyInter {
    //入参参数比Test1的a方法多一个，且Test1::a的Test1与该入参类型Test1相同
    public void d(Test1 d);
}
