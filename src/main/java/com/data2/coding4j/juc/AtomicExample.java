/**
 * FileName:   AtomicTest.java
 *
 * @Description 原子类
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wanglei
 * Atomic会产生ABA问题（更新）
 *  AtomicStampedReference a = new AtomicStampedReference();
 *  can promise no ABA problem (this can happened in AtomicLong)
 *  it use version.
 *
 */
public class AtomicExample {

    //Atomic并发安全，内部同步状态value volatile修饰保证可见性，底层unsafe类提供的cas操作保证原子性
    private AtomicLong seq = new AtomicLong(0);

    //单例模式
    private AtomicExample() {
    }

    public static AtomicExample getInstance() {
        return Inner.atomicExample;
    }

    public long get() {
        long l = seq.getAndIncrement();
        System.out.println(l);
        return l;
    }

    // 静态内部类 直接初始化创建对象
    private static class Inner {
        private static AtomicExample atomicExample = new AtomicExample();
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                AtomicExample.getInstance().get();
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                AtomicExample.getInstance().get();
            }
        }).start();
    }


}


