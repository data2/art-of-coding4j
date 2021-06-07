package com.data2.coding4j;

import org.junit.Test;

/**
 * String s = new String("abc")
 * 1、先在常量池中查找是否存在值为"abc"的对象，没有则创建一个；
 * 2、然后在堆上再创建"abc"对象
 * <p>
 * String对象的intern方法会得到字符串对象在常量池中对应的版本的引用（如果常量池中有一个字符串与String对象的equals结果是true），
 * 如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返回常量池中字符串的引用。
 * <p>
 * +号两边只要有非对象池中的字符串对象那么必然会在内存中创建新对象, "a"+new String("b")
 * +号两侧对象都是字符串常量池中才会从池子中查找，"a"+"b" 会在常量池中查找"ab" - 编译器优化
 * <p>
 * String是不可变(final)类，每次在String对象上的操作都会生成一个新的对象；
 * StringBuffer和StringBuilder是可变的，它允许在原来对象上进行操作，而不用每次增加对象；
 * StringBuffer是线程安全的，但效率较低，而StringBuilder则不是线程安全的，效率最高。
 */
public class StringExample {

    @Test
    public void test() {
        String a = "apple";//字符串常量池中字面量
        String b = new String("apple");//堆上的新对象
        String c = new String("apple");

        System.out.println(a == b);//false
        System.out.println(a == b.intern());//true intern获取对象常量池中的字符串
        System.out.println(b.intern() == c.intern());//true

        System.out.println(a == "app" + new String("le"));//false
        System.out.println(b == "app" + new String("le"));//false

        String d = "app";
        String e = "le";
        System.out.println(a == "app" + "le");//true 编译期优化
        System.out.println(a == d + "le");//false 编译器无法优化
        System.out.println(a == d + e);//false 编译器无法优化
    }


    @Test
    public void testStringBuffer() {
        //安全 效率低
        StringBuffer sb = new StringBuffer("a");
        sb.append("b");
        //不安全 效率高
        StringBuilder stringBuilder = new StringBuilder("a");
        stringBuilder.append("b");
    }
}
