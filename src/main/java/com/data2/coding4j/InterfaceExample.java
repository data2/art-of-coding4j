package com.data2.coding4j;

interface A {
    void test();
}

/***
 *
 * 接口的方法是隐式抽象的public abstract,接口的变量是常量public static final
 *
 * 接口用于描述系统对外提供的所有服务,因此接口中的成员常量和方法都必须是公开(public)
 * 接口仅仅描述系统能做什么,但不指明如何去做,所以接口中的方法都是抽象(abstract)方法
 * 接口不涉及和任何具体实例相关的细节,因此接口没有构造方法,不能被实例化,没有实例变量，只有静态（static）变量
 *
 * 接口 vs 抽象类
 * 1、接口不能含有方法体，抽象类可以有方法体
 * 2、接口的变量只能是常量，抽象类成员变量没有限制
 * 3、接口不能含有静态方法和静态代码块，抽象类可以有
 * 4、一个类可以实现多个接口，但只能继承一个抽象类
 *
 * 抽象类可以实现接口
 */
public class InterfaceExample {
    public static void main(String[] args) {
        A a = new C();
        a.test();
        ((C) a).hi();
    }
}

abstract class B implements A {
    public void test() {
        System.out.println("A test");
    }

    abstract void hi();
}

class C extends B {
    public void hi() {
        System.out.println("C hi");
    }

}
