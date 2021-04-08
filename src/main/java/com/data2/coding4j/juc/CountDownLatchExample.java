package com.data2.coding4j.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author wanglei
 *
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(new Runnable1("爸爸")).start();
        latch.countDown();
        new Thread(new Runnable1("妈妈")).start();
        latch.countDown();

        latch.await();//底层AQS实现； 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行

        System.out.println(latch.getCount());//count就是抽象队列同步器AQS内部的同步状态变量state
        System.out.println("有了你");
    }

}

class Runnable1 implements Runnable {
    public String name;

    public Runnable1(String str) {
        name = str;
    }

    @Override
    public void run() {
        System.out.println("有了：" + name);
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
        }
    }

}