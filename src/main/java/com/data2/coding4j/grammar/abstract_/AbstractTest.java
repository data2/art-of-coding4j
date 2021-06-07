package com.data2.coding4j.grammar.abstract_;

import org.junit.Test;

/***
 *
 * 面向对象的概念中，所有的对象都是通过类来描绘的，<br/>
 * 但是反过来，并不是所有的类都是用来描绘对象的，如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。
 * <hr/>
 * <p>
 * 1、抽象类除了不能实例化对象之外，类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。
 * </p>
 * <p>
 * 2、由于抽象类不能实例化对象，所以抽象类必须被继承，才能被使用。也是因为这个原因，通常在设计阶段决定要不要设计抽象类。
 * <p>
 * <p>
 * 3、在Java中抽象类表示的是一种继承关系，一个类只能继承一个抽象类，而一个类却可以实现多个接口。
 * <p>
 *
 * 抽象类总结规定<br/>
 * 1. 抽象类不能被实例化(初学者很容易犯的错)，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。<br/>
 * 2. 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。<br/>
 * 3. 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。<br/>
 * 4. 构造方法，类方法（用static修饰的方法）不能声明为抽象方法。<br/>
 * 5. 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。<br/>
 * <br/>
 *
 * 声明抽象方法会造成以下两个结果：<br/>
 * 1、如果一个类包含抽象方法，那么该类必须是抽象类。<br/>
 * 2、任何子类必须重写父类的抽象方法，或者声明自身为抽象类。<br/>
 * 继承抽象方法的子类必须重写该方法。否则，该子类也必须声明为抽象类。最终，必须有子类实现该抽象方法，否则，从最初的父类到最终的子类都不能用来实例化对象。
 * <br/>
 */
public class AbstractTest {
    @Test
    public void testAbstract() throws Exception {
        AbstractParent p = new SubOne();
        p.print();
        System.out.println(p.getName());
        System.out.println(p.name);
    }
}

abstract class AbstractParent {

    static {
        System.out.println("1.init static block");
    }

    public String name = "parent name";

    {
        System.out.println("2.init non-static block");
    }

    abstract void print();

    public String getName() {
        return name;
    }
}

class SubOne extends AbstractParent {

    public String name = "sub name";

    @Override
    void print() {
        System.out.println("sub class override print method");
    }

    public String getName() {
        return name;
    }

}
