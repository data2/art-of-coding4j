/**
 * FileName:   AtomicTest.java
 * @Description 原子类
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.juc;

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

    //单例模式
    private AtomicExample(){}
    public static AtomicExample getInstance(){
        return Inner.atomicExample;
    }

    //Atomic并发安全，内部同步状态value volatile修饰保证可见性，底层unsafe类提供的cas操作保证原子性
    AtomicLong seq = new AtomicLong(0);
    public long get(){
        long l = seq.getAndIncrement();
        System.out.println(l);
        return l;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(int i = 0 ; i < 1000 ; i++){
            executorService.submit(new TestRunner());
        }
    }

    static class Inner{
        static AtomicExample atomicExample = new AtomicExample();
    }
}

class TestRunner implements Runnable{
    public void run(){
        AtomicExample.getInstance().get();
    }
}
