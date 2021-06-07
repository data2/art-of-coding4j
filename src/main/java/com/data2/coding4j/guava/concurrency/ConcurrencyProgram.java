package com.data2.coding4j.guava.concurrency;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wanglei on 2016/10/12.
 */
public class ConcurrencyProgram {

    public static void main(String[] args) {
        // Guava封装后带有执行结束监听任务执行结束的功能
        ExecutorService executorService =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));

        ListenableFuture<String> listenableFuture = (ListenableFuture<String>) executorService
                .submit(new Callable<String>() {
                    public String call() throws Exception {
                        return "task success ";
                    }
                });

        /* Futrue初始版本

        // JDK 自带线程池
        //ExecutorService executor = Executors.newCachedThreadPool();

        // JDK Future
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return 1;
            }
        });

        // JDK Future真正获取结果的地方
        try {
            Integer count = future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        /* listenableFuture 结束监听版本
        // 相比JDK的Future等待结果， Guava采用监听器在任务完成时调用
        // 但是有个缺陷， 对最后完成的结果没法对操作成功/失败进行处理， 即run方法没返回值
        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                System.out.println("运行完成");
            }
        }, executorService);*/

        // 运行成功，将会返回 "task success successfully"  解决了listenableFuture 结束监听版本不能对结果进行操作问题
        FutureCallbackImpl callback = new FutureCallbackImpl();
        // 和计算结果同步运行
        //Futures.addCallback(listenableFuture, callback);

        //如果计算较大， 结果的访问使用异步  将会使用executorService线程去异步执行
        Futures.addCallback(listenableFuture, callback, executorService);

        System.out.println(callback.getCallbackResult());


    }

}

class FutureCallbackImpl implements FutureCallback<String> {
    private StringBuilder builder = new StringBuilder();

    public void onSuccess(String result) {
        builder.append(result).append("successfully");
    }

    public void onFailure(Throwable t) {
        builder.append(t.toString());
    }

    public String getCallbackResult() {
        return builder.toString();
    }
}
