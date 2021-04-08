package com.data2.coding4j.grammar.extend;

/**
 * -----------------------------------------------<br/>
 * |Java 静态语句块、语句块、构造函数执行顺序|<br/>
 * -----------------------------------------------<br/>
 * 
 * 1、对象的初始化顺序<br/>
 * a、首先执行父类静态的内容<br/>
 * b、接着去执行子类的静态的内容，<br/>
 * c、当子类的静态内容执行完毕之后，再去执行父类的非静态代码块，<br/>
 * d、父类的非静态代码块执行完毕，接着执行父类的构造方法；<br/>
 * e、父类的构造方法执行完毕之后，它接着去执行子类的非静态代码块。<br/>
 * f、子类的非静态代码块执行完毕再去执行子类的构造方法。<br/>
 * <br/>
 * <p>
 * 总之一句话，静态代码块内容先执行，接着执行父类非静态代码块和构造方法，然后执行子类非静态代码块和构造方法。
 * <p/>
 * 一句话：子类没有显示调用父类构造函数，不管子类构造函数是否带参数都默认调用父类无参的构造函数，若父类没有则编译出错。
 * 
 */
public class CodeExecuteOrderExtendTest {

    public static void main(String[] args) {
        new B("2");
    }

}

class A {
    static {
        System.out.println("static A block");
    }

    {
        System.out.println("non-static A block");
    }

    A() {
        System.out.println("A");
    }

}

class B extends A {
    static {
        System.out.println("static B block");
    }

    {
        System.out.println("non-static B block");
    }

    B() {
        System.out.println("B");
    }

    B(String s) {
        System.out.println("BB");
    }

}
