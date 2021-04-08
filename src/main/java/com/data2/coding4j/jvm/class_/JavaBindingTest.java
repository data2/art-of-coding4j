/**
 * FileName:   JavaBindingTest.java
 * @Description java 动态绑定 静态绑定
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.jvm.class_;

import org.junit.Test;

public class JavaBindingTest {

    @Test
    public void test() {
        Parent p = new Children();
        p.method();
    }
}

class Parent {
    public void method() {
        System.out.println("father");
    }
}

class Children extends Parent {
    public void method() {
        System.out.println("son");
    }
}