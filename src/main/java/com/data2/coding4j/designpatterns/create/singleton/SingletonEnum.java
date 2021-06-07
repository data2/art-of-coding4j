package com.data2.coding4j.designpatterns.create.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum SingletonEnum {
    SINGLETON_ENUM;
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        final CountDownLatch latch = new CountDownLatch(800);
        final SingletonEnum instance = SingletonEnum.SINGLETON_ENUM;
        for (int j = 0; j < 800; j++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
//                    System.out.println(instance == SingletonEnum.SINGLETON_ENUM);
                    SingletonEnum.SINGLETON_ENUM.incr();
                    latch.countDown();

                }

            });

        }
        latch.await();
        System.out.println(SingletonEnum.SINGLETON_ENUM.getI());
    }

    synchronized void incr() {
        i = i + 1;
    }

    public int getI() {
        return i;
    }

}
