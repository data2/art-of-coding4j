/**
 * FileName:   Test1.java
 *
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.grammar.polymorphism;

class Wine {
    public void fun1() {
        System.out.println("Wine 的Fun.....");
        fun2();
    }

    public void fun2() {
        System.out.println("Wine 的Fun2...");
    }
}

class JNC extends Wine {
    /**
     * @desc 子类重载父类方法
     *        父类中不存在该方法，向上转型后，父类是不能引用该方法的
     * @param a
     * @return void
     */
    public void fun1(String a) {
        System.out.println("JNC 的 Fun1...");
        fun2();
    }

    /**
     * 子类重写父类方法
     * 指向子类的父类引用调用fun2时，必定是调用该方法
     */
    public void fun2() {
        System.out.println("JNC 的Fun2...");
    }
}

public class Test1 {
    public static void main(String[] args) {
        Wine a = new JNC();
        a.fun1();
    }
}
//-------------------------------------------------
//Output:
//Wine 的Fun.....
//JNC 的Fun2...
