package com.data2.coding4j.guava.basetool;

import org.junit.Test;

/**
 * Created by wanglei on 2016/10/12.
 *       Throwable
 *     |            |
 *  Error        Exception
 *   |          |         |
 *  ...     Checked异常.  RuntimeException
 *              |         |
 *             ...       ...
 *
 *  Throwable是所有异常的根，java.lang.Throwable
 *  Error是错误，java.lang.Error
 *  Exception是异常，java.lang.Exception
 *
 *  当程序发生不可控的错误时，通常做法是通知用户并中止程序的执行。
 *  Error是throwable的子类，代表编译时间和系统错误，用于指示合理的应用程序不应该试图捕获的严重问题。
 *  Error由Java虚拟机生成并抛出，包括动态链接失败，虚拟机错误等。程序对其不做处理。
 *
 *  Exception一般分为Checked异常和Runtime异常， Java认为Checked异常都是可以被处理的异常，
 *  所以Java程序必须显示处理Checked异常，否则该程序在编译时就会发生错误无法编译
 *  我们比较熟悉的Checked异常有Java.lang.ClassNotFoundException Java.lang.NoSuchMetodException java.io.IOException
 *
 *  Runtime 如除数是0和数组下标越界等，其产生频繁，处理麻烦，若显示申明或者捕获将会对程序的可读性和运行效率影响很大。
 **/
public class ThrowablesProgram {
    @Test
    public void throwables(){
    }
}
