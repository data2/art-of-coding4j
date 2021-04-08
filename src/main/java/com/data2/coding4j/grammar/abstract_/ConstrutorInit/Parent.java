/**
 * FileName:   Parent.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.grammar.abstract_.ConstrutorInit;

/**
 * @author wanglei
 *
 */
public class Parent {
    Print A = new Print(5);
    static Print B = new Print(1);
    static {
        System.out.println("2");
    }
    Parent(){
        System.out.println("6");
    }
}
