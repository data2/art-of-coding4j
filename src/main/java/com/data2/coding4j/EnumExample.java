package com.data2.coding4j;

enum Color {
    GREEN("green") {
        public void test() {
            System.out.println(name);
        }
    },
    YELLOW("yellow") {
        public void test() {
            System.out.println(name);
        }
    },
    RED("red") {
        public void test() {
            System.out.println(name);
        }
    };
    String name;

    private Color(String name) {
        this.name = name;
    }

    abstract void test();
}

enum Byte {
    A,
    B,
    C;
}

public class EnumExample {
    public static void main(String[] args) {
        Color.GREEN.test();
        System.out.println(Color.RED);
//        new Byte()//枚举类型不能new,构造器只能private修饰！！！
    }
}
