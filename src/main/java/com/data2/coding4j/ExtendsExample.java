package com.data2.coding4j;

/**
 * 继承
 * 1、子类拥有父类非 private 的属性和方法。<br/>
 * 2、子类可以拥有自己属性和方法，即子类可以对父类进行扩展。<br/>
 * 3、子类可以用自己的方式实现父类的方法。<br/>
 * <p>
 * 变量多态看左边，方法多态看右边，静态多态看左边
 * 无论调用子类的无参构造器还是有参构造器都会调用父类的无参构造器
 * <p>
 * 类是单继承；接口可以多继承；
 * 慎用继承 - 强耦合
 */
public class ExtendsExample {
    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.age);//变量多态看左边
        //System.out.println(f.money);//子类无法访问父亲private属性
        f.test();//方法多态看右边
        f.money();


    }
}

class Father {
    public int age = 60;
    private int money = 100000;

    public Father() {
        System.out.println("Father 默认构造器");
    }

    public Father(String name) {
        System.out.println("Father 构造器");
    }

    void money() {
        System.out.println("Father 存款" + money);
    }

    void test() {
        System.out.println(age);
    }
}

class Son extends Father {
    int age = 20;

    public Son() {
        System.out.println("Son 默认构造器");
    }

    public Son(String name) {
        System.out.println("Son 构造器");
    }

    void test() {
        System.out.println(age);
    }
}
