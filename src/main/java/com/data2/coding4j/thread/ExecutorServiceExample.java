package com.data2.coding4j.thread;

import java.util.concurrent.*;

/**
 * @author wanglei
 * <p>
 * <p>
 * Executor
 * 框架包括：线程池，Executor，Executors，ExecutorService，CompletionService
 * ，Future，Callable 等。
 * <p>
 * 任务分两类：一类是实现了 Runnable 接口的类，一类是实现了 Callable 接口的类。 两者都可以被
 * ExecutorService 执行，但是 Runnable 任务没有返回值，而 Callable 任务有返回值。 并且 Callable
 * 的 call()方法只能通过 ExecutorService 的 submit(Callable task) 方法来执行，并且返回一个
 * Future，是表示任务等待完成的 Future。
 * <p>
 * <p>
 * Runnable 不会返回结果，并且无法抛出经过检查的异常而 Callable 又返回结果，而且当获取返回结果时可能会抛出异常。
 */
public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建固定大小的线程池
        ExecutorService es = Executors.newFixedThreadPool(5);

        // runnable
        Future f = es.submit(new Runnable() {

            @Override
            public void run() {
                System.out.println("runnable");
            }
        });

        f.isDone();
        f.isCancelled();

        // callable
        Future<String> f1 = es.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "call";
            }
        });
        System.out.println(f1.get());

        // 创建自定义线程池
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
        ThreadPoolExecutor t = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, bqueue);
        // corePoolSize：线程池中所保存的核心线程数，包括空闲线程。

        // maximumPoolSize：池中允许的最大线程数。

        // keepAliveTime：线程池中的空闲线程所能持续的最长时间。

        // unit：持续时间的单位。

        // workQueue：任务执行前保存任务的队列，仅保存由 execute 方法提交的 Runnable 任务。
        t.execute(new Runnable() {

            @Override
            public void run() {

            }
        });
        t.shutdown();
        // 当试图通过 excute 方法讲一个 Runnable 任务添加到线程池中时，按照如下顺序来处理：

        // 如果线程池中的线程数量少于 corePoolSize，即使线程池中有空闲线程，也会创建一个新的线程来执行新添加的任务；

        // 如果线程池中的线程数量大于等于 corePoolSize，但缓冲队列 workQueue 未满，则将新添加的任务放到 workQueue
        // 中，按照 FIFO 的原则依次等待执行（线程池中有线程空闲出来后依次将缓冲队列中的任务交付给空闲的线程执行）；

        // 如果线程池中的线程数量大于等于 corePoolSize，且缓冲队列 workQueue 已满，但线程池中的线程数量小于
        // maximumPoolSize，则会创建新的线程来处理被添加的任务；

        // 如果线程池中的线程数量等于了 maximumPoolSize，有 4 种才处理方式（该构造方法调用了含有 5
        // 个参数的构造方法，并将最后一个构造方法为 RejectedExecutionHandler 类型，它在处理线程溢出时有 4
        // 种方式，这里不再细说，要了解的，自己可以阅读下源码）。
        // 总结起来，也即是说，当有新的任务要处理时，先看线程池中的线程数量是否大于 corePoolSize，再看缓冲队列 workQueue
        // 是否满，最后看线程池中的线程数量是否大于 maximumPoolSize。

    }
}
