/**
 * FileName:   PolyConstructors.java
 *
 * @Description 类的初始化  顺序
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.jvm.class_;

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
        // System.out.println(RoundGlyph.p6);
    }
}

class Print {
    Print(String s) {
        System.out.println("Step " + s);
    }

    Print(String s, double i) {
        System.out.println("Step " + s + "  随机数 " + i);
    }
}

abstract class Glyph {
    static Print p3 = new Print("父类静态成员变量");
    static Print p6 = new Print("父类静态成员变量", Math.random());

    static {
        System.out.println("父类静态块1");
    }

    static {
        System.out.println("父类静态块2");
    }

    Print p2 = new Print("父类成员变量");

    {
        System.out.println("父类代码块");
    }

    Glyph() {
        System.out.println("父类构造方法");
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }

    abstract void draw();
}

class RoundGlyph extends Glyph {
    static Print p4 = new Print("子类静态成员变量");
    static Print p5 = new Print("子类静态成员变量", Math.random());

    static {
        System.out.println("子类静态块1");
    }

    static {
        System.out.println("子类静态块2");
    }

    int radius = 1;
    String s = "abcdefg";
    Print p1 = new Print("子类成员变量");

    {
        System.out.println("子类代码块");
    }

    RoundGlyph(int r) {
        System.out.println("子类构造方法");
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    void draw() {
        System.out.println("子类draw方法, radius = " + radius + " 字符串 " + s);
    }
}
