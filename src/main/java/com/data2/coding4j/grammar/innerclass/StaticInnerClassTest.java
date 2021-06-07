package com.data2.coding4j.grammar.innerclass;

/**
 * 静态嵌套类 又叫静态局部类、嵌套内部类，就是修饰为static的内部类。<br/>
 * 声明为static的内部类，不需要内部类对象和外部类对象之间的联系，<br/>
 * 就是说我们可以直接引用outer.inner，即不需要创建外部类，也不需要创建内部类。<br/>
 * 内部类就只能访问外部类的静态成员变量，具有局限性
 */
public class StaticInnerClassTest {

    private static int age = 12;

    public static void main(String[] args) {
        StaticInnerClass.Inner in = new StaticInnerClass.Inner();
        in.print();
    }

    // 静态嵌套类
    static class Inner {
        public void print() {
            System.out.println(age);
        }
    }

}

class StaticInnerClass {

    private static int age = 12;

    // 静态嵌套类
    static class Inner {
        public void print() {
            System.out.println(age);
        }
    }
}
