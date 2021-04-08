/**
 * FileName:   ClinitStatic.java
 * @Description 类的初始化 Clinit
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.jvm.class_;

public class ClinitStaticTest {
    public static void main(String[] args) {
        System.out.println(Child1.b);
    }
}

class Father1 {
    public static int a = 1;
    static {
        a = 2;
    }
}

class Child1 extends Father1 {
    public static int b = a;
}
