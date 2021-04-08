package com.data2.coding4j;

import org.junit.Assert;
import org.junit.Test;

import java.lang.Byte;

/**
 * * 8个基本数据类型 byte short int long float double char boolean
 */
public class JavaBaseTypeExample {

    /**
     * java整型 -- byte short int long
     * bit位:二进制数据0或1
     * 1个字节(byte) = 8位(bit)
     * 1个数字或者字母占1byte, 1个汉字占2byte
     */
    @Test
    public void typeByte() {
        /**
         * byte占1个字节，8位
         */
        byte[] bytes = "wang1".getBytes();
        System.out.println(bytes.length);

        // 取值范围
        Assert.assertEquals(-128, Byte.MIN_VALUE);// -2^7
        Assert.assertEquals(127, Byte.MAX_VALUE);// 2^7-1
    }

    @Test
    public void typeShort() {
        /**
         * short占2个字节 ， 16位
         */
        //short s = 32768;//cannot convert from int to short
        Assert.assertEquals(-32768, Short.MIN_VALUE);// -2^15
        Assert.assertEquals(32767, Short.MAX_VALUE);//2^15-1

        short s = 1;
        //s = s + 1;//cannot convert from int to short
        s += 1; //编译器特殊处理
    }

    @Test
    public void typeInt() {

        /**
         * int 占4个字节，32位
         */
        Assert.assertEquals(-2147483648, Integer.MIN_VALUE);// -2^31
        Assert.assertEquals(2147483647, Integer.MAX_VALUE);// 2^31-1

        /**在计算机中最高位为符号位，0表示正数，1表示负数。
         * 在计算机中数据是使用其补码表示的，但正数补码是其本身，负数的补码是负数的源码取反加一得到的补码。
         * 【正数】的原码、反码、补码都相等
         * 【负数】的原码是其本身，负数的反码是将符号不变，把符号后边的数取反，对于负数的补码 是把原码取反后加1
         **/
        int i = Integer.MAX_VALUE + 2;
        Assert.assertEquals(i, Integer.MIN_VALUE + 1);
        Assert.assertEquals(Integer.MAX_VALUE + 1, Integer.MIN_VALUE);
    }

    @Test
    public void typeLong() {
        /**
         * long 占8个字节，64位
         */
        long maxLong = (1 << 63) - 1;
        System.out.println(Math.pow(2, 63));//浮点数计算不准确
        System.out.println(Long.MAX_VALUE - maxLong);//0

        Assert.assertEquals(-9223372036854775808L, Long.MIN_VALUE);// -2^64
        Assert.assertEquals(9223372036854775807L, Long.MAX_VALUE);// 2^63-1
    }


    /**
     * 程序中应尽量避免浮点数的比较 float、double类型的运算往往都不准确。
     * 在《Effective Java》这本书中也提到这个原则，float和double只能用来做科学计算或者是工程计算
     * <p>
     * 在商业计算中我们要用java.math.BigDecimal。 原来我们如果需要精确计算，非要用String来够造BigDecimal不可！
     * <p>
     * float和double是java的基本类型，用于浮点数表示，在java中float占4个字节32位，double占8个字节64位。
     * 一般比较适合用于工程测量计算中，其在内存里的存储结构如下：
     * float： 符号位（1 bit） 指数（8 bit） 尾数（23 bit）
     * double： 符号位（1 bit） 指数（11 bit） 尾数（52 bit）
     * <p>
     * float、double并不能准确表示每一位小数，对于有的小数只能无限趋向它（所以有的数运行正常，有的数不正常）
     */
    @Test
    public void typeFloat() {
        // 32位 - 单精度浮点数
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
        // 64位 - 双精度浮点数
        // java默认精度数值都是double，精度高 占内存

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

    @Test
    public void leftMoveCal() {
        // 左移 = 乘以2^n
        System.out.println(3 << 2);// 3* 2^2
        System.out.println(1 << 4);// 1*2^4
        // 右移 = 除以2^n
        System.out.println(160 >> 4);// 160 / 2^4

    }

}
