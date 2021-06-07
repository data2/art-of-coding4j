/**
 * FileName:   Snippet.java
 *
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanglei
 * 循环生成对象 造成堆内存溢出OOM
 */
public class HeapOOMTest {
    /**
     *
     */
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        while (true) {
            list.add(new Object());
        }
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}

