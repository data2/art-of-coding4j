package com.data2.coding4j.grammar.innerclass;

import com.data2.coding4j.grammar.innerclass.MemberInnerClass.Inner;

/**
 * 内部类是指在一个外部类的内部再定义一个类。类名不需要和文件夹相同。 内部类分为： 成员内部类、局部内部类、静态嵌套类、匿名内部类 。
 * <p>
 * 成员内部类，就是作为外部类的成员，可以直接使用外部类的所有成员和方法，即使是private的。
 * 虽然成员内部类可以无条件地访问外部类的成员，而外部类想访问成员内部类的成员却不是这么随心所欲了。
 * 在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问
 * <p>
 * 成员内部类Inner用private修饰，则只能在外部类的内部访问，如果用public修饰，则任何地方都能访问；
 * 如果用protected修饰，则只能在同一个包下或者继承外部类的情况下访问；
 */

public class MemberInnerClassTest {

    public static void main(String[] args) {
        MemberInnerClass out = new MemberInnerClass();
        Inner in = out.new Inner();
        in.print();
    }
}

class MemberInnerClass {
    private int age = 12;

    // 成员内部类
    class Inner {
        private int age = 13;

        public void print() {
            int age = 14;
            System.out.println("局部变量：" + age);
            System.out.println("内部类变量：" + this.age);
            System.out.println("外部类变量：" + MemberInnerClass.this.age);
        }
    }
}