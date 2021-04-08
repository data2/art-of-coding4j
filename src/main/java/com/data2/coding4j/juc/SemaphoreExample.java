/**
 * FileName:   SemaphoreTest.java
 *
 * @Description 信号量 对共享资源的控制一种控制
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量是用来对某一共享资源所能访问的最大个数进行控制
 * <p>
 * Semaphore实现的功能就类似厕所有5个坑，假如有10个人要上厕所，那么同时只能有多少个人去上厕所呢？
 * 同时只能有5个人能够占用，当5个人中 的任何一个人让开后，其中等待的另外5个人中又有一个人可以占用了。
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5, true);
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            es.submit(new WcPerson("people-" + i, semaphore));
        }
    }
}

class WcPerson implements Runnable {

    private String name;
    private Semaphore semaphore;

    public WcPerson(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            //底层AQS实现
            //可中断
            boolean ok = semaphore.tryAcquire(5, TimeUnit.SECONDS);//阻塞等待5s
            if (ok) {
                System.out.println(name + "开始wc");
                Thread.sleep(10000);

                //可重入锁
                semaphore.tryAcquire();
                System.out.println(name + "带着孩子上厕所呢");
                semaphore.release();

                System.out.println(name + "完成wc");
            } else {
                System.out.println(name + "等了5s没上成放弃了");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

}
