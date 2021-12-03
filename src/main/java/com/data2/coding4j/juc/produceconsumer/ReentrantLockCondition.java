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
    /**
     * 1、所有的生产者和消费者会竞争锁lock, reentrantlock底层维护一个队列
     * 2、每个Condition会有自己单独的等待队列
     *     比如生产者消费者可能是多个
     *          notFull条件Condition会维护一个所有的生产者线程队列；
     *          notEmpty条件condition也会维护一个消费者线程队列
     */

    // 此处2个condition.
    private static Condition notfull = lock.newCondition();
    private static Condition notempty = lock.newCondition();

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
                lock.lock();
                try {
                    // queue is full, await.
                    while (queue.size() == QUEUE_SIZE) {
                        notfull.await();
                    }
                    // queue is not full, produce
                    queue.put("s");
                    System.out.println("producer:" + "s");
                    // produce done, signal.
                    notempty.signalAll();
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
                    // queue is empty, await.
                    while (queue.size() == 0) {
                        System.out.println("consumer await..");
                        notempty.await();
                    }
                    // queue not empty, consumer.
                    System.out.println("consumer:" + queue.take());
                    // consumer done, signal
                    notfull.signalAll();
                } catch (Exception e) {
                } finally {
                    lock.unlock();
                }
                System.out.println("consumer unlock");
            }
        }
    }

}
