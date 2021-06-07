/**
 * FileName:   MonkeysEatPeaches.java
 *
 * @Description 尾递归易于在编译器层面优化。如果编译器未作优化，效果和线性递归差不多。
 * <p>
 * 猴子吃桃问题：
 * 猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾就多吃了一个。第二天早上又将剩下的桃子吃了一半，还是不过瘾又多吃了一个。以后每天都吃前一天剩下的一半再加一个。到第10天刚好剩一个。问猴子第一天摘了多少个桃子？
 * <p>
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.algorithm.recursive;

public class MonkeysEatPeaches {

    public static void main(String[] args) {
        MonkeysEatPeaches m = new MonkeysEatPeaches();
        System.out.println(m.calcuPeaches(1));
//        System.out.println(m.tailCalcuPeaches(1, 1));
    }

    /**
     * 线性递归
     * @param day
     * @return
     */
    private int calcuPeaches(int day) {
        if (day == 10) {
            return 1;
        } else {
            return 2 * (calcuPeaches(day + 1) + 1);
        }

    }

    /**
     * 尾递归
     * @param day
     * @return
     */
    @SuppressWarnings("unused")
    private int tailCalcuPeaches(int day, int result) {
        if (day == 10) {
            return result;
        } else {
            return tailCalcuPeaches(day + 1, 2 * (result + 1));
        }

    }
}
