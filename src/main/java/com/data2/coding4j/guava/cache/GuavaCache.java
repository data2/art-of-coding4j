package com.data2.coding4j.guava.cache;

import com.data2.coding4j.guava.collections.ParentCollection;
import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanglei on 2016/10/12.
 * guava cache.
 */
public class GuavaCache extends ParentCollection{
    @Test
    public void cache(){
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                //1、基于容量的回收（size-based eviction）
                //如果要规定缓存项的数目不超过固定值，只需使用 CacheBuilder.maximumSize(long)。
                //缓存将尝试回收最近没有使用或总体上很少使用的缓存项。
                .maximumSize(100)
                //2、定时回收（Timed Eviction）
                .expireAfterAccess(1, TimeUnit.DAYS)//缓存项在给定时间内没有被读/写访问，则回收。
                .expireAfterWrite(2, TimeUnit.DAYS)//缓存项在给定时间内没有被写访问（创建或覆盖），则回收
                .refreshAfterWrite(5, TimeUnit.MINUTES)//通过定时刷新可以让缓存项保持可用
                //3、移除监听器
                .removalListener(new RemovalListener<Object, Object>() {
                    public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
                        printLog("你咋把我的缓存妹妹拿去用了，呜呜呜呜");
                    }
                })
                .build(new CacheLoader<String, String>() {

                    public String load(String o) throws Exception {
                        printLog("缓存中不存在，从本地加载。。");
                        return "wang";
                    }

                });
        try {
            printLog(cache.get("a").toString());
            printLog(cache.get("a").toString());
            printLog(cache.get("b").toString());
            printLog(cache.get("b").toString());
            System.out.println(cache.asMap().entrySet().toString());
            //4、显式清除
            cache.invalidateAll();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //5、统计
        System.out.println(cache.stats().hitCount());//缓存命中率
        System.out.println(cache.stats().averageLoadPenalty());//加载新值的平均时间，单位为纳秒；

        //6.asMap 视图
        System.out.println(cache.asMap().entrySet().toString());
//        Cache<Object, Object> cache2 = CacheBuilder.newBuilder().build();
//        try {
//            System.out.println(cache2.get("a", new Callable<Object>() {
//                public Object call() throws Exception {
//                    System.out.println("缓存中不存在，从本地加载。。");
//                    return "lei";
//                }
//            }));
//            System.out.println(cache2.get("a", new Callable<Object>() {
//                public Object call() throws Exception {
//                    System.out.println("缓存中不存在，从本地加载。。");
//                    return "lei";
//                }
//            }));
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }







    }
}