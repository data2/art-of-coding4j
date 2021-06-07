package com.data2.coding4j.guava.concurrency.jdk;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanglei on 2016/10/13.
 */
public class ExecutorServiceDemo {
    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Runnable() {
            public void run() {
                System.out.println("runable job running.");
            }
        });
        executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                System.out.println("callable job running.");
                return null;
            }
        });
        executorService.shutdown();
    }
}
