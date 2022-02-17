package org.example.jdk.java8;

/**
 * @author dragon
 * @since 2021/2/26
 */
public class ThisOfLambdaClass {

    public static void main(String[] args) {
        Inner dragon = new Inner("dragon");
        dragon.run();
        Inner hero = new Inner("hero");
        hero.run();
    }

    static class Inner {

        private String name;

        public Inner(String name) {
            this.name = name;
        }

        public void run() {
            Thread thread = new Thread(() -> System.out.println(this.name));
            thread.start();
        }
    }
}


