/**
 * FileName:   ListTest.java
 *
 * @Description list practise
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.grammar.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public class List_ {

    @Test
    @SuppressWarnings("unused")
    public void testLinkedList() {
        //LinkedList实现List接口、Deque接口（双向队列）
        LinkedList<String> list = new LinkedList<String>();
    }

    @Test
    public void testStack() {
        //后进先出
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push(null);//允许空值null
        System.out.println(stack.pop());//取出栈顶元素 并且删除
        System.out.println(stack.peek());//取出栈顶元素 并且不删除
        System.out.println(stack.size());
    }


    @Test
    public void testListIterator() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("aa");
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            if (it.next().equals("a")) {
                it.add("aaa");//单线程下Okay.
                //list.add("aaa");//ConcurrentModificationException
            }
        }
        System.out.println(list);
    }


    @Test
    public void testCopyOnWriteArrayList() throws InterruptedException {
        final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        list.add("a");
        list.add("aa");
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            if (it.next().equals("a")) {
                list.add("aaa");//Okay
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        list.add("aaaa");//Okay 并发安全的，但是采用复制的方法，cow性能不高
                    }
                }).start();
                Thread.sleep(2000);
            }
        }
        System.out.println(list);
    }

}
