package com.data2.coding4j.grammar.extend;

/**
 * Java中类不支持多继承，只支持单继承（即一个类只有一个父类）。 <br/>
 * 但是java中的接口支持多继承，，即一个子接口可以有多个父接口。<br/>
 * 接口的作用是用来扩展对象的功能，一个子接口继承多个父接口，说明子接口扩展了多个功能，当类实现接口时，类就扩展了相应的功能）。<br/>
 *
 */
public class ExtendsTest {
    public static void main(String[] args) {
        new Moutain();
    }

}

class Atom {
    Atom() {
        System.out.println("i am atom");
    }
}

class Rock extends Atom {
    Rock() {
        System.out.println("i am Rock");
    }
}

class Moutain extends Rock {
    Moutain() {
        System.out.println("i am moutain");
    }

}
