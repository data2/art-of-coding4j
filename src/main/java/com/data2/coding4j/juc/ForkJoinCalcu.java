/**
 * FileName:   ForkJoinCalcu.java
 *
 * @Description fork join
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCalcu {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int re = pool.invoke(new SumTask(3, 10));
        System.out.println(re);
    }

}

class SumTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 1L;

    int from;
    int to;

    public SumTask(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {
        if (to - from < 6) {
            return (to + from) / 2 * (to - from);
        }
        int isInteger = (to + from) % 2;
        int middle = 0;
        if (isInteger == 1) {
            middle = (to + from - 1) / 2;
        } else {
            middle = (to + from) / 2;
        }
        SumTask task1 = new SumTask(from, middle);
        SumTask task2 = new SumTask(middle, to);
        task1.fork();
        task2.fork();
        return task1.join() + task2.join();
    }

}
