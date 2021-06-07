/**
 * FileName:   ConstrutorInitStep.java
 *
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
public class ConstrutorInitStep extends Parent {

    static Print b = new Print(3);

    static {
        System.out.println("4");
    }

    Print a = new Print(7);

    public ConstrutorInitStep() {
        System.out.println("8");
    }

    public static void main(String[] args) {
        Parent p = new ConstrutorInitStep();
        p.hashCode();
    }
}
