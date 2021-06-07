package com.data2.coding4j.juc.produceconsumer;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConditionImpl {
    static PriorityQueue<String> queue = new PriorityQueue<String>();

    ReentrantLock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();

    int length = 10;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        ReentrantLockConditionImpl obj = new ReentrantLockConditionImpl();
        for (int i = 0; i < 10; i++) {
            es.submit(obj.new Producer());
            es.submit(obj.new Consumer());
        }
        System.out.println(ReentrantLockConditionImpl.getQueue().size());

    }

    public static PriorityQueue<String> getQueue() {
        return queue;
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            lock.lock();
            System.out.println("producer lock");
            try {
                while (queue.size() == length) {
                    producer.await();
                }
                queue.offer("s");
                System.out.println("producer:" + "s");
                consumer.signalAll();
                System.out.println("producer signal all");
            } catch (Exception e) {
                lock.unlock();
            }
            System.out.println("producer unlock");
        }
    }

    class Consumer implements Runnable {
        public void run() {
            lock.lock();
            System.out.println("consumer lock");
            try {
                while (queue.size() == 0) {
                    consumer.await();
                }
                System.out.println("consumer:" + queue.poll());
                producer.signalAll();
                System.out.println("consumer signal all");
            } catch (Exception e) {
                lock.unlock();
            }
            System.out.println("consumer unlock");
        }
    }

}
