package com.data2.coding4j.grammar.innerclass;

/**
 * 局部内部类 局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
 */
public class PartInnerClassTest {

    public static void main(String[] args) {
        PartInnerClass out = new PartInnerClass();
        out.print(10);
    }
}

class PartInnerClass {

    private int age = 13;

    public void print(final int x) {
        // 局部内部类
        class Inner {
            public void inPrint() {
                System.out.println(x);
                System.out.println(age);
            }
        }
        new Inner().inPrint();
    }
}
