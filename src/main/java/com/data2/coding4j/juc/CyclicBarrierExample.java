package com.data2.coding4j.juc;

import java.util.concurrent.*;

/**
 * CountDownLatch和CyclicBarrier都能够实现线程之间的等待，
 *
 * <p>只不过它们侧重点不同：CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 * 而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；<p>
 *
 * <p>另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。</p>
 *
 * <p>Thread类实现了Runnable接口！！！！</p>
 */
public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("大家一起开会！");
            }
        });

        ThreadPoolExecutor pool = new ThreadPoolExecutor(5,10,60,TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 5; i++) {
            pool.submit(new MeetPerson("person-" + i, cb));
        }
    }


    static class MeetPerson implements Runnable {

        private String name;
        private CyclicBarrier cb;

        public MeetPerson(String name, CyclicBarrier cb) {
            this.name = name;
            this.cb = cb;
        }

        @Override
        public void run() {
            /**每执行完一项任务就通知障碍器await
             * 因为有通知，所以底层通过reentrantlock的condition实现
             */
            System.out.println(name + "来到了会议室");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}