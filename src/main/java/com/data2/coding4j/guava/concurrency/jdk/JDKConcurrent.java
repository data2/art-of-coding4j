package com.data2.coding4j.guava.concurrency.jdk;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by wanglei on 2016/10/13.
 * java.util.concurrent 包含许多线程安全、测试良好、高性能的并发构建块。
 * <p>
 * 什么是线程？
 * 所有重要的操作系统都支持进程的概念 -- 独立运行的程序，在某种程度上相互隔离。
 * 线程有时称为 轻量级进程。与进程一样，它们拥有通过程序运行的独立的并发路径，并且每个线程都有自己的程序计数器，称为堆栈和本地变量。
 * 然而，线程存在于进程中，它们与同一进程内的其他线程共享内存、文件句柄以及每进程状态。
 * 今天，几乎每个操作系统都支持线程，允许执行多个可独立调度的线程，以便共存于一个进程中。
 * 因为一个进程中的线程是在同一个地址空间中执行的，所以多个线程可以同时访问相同对象，并且它们从同一堆栈中分配对象。
 * 虽然这使线程更易于与其他线程共享信息，但也意味着您必须确保线程之间不相互干涉。
 * 正确使用线程时，线程能带来诸多好处，其中包括更好的资源利用、简化开发、高吞吐量、更易响应的用户界面以及能执行异步处理。
 */
public class JDKConcurrent {
    @Test
    public void test() throws UnsupportedEncodingException {
//        System.out.println(URLDecoder.decode("http://123.125.97.242:8300/DapWeb-0.0.1/dap/pay.do?payAmount=2000&extend=jDJoXA78IYjp1VizT8MVWnUsQzimsY9WTQy/V7EhGQs0Me6bEwdFeP4aqPtMeBwzhlXiA23831+3l05tNyhhco1VaGBUOdRESP5WUWAlkU3GUhv6xUomh1UWFHxwF+dTIpuaPIHm3BIK+Q/73nxDMtRrVOE955fqW+0t+cJoETg=&payOrgCode=01&payDeadline=20161014155124&dapMerchantId=dapm0000000003&notifyURL=http://123.125.97.242:8300/NpfMobilePayfee/payfeeService.do&merchantOrderNo=20161014152114080900&keyVersion=01&redirectURL=http://123.125.97.242:8300/NpfMobilePayfee/payfeeService.do&businessCode=wap&payRequestTime=20161014152124&signMsg=2A124271890491C8CAB8494CBF5E5A7474AB92DB&goodsDescription=沃钱包手机充值&payMethodCode=wozf_wap&goodsName=手机充值&designatedPayMethod=1", "GBK"));
        String s = "我爱你";
        System.out.println(System.getProperties());
        System.out.println(new String(s.getBytes("UTF-8"), ""));

    }

}
