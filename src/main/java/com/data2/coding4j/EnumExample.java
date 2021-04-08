package com.data2.coding4j;

public class EnumExample{
    public static void main(String[] args) {
        Color.GREEN.test();
        System.out.println(Color.RED);
//        new Byte()//枚举类型不能new,构造器只能private修饰！！！
    }
}

enum Color{
    GREEN("green"){
        public void test(){
            System.out.println(name);
        }
    },
    YELLOW("yellow"){
        public void test(){
            System.out.println(name);
        }
    },
    RED("red"){
        public void test(){
            System.out.println(name);
        }
    };
    String name;
    abstract void test();
    private Color(String name){
        this.name = name;
    }
}

enum Byte{
    A,
    B,
    C;
}
