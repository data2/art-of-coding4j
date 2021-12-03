package com.data2.coding4j.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author wanglei
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(new Parent(latch,"爸爸")).start();
        new Thread(new Parent(latch,"妈妈")).start();

        latch.await();//底层AQS实现； 调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行

        System.out.println(latch.getCount());//count就是抽象队列同步器AQS内部的同步状态变量state
        System.out.println("有了你");
    }


    static class Parent implements Runnable {
        private String name;
        CountDownLatch latch;

        public Parent(CountDownLatch latch, String name) {
            this.name = name;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("有了：" + name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            latch.countDown();
        }

    }

}
