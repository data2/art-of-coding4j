package com.data2.coding4j.thread;

import java.util.Random;

/**
 * Created by wanglei on 2018/7/5.
 */
public class ThreadLocalExample {

    public static void main(String[] args) {
        new Test().start();
        new Test().start();
    }

    static class Test extends Thread {

        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set(new Random().nextInt(1000));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(threadLocal.get());
        }
    }

}