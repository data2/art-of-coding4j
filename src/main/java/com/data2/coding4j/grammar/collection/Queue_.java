/**
 * FileName:   Queue.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.grammar.collection;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queue_ {
    
    @Test
    public void testQueue(){
        Queue<String> q = new PriorityQueue<String>();
        //Queue继承自Collection的方法 ,会抛异常，不建议使用
        q.add("a");
        q.remove();
        //Queue自己的方法,返回boolean值，不会抛出异常
        q.offer("b");
        q.peek();//取出队首元素，不删除
        q.poll();//取出队首元素，删除
    }
    
    @Test
    public void testDeque(){
        //双向队列
        Deque<String> q = new LinkedList<String>();
        q.offer("b");
        q.offerFirst("a");
        q.offerLast("c");
        System.out.println(q);
        System.out.println(q.peek());;//取出队首元素，不删除
        System.out.println(q.peekLast());;//取出队首元素，不删除
        q.poll();//取出队首元素，删除
        System.out.println(q.pollLast());
    }
}
