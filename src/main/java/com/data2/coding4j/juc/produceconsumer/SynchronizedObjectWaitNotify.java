package com.data2.coding4j.juc.produceconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynchronizedObjectWaitNotify {
    // 优先级阻塞队列 - 无界
    // private static PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>();
    // 有界阻塞队列
    private final static Integer QUEUE_SIZE = 10;
    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

    public static void main(String[] args) throws InterruptedException {
        // create pool
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10,
                60, TimeUnit.SECONDS,
                new PriorityBlockingQueue<>(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 1; i++) {
            // pool.execute（runnable），没有返回
            pool.execute(new Producer());
            // pool submit（runnable callable），有返回future
            pool.submit(new Consumer());
        }

        Thread.sleep(20000000);
        System.out.println(queue.size());

    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("producer lock");
                synchronized (queue) {
                    if (queue.size() == QUEUE_SIZE) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        String s = new Random().nextInt() + "";
                        System.out.println("producer > :"+s);
                        queue.put(s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.notify();
                }
                System.out.println("producer unlock");
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("consumer lock");
                synchronized (queue) {
                    // queue is empty, await.
                    while (queue.size() == 0) {
                        System.out.println("consumer await..");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // queue not empty, consumer.
                    System.out.println("consumer:" + queue.poll());
                    // consumer done, signal
                    queue.notify();
                }
                System.out.println("consumer unlock");
            }
        }
    }

}
