package com.data2.coding4j.grammar.basic;

import org.junit.Assert;
import org.junit.Test;

/**
 * 8个基本数据类型 byte short int long float double char boolean
 * 
 * @author wanglei
 *
 */
public class BaseDataType {

    /**
     * java整形 -- byte short int long
     */
    @Test
    public void typeByte() {
        /** bit 位:二进制数据0或1
         *  byte 字节:1个字节(byte) = 8位(bit)
         *  1个数字或者字母 占 1byte,1个汉字占2byte
         */
        byte[] bytes = "wang1".getBytes();
        System.out.println(bytes.length);
        System.out.println(bytes[1]);
        System.out.println(bytes[2]);
        System.out.println(bytes[3]);
        System.out.println(bytes[4]);

        byte zeroByte = bytes[0];
        Assert.assertEquals(new String(new byte[] { zeroByte }), "w");

        // 取值范围
        byte maxByte = 127;// 2^7-1
        byte minByte = -128;// -2^7
        Assert.assertEquals(minByte, Byte.MIN_VALUE);
        Assert.assertEquals(maxByte, Byte.MAX_VALUE);
        // byte占1个字节 8位
    }

    @Test
    public void typeShort() {
        short maxShort = 32767;// 2^15-1
        short minShort = -32768;// -2^15
        //short s = 32768;//cannot convert from int to short

        Assert.assertEquals(minShort, Short.MIN_VALUE);
        Assert.assertEquals(maxShort, Short.MAX_VALUE);
        // short占2个字节 ， 16位
        
        short s = 1; 
        //s = s + 1;//cannot convert from int to short
        s += 1; //编译器特殊处理
    }

    @Test
    public void typeInt() {

        // int 占4个字节，32位
        int maxInt = 2147483647;// 2^31-1
        int minInt = -2147483648;// -2^31
        //int iii = 2147483648;//wrong 超过范围

        Assert.assertEquals(minInt, Integer.MIN_VALUE);
        Assert.assertEquals(maxInt, Integer.MAX_VALUE);

        /**在计算机中最高位为符号位，0表示正数，1表示负数。
         * 在计算机中数据是使用其补码表示的，但正数补码是其本身，负数的补码是负数的源码取反加一得到的补码。
         * 
         * 【正数】的原码、反码、补码都相等 
         * 【负数】的原码是其本身，负数的反码是将符号不变，把符号后边的数取反，对于负数的补码 是把原码取反后加1 **/
        int i = Integer.MAX_VALUE + 2;
        Assert.assertEquals(i, Integer.MIN_VALUE + 1);
        Assert.assertEquals(Integer.MAX_VALUE + 1, Integer.MIN_VALUE);

        int ii = 2147483647 + 1;
        System.out.println(ii);

        System.out.println(128 == new Integer(128));

    }

    @Test
    public void typeLong() {
        // int 占8个字节，64位
        long maxLong = 9223372036854775807L;// 2^63-1
        long minLong = -9223372036854775808L;// -2^63
        
        long maxLong2 = (1 << 63) - 1;
        System.out.println(Math.pow(2, 63));//浮点数计算不准确
        System.out.println(Long.MAX_VALUE - maxLong2);//0

        Assert.assertEquals(minLong, Long.MIN_VALUE);
        Assert.assertEquals(maxLong, Long.MAX_VALUE);
    }


    /**
     * 程序中应尽量避免浮点数的比较 float、double类型的运算往往都不准确。
     * 在《Effective Java》这本书中也提到这个原则，float和double只能用来做科学计算或者是工程计算
     * 
     * 在商业计算中我们要用java.math.BigDecimal。 原来我们如果需要精确计算，非要用String来够造BigDecimal不可！
     * 
     * float和double是java的基本类型，用于浮点数表示，在java中float占4个字节32位，double占8个字节64位。
     * 一般比较适合用于工程测量计算中，其在内存里的存储结构如下： 
     * float： 符号位（1 bit） 指数（8 bit） 尾数（23 bit）
     * double： 符号位（1 bit） 指数（11 bit） 尾数（52 bit）
     * 
     * float、double并不能准确表示每一位小数，对于有的小数只能无限趋向它（所以有的数运行正常，有的数不正常）
     */
    @Test
    public void typeFloat() {
        // 32位单精度浮点数
        // float 指数位8bit 2^8 = 256个
        float maxFloat = Float.MAX_VALUE;// 2^128-1
        float minFloat = Float.MIN_VALUE;// -2^128

        float f = (float) 1.0;
        float f1 = 1.0f;

        // 各种数据紊乱
        float ff = 1.0f - 0.9f;
        System.out.println(ff);
        System.out.println(0.99999999f == 1f);// true
        System.out.println(0.9999999f == 1f);// false

    }

    @Test
    public void typeDouble() {
        // 64位单精度浮点数
        // double指数位11 2^11 = 2084
        double maxDouble = Double.MAX_VALUE;// 2^1024-1
        double minDouble = Double.MIN_VALUE;// -2^1024

        /** java默认精度数值都是double，精度高 占内存**/
        
        // 各种数据紊乱
        double dd = 1.0 - 0.9;
        System.out.println(dd);
        System.out.println(0.99999999999999999 == 1);// true
        System.out.println(0.9999999999 == 1);// false
    }

    @Test
    public void typeChar() {
        // 占2个字节 16位
        char a = 97;
        System.out.println(a);
        
        /**
         * java中的char类型是用两个字节来表示，使用的是Unicode编码，所以可以正常表示中文字符。
         * 两个字节一共十六位，又因为没有符号位，都是数值位的原因，所以表值范围是从：0 ~ 2^16-1
         */

    }

    @Test
    public void typeBoolean() {
        // 占1个字节 8位
    }

    /**
     * Java是一个近乎纯洁的面向对象编程语言，但是为了编程的方便还是引入了基本数据类型，
     * 但是为了能够将这些基本数据类型当成对象操作，Java为每一个基本数据类型都引入了对应的包装类型（wrapper class）
     * 
     * 从Java 5开始引入了自动装箱/拆箱机制，使得二者可以相互转换。 Java 为每个原始类型提供了包装类型： - 原始类型:
     * boolean，char，byte，short，int，long，float，double -
     * 包装类型：Boolean，Character，Byte，Short，Integer，Long，Float，Double
     */
    @Test
    public void typeWrapper() {
        Integer a = new Integer(3);
        Integer b = 3; // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b); // false 两个引用没有引用同一对象
        System.out.println(a == c); // true a自动拆箱成int类型再和c比较
    }

    @Test
    public void typeWrapper2() {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        // 如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，
        // 所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }

    @Test
    public void leftMoveCal() {
        // 左移 = 乘以2^n
        System.out.println(3 << 2);// 3* 2^2
        System.out.println(1 << 4);// 1*2^4
        // 右移 = 除以2^n
        System.out.println(160 >> 4);// 160 / 2^4

    }

    @Test
    public void test() {
        int arr[] = new int[10];
        System.out.println(arr[0]);

        char c = 'c';
    }

}
