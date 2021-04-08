package com.data2.coding4j.grammar.interface_;

import org.junit.Test;

/***
 * 
 * 1、接口与类相似点：<br/>
 * <br/>
 * 一个接口可以有多个方法。<br/>
 * 接口文件保存在 .java 结尾的文件中，文件名使用接口名。<br/>
 * 接口的字节码文件保存在 .class 结尾的文件中。<br/>
 * 接口相应的字节码文件必须在与包名称相匹配的目录结构中。<br/>
 * <br/>
 * 
 * 2、接口与类的区别：<br/>
 * <br/>
 * 接口不能用于实例化对象。<br/>
 * 接口没有构造方法。<br/>
 * 接口中所有的方法必须是抽象方法。<br/>
 * 接口不能包含成员变量，除了 static 和 final 变量。<br/>
 * 接口不是被类继承了，而是要被类实现。<br/>
 * 接口支持多重继承。<br/>
 * <br/>
 * 
 * 3、接口特性<br/>
 * <br/>
 * 接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 public abstract（只能是 public
 * abstract，其他修饰符都会报错）。<br/>
 * 接口中可以含有变量，但是接口中的变量会被隐式的指定为 public static final 变量（并且只能是 public，用 private
 * 修饰会报编译错误。<br/>
 * 接口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法。<br/>
 * <br/>
 * 
 * 4、抽象类和接口的区别<br/>
 * <br/>
 * 抽象类中的方法可以有方法体，就是能实现方法的具体功能，但是接口中的方法不行。<br/>
 * 抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是 public static final 类型的。<br/>
 * 接口中不能含有静态代码块以及静态方法(用 static 修饰的方法)，而抽象类是可以有静态代码块和静态方法。<br/>
 * 一个类只能继承一个抽象类，而一个类却可以实现多个接口<br/>
 * <br/>
 * 
 * 5、接口<br/>
 * 1）接口用于描述系统对外提供的所有服务,因此接口中的成员常量和方法都必须是公开(public)类型的,<br/>
 * 确保外部使用者能访问它们；<br/>
 * 2）接口仅仅描述系统能做什么,但不指明如何去做,所以接口中的方法都是抽象(abstract)方法；<br/>
 * 3）接口不涉及和任何具体实例相关的细节,因此接口没有构造方法,不能被实例化,没有实例变量，只有静态（static）变量；<br/>
 * 4）接口的中的变量是所有实现类共有的，既然共有，肯定是不变的东西，因为变化的东西也不能够算共有。所以变量是不可变(final)类型，也就是常量了。<br/>
 * 通俗的讲，你认为是要变化的东西，就放在你自己的实现中，不能放在接口中去，接口只是对一类事物的属性和行为更高层次的抽象。<br/>
 * 对修改关闭，对扩展（不同的实现 implements）开放，接口是对开闭原则的一种体现。<br/>
 * 所以：接口的方法默认是public abstract；接口中不可以定义变量即只能定义常量(加上final修饰就会变成常量)。<br/>
 * 所以接口的属性默认是public static final 常量，且必须赋初值。<br/>
 * 注意：final和abstract不能同时出现。<br/>
 * 
 * 6） 类的多重继承是不合法，但接口允许多重继承<br/>
 * Football extends Match,Sport(接口Match、Sport可能定义或者继承相同的方法)
 * 
 * 
 *
 */

public class InterfaceTester {
    @Test
    public void testInterface() throws Exception {
        Animal animal = new Tom();
        animal.animal();
        System.out.println(Animal.AGE);
    }
}

class Tom implements Person {

    @Override
    public void animal() {
        System.out.println("i want to eat food.");
    }

    @Override
    public void human() {
        System.out.println("i want to have a family.");
    }

    @Override
    public void person() {
        System.out.println("i want to read a book.");
    }

}

// 人
interface Person extends Animal, Human {
    int AGE = 70;

    void person();
}

// 人类
interface Human {
    int AGE = 60;

    void human();
}

// 动物
interface Animal {
    int AGE = 50;// 默认属性是 final static = 常量

    void animal();
}