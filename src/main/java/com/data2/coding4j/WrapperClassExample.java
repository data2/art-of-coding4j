package com.data2.coding4j;

import org.junit.Test;

/**
 * Java是一个面向对象编程语言，为了能够将这些基本数据类型当成对象操作，Java为每一个基本数据类型都引入了对应的包装类型（wrapper class）
 * 从Java 5开始引入了自动装箱/拆箱机制，使得二者可以相互转换。
 * 原始类型:
 * boolean，char，byte，short，int，long，float，double
 * 包装类型：
 * Boolean，Character，Byte，Short，Integer，Long，Float，Double
 */
public class WrapperClassExample {
    /**
     * Integer与int比较时会自动拆箱
     * int常量池范围-128～127
     * Integer i = 127 等价于 Integer.valueOf(127)
     * Integer.valueOf 会判断值在-128-127间取缓存池中的Integer对象，否则新建对象Integer
     */
    @Test
    public void testIntWrapper() {
        int a = 127;
        Integer b = 127;//Integer b = Integer.valueOf(127);
        Integer c = new Integer(127);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }

    @Test
    public void Wrapper() {
        Integer b = 3; // 将3自动装箱成Integer类型
        Integer a = new Integer(3);
        int c = 3;
        System.out.println(a == b); // false 两个引用没有引用同一对象
        System.out.println(a == c); // true a自动拆箱成int类型再和c比较
    }

    @Test
    public void Wrapper2() {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        // 如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，
        // 所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }
}
