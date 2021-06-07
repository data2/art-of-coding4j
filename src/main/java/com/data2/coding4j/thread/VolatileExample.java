package com.data2.coding4j.thread;

public class VolatileExample {

    public static volatile int i = 10;

    public static void main(String[] args) throws InterruptedException {
        final RMB rmb = new RMB();
        new Thread(new Runnable() {

            @Override
            public void run() {
                rmb.get();
            }
        }).start();

        Thread.currentThread().sleep(1000);
        new Thread(new Runnable() {

            @Override
            public void run() {
                rmb.set();
            }
        }).start();

    }

}

class RMB {

    volatile long money = 99;

    public long get() {
        while (money != 100) {
            System.out.println("没到100");
        }
        System.out.println("100了");
        return money;
    }

    public void set() {
        money = money + 1;
    }
}