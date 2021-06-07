/**
 * FileName:   JvmParamsConfigTest.java
 *
 * @Description JVM 参数
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.jvm.oom;

import org.junit.Test;

/**
 * 执行前配置jvm参数 
 * -Xms60m 
 * -Xmx60m 
 * -Xmn20m 
 * -XX:NewRatio=2 
 * -XX:SurvivorRatio=8
 * -XX:PermSize=30m 
 * -XX:MaxPermSize=30m 
 * -XX:+PrintGCDetails
 * 注意 ：PermSize永久代的概念在jdk1.8中已经不存在了，取而代之的是metaspace元空间！！
 */
public class JvmParamsConfigTest {

    @Test
    public void testJVM() throws Exception {
        Integer M = new Integer(1024 * 1024 * 1); // 单位, 兆(M)
        @SuppressWarnings("unused")
        byte[] bytes = new byte[1 * M]; // 申请 1M 大小的内存空间
        bytes = null; // 断开引用链
        System.gc(); // 通知 GC 收集垃圾
        System.out.println(); //
        bytes = new byte[1 * M];  //重新申请 1M 大小的内存空间                      
        bytes = new byte[1 * M];  //再次申请 1M 大小的内存空间                     
        System.gc();
        System.out.println();
        bytes = new byte[18 * M];
        System.gc();

    }
}
