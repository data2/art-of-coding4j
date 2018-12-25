/**
 * FileName:   CyclicBarrierTest.java
 * @Description 同步辅助类 - cyclicbarrier
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch和CyclicBarrier都能够实现线程之间的等待，
 * 
 * <p>只不过它们侧重点不同：CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 * 而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；<p>
 * 
 * <p>另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。</p>
 * 
 * <p>Thread类实现了Runnable接口！！！！</p>
 * 
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(5, new Runnable() {
            
            @Override
            public void run() {
                System.out.println("终于执行最后的任务了 ^_^");
            }
        });
        
        ExecutorService es = Executors.newFixedThreadPool(20);
        for(int i = 0 ; i < 5; i++){
            es.submit(new BarrierThread("thread" + i, cb));
        }
    }
}
class BarrierThread extends Thread{
    
    private String threadName;
    private CyclicBarrier cb;
    public BarrierThread(String threadName, CyclicBarrier cb) {
        this.threadName = threadName;
        this.cb = cb;
    }
    
    @Override
    public void run() {
        System.out.println("开始执行任务" + threadName);
        System.out.println("执行任务完成" + threadName + "=====");
        try {
            /**每执行完一项任务就通知障碍器 **/
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
