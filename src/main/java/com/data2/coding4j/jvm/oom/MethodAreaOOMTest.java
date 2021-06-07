/**
 * FileName:   OutOfMTest.java
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
 * 利用方法区的常量池  造成方法区的内存溢出OOM
 */
public class MethodAreaOOMTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}
