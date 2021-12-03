package com.data2.coding4j.designpatterns.create.singleton;

import java.util.concurrent.*;

public enum SingletonEnum {
    SINGLETON_ENUM;
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(10);
        final CountDownLatch latch = new CountDownLatch(800);
        final SingletonEnum instance = SingletonEnum.SINGLETON_ENUM;
        for (int j = 0; j < 800; j++) {
            threadPoolExecutor.submit(new Runnable() {
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
