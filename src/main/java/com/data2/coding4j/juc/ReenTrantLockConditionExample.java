/**
 * FileName:   ReenTrantLockConditionTest.java
 * @Description wait notify 
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockConditionExample {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    System.out.println("线程A获得锁");
                    System.out.println("线程A开始等待信号");
                    condition.await();
                } catch (Exception e) {
                } 
                System.out.println("线程A获得了信号通知");
                reentrantLock.unlock();
            }
        }).start();
        
        Thread.sleep(3000);
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    System.out.println("线程B获得锁");
                    condition.signalAll();
                } catch (Exception e) {
                } 
                System.out.println("线程B发出了信号通知");
                reentrantLock.unlock();
            }
        }).start();;
    }

}
