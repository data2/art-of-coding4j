package com.data2.coding4j.grammar.innerclass;

interface Person_another {
    public abstract void eat();
}

/**
 * 匿名内部类就是没有名字的局部内部类，不使用关键字class, extends, implements, 没有构造方法。<br/><br/>
 * <p>
 * 什么情况下需要使用匿名内部类？如果满足下面的一些条件，使用匿名内部类是比较合适的：<br/>
 * a·只用到类的一个实例。<br/>
 * b·类在定义后马上用到。<br/>
 * c·类非常小（SUN推荐是在4行代码以下） <br/>
 * d·给类命名并不会导致你的代码更容易被理解。<br/><br/>
 * <p>
 * 在使用匿名内部类时，要记住以下几个原则：<br/>
 * a·匿名内部类不能有构造方法。 <br/>
 * b·匿名内部类不能定义任何静态成员、方法和类。<br/>
 * c·匿名内部类不能是public,protected,private,static。<br/>
 * d·只能创建匿名内部类的一个实例。<br/>
 * e·一个匿名内部类一定是在new的后面，用其隐含实现一个接口或实现一个类。<br/>
 * f·因匿名内部类为局部内部类，所以局部内部类的所有限制都对其生效。<br/><br/>
 * <p>
 * 只要一个类是抽象的或是一个接口，那么其子类中的方法都可以使用匿名内部类来实现<br/>
 * 最常用的情况就是在多线程的实现上，因为要实现多线程必须继承Thread类或是继承Runnable接口<br/>
 */
public class AnonymousTest {

    public static void main(String[] args) {
        Person person = new Person() {

            @Override
            public void eat() {
                System.out.println("吃肉");
            }
        };
        person.eat();

        Person_another pAnother = new Person_another() {

            @Override
            public void eat() {
                System.out.println("吃蔬菜");
            }
        };
        pAnother.eat();
    }

}

abstract class Person {
    public abstract void eat();
}
