package com.data2.coding4j.grammar.extend;

/**
 * 1、多态<br/>
 * java中变量不能重写，可以按如下口诀记忆：<br/>
 * -----------------变量多态看左边，----------------- <br/>
 * -----------------方法多态看右边，----------------- <br/>
 * -----------------静态多态看左边。----------------- <br/>
 * <br/>
 * 
 * 2、构造器<br/>
 * 只要是new子类，无论是调用子类的有参构造还是无参构造都会执行父类的无参构造<br/>
 * 当子类和父类有同一个变量名字的变量时，如果是使用了多态则调用的是父类的变量。否则调用的是子类的变量。<br/>
 * <br/>
 * 
 * 3、继承<br/>
 * 继承者是被继承者的特殊化，它除了拥有被继承者的特性外，还拥有自己独有得特性。<br/>
 * 同时在使用继承时需要记住三句话：<br/>
 * 1）、子类拥有父类非 private 的属性和方法。<br/>
 * 2）、子类可以拥有自己属性和方法，即子类可以对父类进行扩展。<br/>
 * 3）、子类可以用自己的方式实现父类的方法。<br/>
 * <br/>
 * 
 * 4、继承的缺点<br/>
 * 我们是不是就可以大肆地使用继承呢？送你一句话：慎用继承。<br/>
 * 首先我们需要明确，继承存在如下缺陷：<br/>
 * 1、父类变，子类就必须变。<br/>
 * 2、继承破坏了封装，对于父类而言，它的实现细节对与子类来说都是透明的。<br/>
 * 3、继承是一种强耦合关系。<br/>
 */

public class AppleExtendsTest {
    public static void main(String[] args) {
        Fruit a = new Apple("red");
        System.out.println(a.a);
        a.color();
    }
}

class Apple extends Fruit {

    int a = 9;

    public Apple() {
        System.out.println("apple init");
    }

    public Apple(String color) {
        System.out.println("apple init with" + color);
    }

    public void color() {
        System.out.println("apple is red.");
    }

}

class Fruit {

    int a = 10;

    public Fruit() {
        System.out.println("fruit init");
    }

    public Fruit(String color) {
        System.out.println("fruit init with color");
    }

    public void color() {
        System.out.println("fruit is colorful");
    }
}
