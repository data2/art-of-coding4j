package com.data2.coding4j.juc.produceconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition {
    // 优先级阻塞队列 - 无界
    // private static PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>();
    // 有界阻塞队列
    private final static Integer QUEUE_SIZE = 10;
    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition notfull = lock.newCondition();
    private static Condition notempty = lock.newCondition();

    int length = 10;

    public static void main(String[] args) {
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

        System.out.println(queue.size());

    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("producer lock");
                lock.lock();
                try {
                    while (queue.size() == QUEUE_SIZE) {
                        notfull.await();
                    }
                    queue.offer("s");
                    System.out.println("producer:" + "s");
                    notempty.signalAll();
                    System.out.println("producer signal all");
                } catch (Exception e) {
                } finally {
                    lock.unlock();
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
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        notempty.await();
                    }
                    System.out.println("consumer:" + queue.poll());
                    notfull.signalAll();
                    System.out.println("consumer signal all");
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
                System.out.println("consumer unlock");
            }
        }
    }

}
