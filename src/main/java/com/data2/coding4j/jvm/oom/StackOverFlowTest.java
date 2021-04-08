/**
 * FileName:   StackOverFlowTest.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.jvm.oom;

/**
 * @author wanglei
 * 通过减少每个线程的可用内存大小 -Xss128k，增加栈帧大小(增加大量的本地变量，使得方法栈帧中本地变量表的长度加大) 使得栈overlow
 * 虚拟机栈、本地方法栈 溢出
 */
public class StackOverFlowTest {
    public static void main(String[] args) {
        new StackOverFlowTest().addLocalVar();
    }
    int k = 0;
    public void addLocalVar(){
        @SuppressWarnings("unused")
        int i = k++;
        addLocalVar();//Exception in thread "main" java.lang.StackOverflowError
    }
}
